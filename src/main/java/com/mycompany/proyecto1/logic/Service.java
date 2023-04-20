/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.logic;

import com.mycompany.proyecto1.data.CategoriaDao;
import com.mycompany.proyecto1.data.ClienteDao;
import com.mycompany.proyecto1.data.CoberturaDao;
import com.mycompany.proyecto1.data.MarcaDao;
import com.mycompany.proyecto1.data.ModeloDao;
import com.mycompany.proyecto1.data.PolizaDao;
import com.mycompany.proyecto1.data.RelDatabase;
import com.mycompany.proyecto1.data.UsuarioDao;
import java.util.List;

/**
 *
 * @author ribre
 */
public class Service {

    RelDatabase relDatabase;
    UsuarioDao usuarioDao;
    ClienteDao clienteDao;
    PolizaDao polizaDao;
    MarcaDao marcaDao;
    ModeloDao modeloDao;
    CategoriaDao categoriaDao;
    CoberturaDao coberturaDao;

    private static Service uniqueInstance;

    public static Service instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Service();
        }
        return uniqueInstance;
    }

    private Service() {
        relDatabase = new RelDatabase();
        usuarioDao = new UsuarioDao(relDatabase);
        clienteDao = new ClienteDao(relDatabase);
        polizaDao = new PolizaDao(relDatabase);
        marcaDao = new MarcaDao(relDatabase);
        modeloDao = new ModeloDao(relDatabase);
        categoriaDao = new CategoriaDao(relDatabase);
        coberturaDao = new CoberturaDao(relDatabase);
    }

    public Usuario usuarioFind(String cedula, String clave) throws Exception {
        Usuario usuario = usuarioDao.read(cedula);
        if (usuario.getClave().equals(clave)) {
            return usuario;
        } else {
            return null;
        }
    }

    public Cliente clienteFind(Usuario usuario) throws Exception {
        return clienteDao.read(usuario.getCedula());
    }

    public Marca marcaFind(String nombre) throws Exception {
        return marcaDao.read(nombre);
    }

    public List<Marca> marcasFind() {
        List<Marca> marcas = marcaDao.findMarcas();
        return marcas;
    }

    public List<Modelo> modelosFind() {
        List<Modelo> modelos = modeloDao.findModelos();
        return modelos;
    }

    public List<Cliente> clienteFind() {
        List<Cliente> clientes = clienteDao.findClientes();
        return clientes;
    }

    public List<Poliza> cuentasFind(Cliente cliente) throws Exception {
        List<Poliza> polizas = polizaDao.findByCliente(cliente);
        for (Poliza e : polizas) {
            e.setCliente(cliente);
        }
        cliente.setPolizas(polizas);
        return polizas;
    }

    public void clienteUpdate(Cliente cliente) throws Exception {
        clienteDao.update(cliente);
    }

    public Poliza polizaFind(String numero) throws Exception {
        return polizaDao.read(numero);
    }

    public Modelo modeloFindByNombre(String nombre) throws Exception {
        return modeloDao.readByNombre(nombre);
    }

    public void clienteCreate(Cliente cliente) throws Exception {
        clienteDao.create(cliente);
    }

    public void usuarioCreate(Usuario usuario) throws Exception {
        usuarioDao.create(usuario);
    }

    public void usuarioUpdate(Usuario usuario) throws Exception {
        usuarioDao.update(usuario);
    }

    public List<Modelo> modelosFindByMarca(Integer numero) throws Exception {
        return modeloDao.readByMarca(numero);
    }
    
    public List<Cobertura> coberturasFindByCategoria(Integer numero) throws Exception {
        return coberturaDao.readByCategoria(numero);
    }

    public void marcaCreate(Marca marca) throws Exception {
        marcaDao.create(marca);
    }

    public void modeloCreate(Modelo modelo) throws Exception {
        modeloDao.create(modelo);
    }

    public List<Categoria> categoriasFind() {
        List<Categoria> categorias = categoriaDao.findCategorias();
        return categorias;
    }

    public void categoriaCreate(Categoria categoria) throws Exception {
        categoriaDao.create(categoria);
    }

    public void coberturaCreate(Cobertura cobertura) throws Exception {
        coberturaDao.create(cobertura);
    }

}

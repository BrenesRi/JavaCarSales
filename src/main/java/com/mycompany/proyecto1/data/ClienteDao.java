package com.mycompany.proyecto1.data;

import com.mycompany.proyecto1.logic.Cliente;
import com.mycompany.proyecto1.logic.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ribre
 */
public class ClienteDao {

    RelDatabase db;

    public ClienteDao(RelDatabase db) {
        this.db = db;
    }

    public Cliente read(String cedula) throws Exception {
        String sql = "SELECT c.*, u.clave, u.tipo "
                + "FROM Cliente c "
                + "JOIN Usuario u ON c.usuario = u.cedula "
                + "WHERE c.cedula = ?";
        PreparedStatement statement = db.prepareStatement(sql);
        statement.setString(1, cedula);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setCedula(rs.getString("cedula"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setTelefono(rs.getString("telefono"));
            cliente.setCorreo(rs.getString("correo"));
            cliente.setTarjeta(rs.getString("tarjeta"));

            Usuario usuario = new Usuario();
            usuario.setCedula(rs.getString("usuario"));
            usuario.setClave(rs.getString("clave"));
            usuario.setTipo(rs.getInt("tipo"));

            cliente.setUsuario(usuario);
            return cliente;
        } else {
            return null;
        }
    }

    public Cliente from(ResultSet rs, String alias) {
        try {
            Cliente e = new Cliente();
            e.setCedula(rs.getString(alias + ".cedula"));
            e.setNombre(rs.getString(alias + ".nombre"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void update(Cliente e) throws Exception {
        String sql = "update "
                + "Cliente "
                + "set nombre=? , "
                + " telefono=? , "
                + " correo=? , "
                + " tarjeta=? "
                + "where cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, e.getNombre());
        stm.setString(2, e.getTelefono());
        stm.setString(3, e.getCorreo());
        stm.setString(4, e.getTarjeta());
        stm.setString(5, e.getCedula());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cliente no existe");
        }

    }

    public void create(Cliente e) throws Exception {
        String sql = "insert into "
                + "Cliente "
                + "(cedula, nombre, telefono, correo, tarjeta, usuario) "
                + "values(?,?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, e.getCedula());
        stm.setString(2, e.getNombre());
        stm.setString(3, e.getTelefono());
        stm.setString(4, e.getCorreo());
        stm.setString(5, e.getTarjeta());
        stm.setString(6, e.getUsuario().getCedula());
        db.executeUpdate(stm);
    }

    public List<Cliente> findClientes() {
        List<Cliente> resultado = new ArrayList<>();
        try {
            String sql = "select * "
                    + "from "
                    + "Cliente e ";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            while (rs.next()) {
                resultado.add(from(rs, "e"));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
}

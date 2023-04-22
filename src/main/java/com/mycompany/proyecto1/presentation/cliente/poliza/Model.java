/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1.presentation.cliente.poliza;

import com.mycompany.proyecto1.logic.Cliente;
import com.mycompany.proyecto1.logic.Cobertura;
import com.mycompany.proyecto1.logic.Marca;
import com.mycompany.proyecto1.logic.Modelo;
import com.mycompany.proyecto1.logic.Poliza;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 *
 * @author Escinf
 */
public class Model{
    Poliza current;
    List<Marca> marcas;
    List<Modelo> modelos;
    List<Cobertura> coberturas;

    public Model() {
        current = new Poliza(0,"",0,"",new Cliente(),0, new Modelo(),0,"",0,new ArrayList<>());
        List<Marca> marcas = new ArrayList<>();
        List<Modelo> modelos = new ArrayList<>();
        List<Cobertura> coberturas = new ArrayList<>();
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public List<Cobertura> getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(List<Cobertura> coberturas) {
        this.coberturas = coberturas;
    }
    
    public Poliza getCurrent() {
        return current;
    }

    public void setCurrent(Poliza current) {
        this.current = current;
    }
}

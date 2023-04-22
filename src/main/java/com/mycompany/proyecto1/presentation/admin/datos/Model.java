/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.presentation.admin.datos;

import com.mycompany.proyecto1.logic.Cliente;
import com.mycompany.proyecto1.logic.Poliza;
import java.util.ArrayList;
import java.util.List;

public class Model {
    List<Cliente> clientes;
    Cliente current;
    List<Poliza> cuentas;
    Poliza seleccionado;

 public Model() {
        this.reset();
    }

    public void reset(){ 
        List<Cliente> rows = new ArrayList<>();      
        List<Poliza> rows2 = new ArrayList<>();   
        current=null;  
        seleccionado=null;
        this.setClientes(rows);
        this.setCuentas(rows2);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getCurrent() {
        return current;
    }

    public void setCurrent(Cliente current) {
        this.current = current;
    }

    public List<Poliza> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Poliza> cuentas) {
        this.cuentas = cuentas;
    }

    public Poliza getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Poliza seleccionado) {
        this.seleccionado = seleccionado;
    }
     
}
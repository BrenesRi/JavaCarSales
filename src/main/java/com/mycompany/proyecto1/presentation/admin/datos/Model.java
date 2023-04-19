/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.presentation.admin.datos;

import com.mycompany.proyecto1.logic.Cliente;
import java.util.ArrayList;
import java.util.List;

public class Model {
    List<Cliente> clientes;
    Cliente current;

 public Model() {
        this.reset();
    }

    public void reset(){ 
        List<Cliente> rows = new ArrayList<>();        
        current=null;  
        this.setClientes(rows);
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
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.presentation.admin.modelos;

import com.mycompany.proyecto1.logic.Modelo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ribre
 */
public class Model {
    List<Modelo> modelos;
    Modelo current;
    
    public Model() {
        this.reset();
    }
    
    public void reset(){ 
     List<Modelo> rows = new ArrayList<>();   
    current = null;
    this.setModelos(rows);
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public Modelo getCurrent() {
        return current;
    }

    public void setCurrent(Modelo current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "Model{" + "modelos=" + modelos + ", current=" + current + '}';
    }
    
}

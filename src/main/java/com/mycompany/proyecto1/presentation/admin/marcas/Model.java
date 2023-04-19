/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.presentation.admin.marcas;

import com.mycompany.proyecto1.logic.Marca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ribre
 */
public class Model {
    List<Marca> marcas;
    Marca current;
    
    public Model() {
        this.reset();
    }
    
    public void reset(){ 
     List<Marca> rows = new ArrayList<>();   
    current = null;
    this.setMarcas(rows);
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public Marca getCurrent() {
        return current;
    }

    public void setCurrent(Marca current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "Model{" + "marcas=" + marcas + ", current=" + current + '}';
    }
    
}

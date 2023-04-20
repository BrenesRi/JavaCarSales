/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.presentation.admin.coberturas;

import com.mycompany.proyecto1.logic.Cobertura;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin
 */
public class Model {
    List<Cobertura> coberturas;
    Cobertura current;
    
    public Model() {
        this.reset();
    }
    
    public void reset(){ 
     List<Cobertura> rows = new ArrayList<>();   
    current = null;
    this.setCoberturas(rows);
    }

    public List<Cobertura> getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(List<Cobertura> coberturas) {
        this.coberturas = coberturas;
    }

    public Cobertura getCurrent() {
        return current;
    }

    public void setCurrent(Cobertura current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "Model{" + "modelos=" + coberturas + ", current=" + current + '}';
    }
    
}

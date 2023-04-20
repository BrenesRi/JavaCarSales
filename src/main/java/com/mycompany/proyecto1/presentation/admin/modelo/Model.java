/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.presentation.admin.modelo;

import com.mycompany.proyecto1.logic.Marca;
import com.mycompany.proyecto1.logic.Modelo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin
 */
public class Model {
    Modelo current;
    List<Marca> marcas;

    public Model() {
        this.current = new Modelo("",new Marca(""));
        List<Marca> marcas = new ArrayList<>(); 
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public void reset(){
        setCurrent(new Modelo());
    }

    public Modelo getCurrent() {
        return current;
    }

    public void setCurrent(Modelo current) {
        this.current = current;
    }
      
}
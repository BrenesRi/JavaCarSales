/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.presentation.admin.modelo;

import com.mycompany.proyecto1.logic.Marca;
import com.mycompany.proyecto1.logic.Modelo;

/**
 *
 * @author Kevin
 */
public class Model {
    Modelo current;

    public Model() {
        this.current = new Modelo("",new Marca(""));
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
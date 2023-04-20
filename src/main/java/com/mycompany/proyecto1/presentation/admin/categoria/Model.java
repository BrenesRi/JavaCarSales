/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.presentation.admin.categoria;

import com.mycompany.proyecto1.logic.Categoria;

/**
 *
 * @author bermu
 */
public class Model {
    Categoria current;
    
    public Model() {
        this.current = new Categoria("");
    }
    
    public void reset(){
        setCurrent(new Categoria());
    }

    public Categoria getCurrent() {
        return current;
    }

    public void setCurrent(Categoria current) {
        this.current = current;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.presentation.admin.marca;

import com.mycompany.proyecto1.logic.Marca;

/**
 *
 * @author ribre
 */
public class Model {
    Marca current;

    public Model() {
        this.current = new Marca("");
    }
    
    public void reset(){
        setCurrent(new Marca());
    }

    public Marca getCurrent() {
        return current;
    }

    public void setCurrent(Marca current) {
        this.current = current;
    }
      
}

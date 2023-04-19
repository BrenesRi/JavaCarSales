/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.presentation.register;

import com.mycompany.proyecto1.logic.Cliente;
import com.mycompany.proyecto1.logic.Usuario;

/**
 *
 * @author Kevin
 */
public class Model {
    Cliente current;

    public Model() {
         this.current = new Cliente("","","","","",new Usuario());
    }
    
    public void reset(){
        setCurrent(new Cliente());
    }

    public Cliente getCurrent() {
        return current;
    }

    public void setCurrent(Cliente current) {
        this.current = current;
    }
}

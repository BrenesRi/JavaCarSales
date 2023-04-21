/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1.presentation.cliente.poliza;

import com.mycompany.proyecto1.logic.Cliente;
import com.mycompany.proyecto1.logic.Modelo;
import com.mycompany.proyecto1.logic.Poliza;
import java.util.ArrayList;
import java.util.Date;



/**
 *
 * @author Escinf
 */
public class Model{
    Poliza current;

    public Model() {
        current = new Poliza(0,"",0,new Date(),new Cliente(), new Modelo(),0,"",0,new ArrayList<>());
    }

    public Poliza getCurrent() {
        return current;
    }

    public void setCurrent(Poliza current) {
        this.current = current;
    }
}

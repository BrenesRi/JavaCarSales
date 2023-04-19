/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1.presentation.cliente.polizas;

import com.mycompany.proyecto1.logic.Poliza;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Escinf
 */
public class Model{
    List<Poliza> cuentas;
    Poliza seleccionado;

    public Model() {
        this.reset();
    }

    public void reset(){ 
        List<Poliza> rows = new ArrayList<>();        
        seleccionado=null;  
        this.setCuentas(rows);
    }
    
    public void setCuentas(List<Poliza> cuentas){
        this.cuentas =cuentas;    
    }

     public List<Poliza> getCuentas() {
        return cuentas;
    }

    public Poliza getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Poliza seleccionado) {
        this.seleccionado = seleccionado;
    }
}

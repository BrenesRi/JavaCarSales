/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.logic;

/**
 *
 * @author ribre
 */
public class Pc {
    Integer id;
    Integer poliza;
    Integer cobertura;

    public Pc() {
    }

    public Pc(Integer id, Integer poliza, Integer cobertura) {
        this.id = id;
        this.poliza = poliza;
        this.cobertura = cobertura;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPoliza() {
        return poliza;
    }

    public void setPoliza(Integer poliza) {
        this.poliza = poliza;
    }

    public Integer getCobertura() {
        return cobertura;
    }

    public void setCobertura(Integer cobertura) {
        this.cobertura = cobertura;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1.logic;

import java.util.Objects;
import java.util.Date;

/**
 *
 * @author Escinf
 */
public class Poliza {
    Integer numero;
    String placa;
    double valor;
    String auto;
    Date fecha;
    Cliente cliente;

    public Poliza() {
        this(0,"",0,"",new Date(),new Cliente());
    }

    public Poliza(Integer numero, String placa, double valor, String auto, Date fecha, Cliente cliente) {
        this.numero = numero;
        this.placa = placa;
        this.valor = valor;
        this.auto = auto;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Poliza other = (Poliza) obj;
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        return true;
    }
    
    
    
    
}

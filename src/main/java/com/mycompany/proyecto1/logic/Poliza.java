/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1.logic;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Escinf
 */
public class Poliza {
    Integer numero;
    String placa;
    double valor;
    Date fecha;
    Cliente cliente;
    Modelo modelo;
    List<Cobertura> coberturas;
         
    public Poliza() {
        this(0,"",0,new Date(),new Cliente(), new Modelo(), new ArrayList<>());
    }

    public Poliza(Integer numero, String placa, double valor, Date fecha, Cliente cliente, Modelo modelo, List<Cobertura> coberturas) {
        this.numero = numero;
        this.placa = placa;
        this.valor = valor;
        this.fecha = fecha;
        this.cliente = cliente;
        this.modelo = modelo;
        this.coberturas = coberturas;
    }
    

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public List<Cobertura> getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(List<Cobertura> coberturas) {
        this.coberturas = coberturas;
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

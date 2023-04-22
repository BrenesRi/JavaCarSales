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
    String fecha;
    Cliente cliente;
    int modelo;
    Modelo modeloOb;
    int anio;
    String pago;
    int costofinal;
    List<Cobertura> coberturas;
         
    public Poliza() {
        this(0,"",0,"",new Cliente(),0, new Modelo(),0,"",0,new ArrayList<>());
    }

    public Poliza(Integer numero, String placa, double valor, String fecha, Cliente cliente, int modelo, Modelo modeloOb, int anio, String pago, int costofinal, List<Cobertura> coberturas) {
        this.numero = numero;
        this.placa = placa;
        this.valor = valor;
        this.fecha = fecha;
        this.cliente = cliente;
        this.modelo = modelo;
        this.modeloOb = modeloOb;
        this.anio = anio;
        this.pago = pago;
        this.costofinal = costofinal;
        this.coberturas = coberturas;
    }


    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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

    public Modelo getModeloOb() {
        return modeloOb;
    }

    public void setModeloOb(Modelo modelo) {
        this.modeloOb = modelo;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }
    

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public int getCostofinal() {
        return costofinal;
    }

    public void setCostofinal(int costofinal) {
        this.costofinal = costofinal;
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

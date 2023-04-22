/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ribre
 */
public class Marca {
    Integer id;
    String nombre;
    List<Modelo> modelos;

    public Marca(String nombre) {
        this.nombre = nombre;
        modelos = new ArrayList<>();
    }

    public Marca() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    @Override
    public String toString() {
        return "Marca{" + "id=" + id + ", nombre=" + nombre + '}';
    }

    
}

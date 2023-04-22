/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.logic;

/**
 *
 * @author Kevin
 */
public class Cobertura {
  Integer id;
  String descripcion;
  Integer categoriaId;
  Categoria categoria;
  int costominimo;
  int porcentaje;

    public Cobertura(Integer id, String descripcion, Categoria categoria, int costominimo, int porcentaje) {
        this.id = id;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.costominimo = costominimo;
        this.porcentaje = porcentaje;
    }

    public Cobertura() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getCostominimo() {
        return costominimo;
    }

    public void setCostominimo(int costominimo) {
        this.costominimo = costominimo;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }
  
}

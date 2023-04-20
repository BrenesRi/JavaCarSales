/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.presentation.admin.categorias;

import com.mycompany.proyecto1.logic.Categoria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bermu
 */
public class Model {

    List<Categoria> categorias;
    Categoria current;

    public Model() {
        this.reset();
    }

    public void reset() {
        List<Categoria> rows = new ArrayList<>();
        current = null;
        this.setCategorias(rows);
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Categoria getCurrent() {
        return current;
    }

    public void setCurrent(Categoria current) {
        this.current = current;
    }
    
}

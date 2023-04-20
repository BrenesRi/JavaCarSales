/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.presentation.admin.cobertura;
import com.mycompany.proyecto1.logic.Categoria;
import com.mycompany.proyecto1.logic.Cobertura;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Kevin
 */
public class Model {
    Cobertura current;
    List<Categoria> categorias;

    public Model() {
        this.current = new Cobertura(0,"",new Categoria(),0,0);
        List<Categoria> categorias = new ArrayList<>(); 
    }
    

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void reset(){
        setCurrent(new Cobertura());
    }

    public Cobertura getCurrent() {
        return current;
    }

    public void setCurrent(Cobertura current) {
        this.current = current;
    }
      
}

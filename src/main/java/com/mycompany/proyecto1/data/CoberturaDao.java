/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.data;

import com.mycompany.proyecto1.logic.Cobertura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin
 */
public class CoberturaDao {
    RelDatabase db;

    public CoberturaDao(RelDatabase db) {
        this.db = db;
    }
    
    public List<Cobertura> findCoberturas() {
        List<Cobertura> resultado = new ArrayList<>();
        try {
            String sql = "select * "
                    + "from "
                    + "Cobertura e ";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            while (rs.next()) {
                resultado.add(from(rs, "e"));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    public Cobertura from(ResultSet rs, String alias) {
        try {
            Cobertura e = new Cobertura();
            e.setId(rs.getInt(alias + ".id"));
            e.setDescripcion(rs.getString(alias + ".descripcion"));
            e.setCostominimo(rs.getInt( alias + ".costominimo"));
            e.setPorcentaje(rs.getInt(alias + ".porcentaje"));
            e.setCategoriaId(rs.getInt(alias + ".categoria"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Cobertura readByNombre(String nombre) {
       Cobertura resultado = new Cobertura();
        try {
            String sql = "select * "
                    + "from "
                    + "Cobertura e "
                    + "where e.descripcion=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1,nombre);
            ResultSet rs = db.executeQuery(stm);
            if (rs.next()) {
            resultado.setId(Integer.valueOf(rs.getString("id")));
            resultado.setDescripcion(rs.getString("descripcion"));
            return resultado;
        } else {
            return null;
        }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    
    public void create(Cobertura e) throws Exception {
        String sql = "insert into "
                + "Cobertura "
                + "(descripcion,categoria,costominimo,porcentaje) "
                + "values(?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, e.getDescripcion());
        stm.setString(2, "" + e.getCategoria().getId());
        stm.setString(3, ""+e.getCostominimo());
        stm.setString(4,"" + e.getPorcentaje());
        
        db.executeUpdate(stm);
    }

    public List<Cobertura> readByCategoria(Integer numero) {
       List<Cobertura> resultado = new ArrayList<>();
        try {
            String sql = "select * "
                    + "from "
                    + "Cobertura e "
                    + "where e.categoria=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, ""+numero);
            ResultSet rs = db.executeQuery(stm);
            while (rs.next()) {
                resultado.add(from(rs, "e"));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    public List<Cobertura> findCobertura() {
        List<Cobertura> resultado = new ArrayList<>();
        try {
            String sql = "select * "
                    + "from "
                    + "Cobertura e ";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            while (rs.next()) {
                resultado.add(from(rs, "e"));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
}

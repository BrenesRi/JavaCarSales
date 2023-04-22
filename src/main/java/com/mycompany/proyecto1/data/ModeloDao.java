/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.data;

import com.mycompany.proyecto1.logic.Modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ribre
 */
public class ModeloDao {
    RelDatabase db;

    public ModeloDao(RelDatabase db) {
        this.db = db;
    }
    
    public List<Modelo> findModelos() {
        List<Modelo> resultado = new ArrayList<>();
        try {
            String sql = "select * "
                    + "from "
                    + "Modelo e ";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            while (rs.next()) {
                resultado.add(from(rs, "e"));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    public Modelo from(ResultSet rs, String alias) {
        try {
            Modelo e = new Modelo();
            e.setId(rs.getInt(alias + ".id"));
            e.setDescripcion(rs.getString(alias + ".descripcion"));
            e.setMarcaId(rs.getInt(alias +  ".marca"));
            
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }

    public List<Modelo> readByMarca(Integer numero) {
       List<Modelo> resultado = new ArrayList<>();
        try {
            String sql = "select * "
                    + "from "
                    + "Modelo e "
                    + "where e.marca=?";
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
    
    public Modelo readByNombre(String nombre) {
       Modelo resultado = new Modelo();
        try {
            String sql = "select * "
                    + "from "
                    + "Modelo e "
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
    
    public Modelo readById(int nombre) {
       Modelo resultado = new Modelo();
        try {
            String sql = "select * "
                    + "from "
                    + "Modelo e "
                    + "where e.id=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1,""+nombre);
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
    
    public void create(Modelo e) throws Exception {
        String sql = "insert into "
                + "Modelo "
                + "(descripcion,marca) "
                + "values(?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, e.getDescripcion());
        stm.setString(2, "" + e.getMarca().getId());
        db.executeUpdate(stm);
    }
}

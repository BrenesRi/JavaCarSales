/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.data;

import com.mycompany.proyecto1.logic.Marca;
import com.mycompany.proyecto1.logic.Modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author ribre
 */
public class MarcaDao {
    
    RelDatabase db;

    public MarcaDao(RelDatabase db) {
        this.db = db;
    }
    
    public List<Marca> findMarcas() {
        List<Marca> resultado = new ArrayList<>();
        try {
            String sql = "select * "
                    + "from "
                    + "Marca e ";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            while (rs.next()) {
                resultado.add(from(rs, "e"));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    public Marca from(ResultSet rs, String alias) {
        try {
            Marca e = new Marca();
            e.setId(rs.getInt(alias + ".id"));
            e.setNombre(rs.getString(alias + ".nombre"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public void create(Marca e) throws Exception {
        String sql = "insert into "
                + "Marca "
                + "(nombre) "
                + "values(?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, e.getNombre());
        db.executeUpdate(stm);
    }

    public Marca read(String nombre) {
        try {
            String sql = "select * "
                    + "from "
                    + "Marca e "
                    + "WHERE e.nombre = ?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, nombre);
            ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Marca resultado = new Marca();
            resultado.setId(Integer.valueOf(rs.getString("id")));
            resultado.setNombre(rs.getString("nombre"));
            resultado.setModelos((List<Modelo>) rs.getArray("modelos"));
            return resultado;
        } else {
            return null;
        }
        
        } catch (SQLException ex) {
            return null;
        }
    }
}

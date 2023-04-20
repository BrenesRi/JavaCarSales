/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.data;

import com.mycompany.proyecto1.logic.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bermu
 */
public class CategoriaDao {

    RelDatabase db;

    public CategoriaDao(RelDatabase db) {
        this.db = db;
    }

    public List<Categoria> findCategorias() {
        List<Categoria> resultado = new ArrayList<>();
        try {
            String sql = "select * "
                    + "from "
                    + "Categoria e ";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            while (rs.next()) {
                resultado.add(from(rs, "e"));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    public Categoria from(ResultSet rs, String alias) {
        try {
            Categoria e = new Categoria();
            e.setId(rs.getInt(alias + ".id"));
            e.setDescripcion(rs.getString(alias + ".descripcion"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void create(Categoria e) throws Exception {
        String sql = "insert into "
                + "Categoria "
                + "(descripcion) "
                + "values(?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, e.getDescripcion());
        db.executeUpdate(stm);
    }

    public Categoria read(String descripcion) {
        try {
            String sql = "select * "
                    + "from "
                    + "Categoria e "
                    + "WHERE e.id = ?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, descripcion);
            ResultSet rs = db.executeQuery(stm);
            if (rs.next()) {
                Categoria resultado = new Categoria();
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
}

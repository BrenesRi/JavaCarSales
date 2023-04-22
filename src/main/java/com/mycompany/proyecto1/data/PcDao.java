/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.data;

import com.mycompany.proyecto1.logic.Categoria;
import com.mycompany.proyecto1.logic.Cobertura;
import com.mycompany.proyecto1.logic.Pc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ribre
 */
public class PcDao {
    RelDatabase db;

    public PcDao(RelDatabase db) {
        this.db = db;
    }
    
    public List<Cobertura> read(String poliza) throws Exception {
        List<Cobertura> coberturas = new ArrayList<>();
        try {
        String sql = "SELECT u.* "
                + "FROM Pc c "
                + "JOIN Cobertura u ON c.cobertura = u.id "
                + "WHERE c.poliza = ?";
        PreparedStatement statement = db.prepareStatement(sql);
        statement.setString(1, poliza);
        ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    Cobertura cobertura = new Cobertura();
                    cobertura.setId(rs.getInt("id"));
                    cobertura.setDescripcion(rs.getString("descripcion"));
                    cobertura.setCostominimo(rs.getInt("costominimo"));
                    cobertura.setPorcentaje(rs.getInt("porcentaje"));
                    
                    Categoria categoria = new Categoria();
                    categoria.setId(rs.getInt("categoria"));
                    
                    cobertura.setCategoria(categoria);
                    coberturas.add(cobertura);
                    
            } }
    catch (SQLException ex) {
        }
        return coberturas;  
    }
}



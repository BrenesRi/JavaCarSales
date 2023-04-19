/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.data;

import com.mycompany.proyecto1.logic.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ESCINF
 */
public class UsuarioDao {
     RelDatabase db;

    public UsuarioDao(RelDatabase db){
        this.db= db;
    }
    
    public Usuario read(String cedula) throws Exception {
        String sql = "select " +
                "* " +
                "from  Usuario e " +
                "where e.cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cedula);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            return from(rs, "e");
        } else {
            throw new Exception("Empleado no Existe");
        }
    }
    
    public Usuario from(ResultSet rs, String alias) {
        try {
            Usuario e = new Usuario();
            e.setCedula(rs.getString(alias + ".cedula"));
            e.setClave(rs.getString(alias + ".clave"));
            e.setTipo(rs.getInt(alias + ".tipo"));            
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }
    public void create(Usuario e) throws Exception {
        String sql = "insert into " +
                "Usuario " +
                "(cedula, clave, tipo) " +
                "values(?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, e.getCedula());
        stm.setString(2, e.getClave());
        stm.setInt(3, e.getTipo());
        db.executeUpdate(stm);
 }
    
    public void update(Usuario e) throws Exception {
        String sql = "update " +
                "Usuario " +
                "set clave=? , " +
                "where cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, e.getClave());
        stm.setString(2, e.getCedula());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cliente no existe");
        }
    }
}
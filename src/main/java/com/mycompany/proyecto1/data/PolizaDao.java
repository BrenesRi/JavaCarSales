/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.data;

import com.mycompany.proyecto1.logic.Cliente;
import com.mycompany.proyecto1.logic.Poliza;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ESCINF
 */
public class PolizaDao {

    RelDatabase db;

    public PolizaDao(RelDatabase db) {
        this.db = db;
    }

    public Poliza read(String numero) throws Exception {
        String sql = "select "
                + "* "
                + "from Poliza e inner join Cliente c on e.cliente=c.cedula "
                + "where e.numero=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, numero);
        ResultSet rs = db.executeQuery(stm);
        ClienteDao clienteDao = new ClienteDao(db);
        Poliza c;
        if (rs.next()) {
            c = from(rs, "e");
            c.setCliente(clienteDao.from(rs, "c"));
            return c;
        } else {
            throw new Exception("Poliza no Existe");
        }
    }
    
    public List<Poliza> findByCliente(Cliente cliente) {
        List<Poliza> resultado = new ArrayList<>();
        try {
            String sql = "select * "
                    + "from "
                    + "Poliza e "
                    + "where e.cliente=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, cliente.getCedula());
            ResultSet rs = db.executeQuery(stm);
            while (rs.next()) {
                resultado.add(from(rs, "e"));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    public List<Poliza> findByPlaca(String placa) {
        List<Poliza> resultado = new ArrayList<>();
        try {
            String sql = "select * "
                    + "from "
                    + "Poliza e "
                    + "where e.placa=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1,placa);
            ResultSet rs = db.executeQuery(stm);
            while (rs.next()) {
                resultado.add(from(rs, "e"));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    private Poliza from(ResultSet rs, String alias) {
        try {
            Poliza e = new Poliza();
            e.setNumero(rs.getInt(alias + ".numero"));
            e.setPlaca(rs.getString(alias + ".placa"));
            e.setValor(rs.getDouble(alias + ".valor"));
            e.setFecha(rs.getDate(alias+".fecha"));
            e.setModelo(rs.getInt(alias+".modelo"));
            e.setAnio(rs.getInt(alias+".anio"));
            e.setPago(rs.getString(alias+".pago"));
            e.setCostofinal(rs.getInt(alias+".costofinal"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }
}

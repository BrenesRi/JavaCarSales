/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto1.presentation.admin.modelos;

import com.mycompany.proyecto1.logic.Marca;
import com.mycompany.proyecto1.logic.Modelo;
import com.mycompany.proyecto1.logic.Service;
import com.mycompany.proyecto1.logic.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ribre
 */
@WebServlet(name = "ModelosController", urlPatterns = {"/presentation/admin/modelos/show"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response)
            
            throws ServletException, IOException {
        request.setAttribute("model", new Model());
String viewUrl="";     
        switch (request.getServletPath()) {
          case "/presentation/admin/modelos/show":
              viewUrl = this.show(request);
              break;
        }          
     request.getRequestDispatcher(viewUrl).forward( request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String show(HttpServletRequest request) {
       return this.showAction(request);
    }

    private String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        List<Modelo> modelos = new ArrayList<>();
        List<Modelo> temp;
        List<Marca> marcas;
        try {
            marcas = service.marcasFind();
            for (Marca marca : marcas) {
                temp = service.modelosFindByMarca(marca.getId());
                 for (Modelo modelo : temp) {
                     modelo.setMarca(marca);
                     modelos.add(modelo);
                 }
                
            }
        } catch (Exception ex) {
            modelos=null;
        }
        try {        
            model.setModelos(modelos);
            return "/presentation/admin/modelos/View.jsp";
        } catch (Exception ex) {
            return "";
        }   
    }

}

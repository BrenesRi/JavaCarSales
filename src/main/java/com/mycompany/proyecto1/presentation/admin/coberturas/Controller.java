/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto1.presentation.admin.coberturas;

import com.mycompany.proyecto1.logic.Categoria;
import com.mycompany.proyecto1.logic.Service;
import com.mycompany.proyecto1.logic.Usuario;
import com.mycompany.proyecto1.logic.Cobertura;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Kevin
 */
@WebServlet(name = "CoberturasController", urlPatterns = {"/presentation/admin/coberturas/show"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response)
            
            throws ServletException, IOException {
        request.setAttribute("model", new Model());
String viewUrl="";     
        switch (request.getServletPath()) {
          case "/presentation/admin/coberturas/show":
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
        List<Cobertura> coberturas = new ArrayList<>();
        List<Cobertura> temp;
        List<Categoria> categorias;
        try {
            categorias = service.categoriasFind();
            for (Categoria categoria : categorias) {
                
                temp = service.coberturasFindByCategoria(categoria.getId());
                 for (Cobertura cobertura : temp) {
                     cobertura.setCategoria(categoria);
                     coberturas.add(cobertura);
                 }
                
            }
        } catch (Exception ex) {
            coberturas=null;
        }
        try {        
            model.setCoberturas(coberturas);
            return "/presentation/admin/coberturas/View.jsp";
        } catch (Exception ex) {
            return "";
        }   
    }

}

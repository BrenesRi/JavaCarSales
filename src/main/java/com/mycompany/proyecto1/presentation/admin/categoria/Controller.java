/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto1.presentation.admin.categoria;

import com.mycompany.proyecto1.logic.Categoria;
import com.mycompany.proyecto1.logic.Service;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bermu
 */
@WebServlet(name = "CategoriaController", urlPatterns = {"/presentation/admin/categoria/show","/presentation/admin/categoria/create"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("model", new Model()); 
        
        String viewUrl="";
        switch(request.getServletPath()){
            case "/presentation/admin/categoria/show":
                viewUrl=this.show(request);
                break;  
            case "/presentation/admin/categoria/create":
                viewUrl=this.create(request);
                break;
     
        }
        request.getRequestDispatcher(viewUrl).forward( request, response);
    }

    private String show(HttpServletRequest request) {
       return this.showAction(request);
    }

    private String showAction(HttpServletRequest request) {
        return "/presentation/admin/categoria/View.jsp";
    }

    private String create(HttpServletRequest request) {
        try{
       Model model = (Model) request.getAttribute("model");
       Map<String,String> errores =  this.validar(request);
       if(errores.isEmpty()){
                this.updateModel(request);          
                return this.updateAction(request);
            }
            else{
                request.setAttribute("errores", errores);
                return "/presentation/Error.jsp";
            }            
        }
        catch(Exception e){
            return "/presentation/Error.jsp";             
        } 
    }

    private Map<String, String> validar(HttpServletRequest request) {
        Map<String,String> errores = new HashMap<>();
        if (request.getParameter("descripcionFld").isEmpty()){
            errores.put("descripcionFld","Descripcion requerida");
        }
        return errores;
    }

    private void updateModel(HttpServletRequest request) {
        Model model= (Model) request.getAttribute("model");
       
        model.getCurrent().setDescripcion(request.getParameter("descripcionFld"));
    }

    private String updateAction(HttpServletRequest request) {
        Model model= (Model) request.getAttribute("model");
        Service  service = Service.instance();
        Categoria categoria = model.getCurrent();
        try {
            service.categoriaCreate(categoria);
            return "/presentation/admin/categorias/show";
        } catch (Exception ex) {
            Map<String,String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("descripcionFld","Descripcion incorrecta");
            return "/presentation/cliente/datos/View.jsp"; 
        }
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

}

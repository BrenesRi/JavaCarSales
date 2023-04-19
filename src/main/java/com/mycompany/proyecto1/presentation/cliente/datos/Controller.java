/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1.presentation.cliente.datos;

import com.mycompany.proyecto1.logic.Cliente;
import com.mycompany.proyecto1.logic.Service;
import com.mycompany.proyecto1.logic.Usuario;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;


@WebServlet(name = "ClienteDatosController", urlPatterns = {"/presentation/cliente/datos/show","/presentation/cliente/datos/update"})
public class Controller extends HttpServlet {
    
  protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response)
         throws ServletException, IOException {

        request.setAttribute("model", new Model());
        
        String viewUrl="";     
        switch (request.getServletPath()) {
          case "/presentation/cliente/datos/show":
              viewUrl = this.show(request);
              break;
          case "/presentation/cliente/datos/update":
              viewUrl = this.update(request);
              break;              
        }          
        request.getRequestDispatcher(viewUrl).forward( request, response); 
  }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }
    
    public String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Cliente cliente;
        try {
            cliente = service.clienteFind(usuario);
        } catch (Exception ex) { cliente=null; }
        try {        
            model.setCurrent(cliente);
            return "/presentation/cliente/datos/View.jsp";
        } catch (Exception ex) { return ""; }
    }
    
    
    
    private String update(HttpServletRequest request) { 
        try{
            Model model = (Model) request.getAttribute("model");
            HttpSession session = request.getSession(true);
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            model.getCurrent().setCedula(usuario.getCedula());
            Map<String,String> errores =  this.validar(request);
            if(errores.isEmpty()){
                this.updateModel(request);          
                return this.updateAction(request);
            }
            else{
                request.setAttribute("errores", errores);
                return "/presentation/cliente/datos/View.jsp"; 
            }            
        }
        catch(Exception e){
            return "/presentation/Error.jsp";             
        }         
    }
    
    Map<String,String> validar(HttpServletRequest request){
        Map<String,String> errores = new HashMap<>();
        if (request.getParameter("nombreFld").isEmpty()){
            errores.put("nombreFld","Nombre requerido");
        }
        if (request.getParameter("telefonoFld").isEmpty()){
            errores.put("telefonoFld","Telefono requerido");
        }
        if (request.getParameter("correoFld").isEmpty()){
            errores.put("correoFld","Correo requerido");
        }
        if (request.getParameter("tarjetaFld").isEmpty()){
            errores.put("tarjetaFld","Tarjeta requerido");
        }
        
        return errores;
    }
    
    void updateModel(HttpServletRequest request){
       Model model= (Model) request.getAttribute("model");
       
        model.getCurrent().setNombre(request.getParameter("nombreFld"));
        model.getCurrent().setTelefono(request.getParameter("telefonoFld"));
        model.getCurrent().setCorreo(request.getParameter("correoFld"));
        model.getCurrent().setTarjeta(request.getParameter("tarjetaFld"));
        
   }

        
    public String updateAction(HttpServletRequest request) {
        Model model= (Model) request.getAttribute("model");
        Service  service = Service.instance();
        HttpSession session = request.getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        usuario.setClave(model.getCurrent().getUsuario().getClave());
        model.getCurrent().setCedula(usuario.getCedula());
        model.getCurrent().setUsuario(usuario);
        try {
            service.clienteUpdate(model.getCurrent());
            return "/presentation/Index.jsp";
        } catch (Exception ex) {
            Map<String,String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("nombreFld","cedula o nombre incorrectos");
            errores.put("tarjetaFld","tarjeta incorrecta");
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
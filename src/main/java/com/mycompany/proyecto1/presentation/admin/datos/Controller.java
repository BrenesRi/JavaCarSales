/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto1.presentation.admin.datos;

import com.mycompany.proyecto1.logic.Cliente;
import com.mycompany.proyecto1.logic.Marca;
import com.mycompany.proyecto1.logic.Modelo;
import com.mycompany.proyecto1.logic.Poliza;
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
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author ribre
 */
@WebServlet(name = "AdminController", urlPatterns = {"/presentation/admin/datos/show","/presentation/admin/datos/detail",
                                                                                "/presentation/admin/datos/detailpoliza"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response)
            throws ServletException, IOException {
        
            request.setAttribute("model", new Model());
        String viewUrl="";     
        switch (request.getServletPath()) {
          case "/presentation/admin/datos/show":
              viewUrl = this.show(request);
              break;
          case "/presentation/admin/datos/detail":
              viewUrl = this.showDetail(request);
              break;
          case "/presentation/admin/datos/detailpoliza":
              viewUrl = this.showDetailPoliza(request);
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
        List<Cliente> clientes;
        try {
            clientes = service.clienteFind();
        } catch (Exception ex) {
            clientes=null;
        }
        try {        
            model.setClientes(clientes);
            return "/presentation/admin/datos/View.jsp";
        } catch (Exception ex) {
            return "";
        }
    }
    
    public String showDetail(HttpServletRequest request) {
        String id = request.getParameter("idFld");
        Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
        Cliente cliente;
        List<Poliza> polizas;
        List<Modelo> modelos;
        List<Marca> marcas;
        try {
            cliente = service.clienteFindbyCedula(id);
        } catch (Exception ex) {
            cliente=null;
        }
        try {        
            modelos = service.modelosFind();
            polizas = service.cuentasFind(cliente);
            marcas = service.marcasFind();
            
          for (Poliza poliza : polizas) {
               for (Modelo modelo : modelos) {
                   if(poliza.getModelo()==modelo.getId()){
                      poliza.setModeloOb(modelo);   
                   }
               }
                 }
          for (Poliza poliza : polizas) {
               for (Marca marca : marcas) {
                   if(Objects.equals(poliza.getModeloOb().getMarcaId(), marca.getId()))
                      poliza.getModeloOb().setMarca(marca);
                   }
               }
                      
//          for (Poliza poliza : polizas) {
//               for (Marca marca : marcas) {
//                   if(poliza.getModeloOb().getMarca().getId()==)){
//                      poliza.getModeloOb().setMarca(marca);
//                   }
//               }
//                 }
                    
            //model.setCuentas(service.cuentasFind(cliente));
            model.setCuentas(polizas);
            model.setCurrent(cliente);
            //session.setAttribute("usuario", real);
            return "/presentation/admin/datos/ViewPolizas.jsp";
        } catch (Exception ex) {
            return "";
        }
}
    
    public String showDetailPoliza(HttpServletRequest request) {
        String id = request.getParameter("numeroFld");
        Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
        List<Poliza> polizas;
        List<Modelo> modelos;
        List<Marca> marcas;
        Poliza temp = new Poliza();
         try {        
            modelos = service.modelosFind();
            //polizas = service.cuentasFind(model.getCurrent());
            marcas = service.marcasFind();
            
          temp = service.polizaFind(id);
            
          for (Modelo modelo : modelos) {
                   if(temp.getModelo()==modelo.getId()){
                      temp.setModeloOb(modelo);   
                   }
               }
          
          for (Marca marca : marcas) {
                   if(Objects.equals(temp.getModeloOb().getMarcaId(), marca.getId()))
                      temp.getModeloOb().setMarca(marca);
          }
          
          temp.setCoberturas(service.coberturasFindByPoliza(""+temp.getNumero()));

            model.setSeleccionado(temp);
            System.out.println("Hola, mundo!");
            return "/presentation/admin/datos/ViewPolizaDetail.jsp";
        } catch (Exception ex) {
            return "";
        }
}


}

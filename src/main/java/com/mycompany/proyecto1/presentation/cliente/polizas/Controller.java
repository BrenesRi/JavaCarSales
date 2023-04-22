/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1.presentation.cliente.polizas;

import com.mycompany.proyecto1.logic.Cliente;
import com.mycompany.proyecto1.logic.Marca;
import com.mycompany.proyecto1.logic.Modelo;
import com.mycompany.proyecto1.logic.Poliza;
import com.mycompany.proyecto1.logic.Service;
import com.mycompany.proyecto1.logic.Usuario;
import java.io.IOException;
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


@WebServlet(name = "ClientePolizasController", urlPatterns = {"/presentation/cliente/polizas/show",
                                                              "/presentation/cliente/polizas/detail",
                                                              "/presentation/cliente/polizas/search"})
public class Controller extends HttpServlet {
    
  protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response)
         throws ServletException, IOException {

        request.setAttribute("model", new Model());
        
        String viewUrl="";     
        switch (request.getServletPath()) {
          case "/presentation/cliente/polizas/show":
              viewUrl = this.show(request);
              break;
          case "/presentation/cliente/polizas/detail":
              viewUrl = this.showDetail(request);
              break; 
          case "/presentation/cliente/polizas/search":
              viewUrl = this.showSearch(request);
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
        List<Poliza> polizas;
        List<Modelo> modelos;
        List<Marca> marcas;
        try {
            cliente = service.clienteFind(usuario);
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
            //session.setAttribute("usuario", real);
            return "/presentation/cliente/polizas/View.jsp";
        } catch (Exception ex) {
            return "";
        }
    }
    
    public String showDetail(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        String numero = request.getParameter("numeroFld");
         Service service = Service.instance();
        HttpSession session = request.getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Cliente cliente;
        List<Poliza> polizas;
        Poliza temp = new Poliza();
        List<Modelo> modelos;
        List<Marca> marcas;
        try {
            cliente = service.clienteFind(usuario);
        } catch (Exception ex) {
            cliente=null;
        }
         try {        
            modelos = service.modelosFind();
            polizas = service.cuentasFind(cliente);
            marcas = service.marcasFind();
            
          for (Poliza poliza : polizas) {
                   if(Objects.equals(poliza.getNumero(), Integer.valueOf(numero))){
                      temp = poliza;   
                   }
               }
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
            return "/presentation/cliente/polizas/ViewDetail.jsp";
        } catch (Exception ex) {
            return "";
        }
    }
    
    public String showSearch(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
        String placa = request.getParameter("placaFld");
        if("".equals(placa)){
        return this.showAction(request);
        } else {
        HttpSession session = request.getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Cliente cliente;
        List<Poliza> polizas;
        List<Modelo> modelos;
        List<Marca> marcas;
        try {
            cliente = service.clienteFind(usuario);
        } catch (Exception ex) {
            cliente=null;
        }
        try {        
            modelos = service.modelosFind();
            polizas = service.cuentasFindbyPlaca(placa);
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
            //session.setAttribute("usuario", real);
            return "/presentation/cliente/polizas/View.jsp";    
      
        } catch (Exception ex) {
            return "";
        }
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1.presentation.cliente.poliza;

import com.mycompany.proyecto1.logic.Categoria;
import com.mycompany.proyecto1.logic.Cliente;
import com.mycompany.proyecto1.logic.Cobertura;
import com.mycompany.proyecto1.logic.Marca;
import com.mycompany.proyecto1.logic.Modelo;
import com.mycompany.proyecto1.logic.Poliza;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "ClientePolizaController", urlPatterns = {"/presentation/cliente/poliza/show","/presentation/cliente/poliza/create",
                                                                            "/presentation/cliente/poliza/coberturas"})
public class Controller extends HttpServlet {
    
  protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response)
         throws ServletException, IOException {
           
        request.setAttribute("model", new Model());
        
        String viewUrl="";     
        switch (request.getServletPath()) {
          case "/presentation/cliente/poliza/show":
              viewUrl = this.show(request);
              break;
          case "/presentation/cliente/poliza/create":
              viewUrl = this.create(request);
              break;
          case "/presentation/cliente/poliza/coberturas":
              viewUrl = this.coberturas(request);
              break;
        }          
        request.getRequestDispatcher(viewUrl).forward( request, response); 
  }

    public String show(HttpServletRequest request) {
    Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        List<Marca> marcas;
        List<Modelo> modelos = new ArrayList<>();
        List<Cobertura> coberturas = new ArrayList<>();
        List<Categoria> categorias = new ArrayList<>();
        try {
            marcas = service.marcasFind();
            modelos = service.modelosFind();
            coberturas = service.coberturasFind();
            categorias = service.categoriasFind();
            
        } catch (Exception ex) {
            marcas=null;
        }
        try {        
            model.setMarcas(marcas);
            model.setModelos(modelos);
            model.setCoberturas(coberturas);
            model.setCategorias(categorias);
            
            return "/presentation/cliente/poliza/View.jsp";
        } catch (Exception ex) {
            return "";
        }   
    }
    
    protected String create(HttpServletRequest request){
    Model model = (Model) request.getAttribute("model");
    Service service = Service.instance();
    HttpSession session = request.getSession(true);
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    Cliente cliente = new Cliente();
    Poliza temp = new Poliza();
    List<Modelo> modelos;
    List<Marca> marcas;
    Date fechaActual = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    String fechaFormateada = sdf.format(fechaActual);
    Date fecha = new Date();
      try {
          fecha = sdf.parse(fechaFormateada);
      } catch (ParseException ex) {
          Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
      }
    String placa = request.getParameter("placaFld");
    String modeloaux = request.getParameter("modeloFld");
    String anio = request.getParameter("anioFld");
    String valor = request.getParameter("valorFld");
    String pago = request.getParameter("pagoFld");
    try {
            cliente = service.clienteFind(usuario);
        } catch (Exception ex) {
            cliente=null;
        }
    try {        
            modelos = service.modelosFind();
            marcas = service.marcasFind();
        List<Cobertura> coberturas = service.coberturasFind();
        List<Categoria> categorias = service.categoriasFind();
          
          temp.setPlaca(placa);
          temp.setValor(Double.parseDouble(valor));
          temp.setFecha(fechaFormateada);
          temp.setCliente(cliente);
          
          for (Modelo modelo : modelos) {
                   if(modeloaux.equals(modelo.getDescripcion())){
                      temp.setModeloOb(modelo);   
                   }
               }
          
          temp.setAnio(Integer.parseInt(anio));
          temp.setPago(pago);
          
          
            model.setCurrent(temp);
            model.setMarcas(marcas);
            model.setModelos(modelos);
            model.setCoberturas(coberturas);
            model.setCategorias(categorias);
        
            session.setAttribute("poliza", temp);
            return "/presentation/cliente/poliza/ViewCoberturas.jsp";
        } catch (Exception ex) {
            return "";
        }
}

    public String coberturas(HttpServletRequest request) {
    Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Poliza temp = (Poliza) session.getAttribute("poliza");
        String[] coberturasSeleccionadas = request.getParameterValues("coberturasFld");
if (coberturasSeleccionadas != null) {
    for (String coberturaId : coberturasSeleccionadas) {
        try{
            temp.getCoberturas().add(service.coberturaFindbyId(coberturaId));
        }  catch (Exception ex) {
            return "";
        }  
    }
        List<Cobertura> coberturas = temp.getCoberturas();
    int valor = 0;
        int valormin = 0;
        for (Cobertura c: coberturas){
            valor = valor + (c.getPorcentaje()*c.getCostominimo());
            valormin = valormin + c.getCostominimo();
        }
        if (valor>valormin){
            temp.setCostofinal(valor);
        }else{
            temp.setCostofinal(valormin);
        }
    return "";
}

        List<Marca> marcas;
//        List<Modelo> modelos = new ArrayList<>();
//        List<Cobertura> coberturas = new ArrayList<>();
//        List<Categoria> categorias = new ArrayList<>();
//        try {
//            marcas = service.marcasFind();
//            modelos = service.modelosFind();
//            coberturas = service.coberturasFind();
//            categorias = service.categoriasFind();
//            
//        } catch (Exception ex) {
//            marcas=null;
//        }
//        try {        
//            model.setMarcas(marcas);
//            model.setModelos(modelos);
//            model.setCoberturas(coberturas);
//            model.setCategorias(categorias);
//            
//            return "/presentation/cliente/poliza/View.jsp";
//        } catch (Exception ex) {
//            return "";
//        }   
return "";
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
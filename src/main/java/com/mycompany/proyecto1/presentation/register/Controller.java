package com.mycompany.proyecto1.presentation.register;


import com.mycompany.proyecto1.logic.Cliente;
import com.mycompany.proyecto1.logic.Service;
import com.mycompany.proyecto1.logic.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ribre
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/presentation/register/show","/presentation/register/create"})
public class Controller extends HttpServlet {

  protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response)
         throws ServletException, IOException {
      
        request.setAttribute("model", new Model()); 
        
        String viewUrl="";
        switch(request.getServletPath()){
            case "/presentation/register/show":
                viewUrl=this.show(request);
                break;  
            case "/presentation/register/create":
                viewUrl=this.create(request);
                break;
     
        }
        request.getRequestDispatcher(viewUrl).forward( request, response); 
  }

    private String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    private String showAction(HttpServletRequest request) {
        return "/presentation/register/View.jsp";
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
                return "/presentation/register/View.jsp";
            }            
        }
        catch(Exception e){
            return "/presentation/Error.jsp";             
        }   
    } 
    
    Map<String,String> validar(HttpServletRequest request){
        Map<String,String> errores = new HashMap<>();
        if (request.getParameter("cedulaFld").isEmpty()){
            errores.put("cedulaFld","Cedula requerida");
        }
        if (request.getParameter("nombreFld").isEmpty()){
            errores.put("nombreFld","Nombre requerido");
        }
        if (request.getParameter("cedulaFld").isEmpty()){
            errores.put("cedulaFld","Cedula requerida");
        }
        if (request.getParameter("telefonoFld").isEmpty()){
            errores.put("telefonoFld","Telefono requerido");
        }
        if (request.getParameter("correoFld").isEmpty()){
            errores.put("correoFld","Correo requerido");
        }
        if (request.getParameter("tarjetaFld").isEmpty()){
            errores.put("tarjetaFld","Tarjeta requerida");
        }
        if (request.getParameter("claveFld").isEmpty()){
            errores.put("claveFld","Clave requerida");
        }
        return errores;
    }
    
        private void updateModel(HttpServletRequest request) {
            
        Model model= (Model) request.getAttribute("model");
       
        model.getCurrent().setNombre(request.getParameter("nombreFld"));
        model.getCurrent().setCedula(request.getParameter("cedulaFld"));
        model.getCurrent().setTelefono(request.getParameter("telefonoFld"));
        model.getCurrent().setCorreo(request.getParameter("correoFld"));
        model.getCurrent().setTarjeta(request.getParameter("tarjetaFld"));
        model.getCurrent().getUsuario().setCedula(request.getParameter("cedulaFld"));
        model.getCurrent().getUsuario().setClave(request.getParameter("claveFld"));
        String admin = request.getParameter("adminFld");
        model.getCurrent().getUsuario().setTipo(1);
   }
        
        private String updateAction(HttpServletRequest request) {
        Model model= (Model) request.getAttribute("model");
        Service  service = Service.instance();
        Cliente cliente = model.getCurrent();
        Usuario usuario = model.getCurrent().getUsuario();
        try {
            service.usuarioCreate(usuario);
            service.clienteCreate(cliente);
            return "/presentation/login/show";
        } catch (Exception ex) {
            Map<String,String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("nombreFld","cedula o nombre incorrectos");
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
  

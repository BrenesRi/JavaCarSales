<%-- 
    Document   : View
    Created on : Apr 19, 2023, 4:37:53 PM
    Author     : Kevin
--%>
<%@page import="com.mycompany.proyecto1.logic.Marca"%>
<%@page import="com.mycompany.proyecto1.presentation.admin.modelo.Model"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Model model = (Model) request.getAttribute("model");
    List<Marca> marcas = model.getMarcas();
%>

<!DOCTYPE html>
<html>
    <head> 
         <meta charset="UTF-8">
  <title>Formulario</title>
  <link rel="stylesheet" href="style.css">
        <%@ include file="/presentation/Head.jsp" %>
   </head> 
    <body >
        <%@ include file="/presentation/Header.jsp" %>
        
        <% Map<String,String> errores = (Map<String,String>) request.getAttribute("errores"); %>
        <% Map<String,String[]> form = (errores==null)?this.getForm(model):request.getParameterMap();%>
        
        
<div class="panel" style="width:30%;">
        <form method="post" action="presentation/admin/modelo/create">
  <label for="marca">Marca:</label>
  <select id="marca" name="marcaFld">
        <% for(Marca m: marcas){%>
    <option value="<%= m.getId() %>"><%= m.getNombre() %></option>
            <% } %>
  </select>
      
  <br>
  <br>
  
  <label for="descripcion">Modelo:</label>
  <input type="text" id="descripcion" name="descripcionFld">

  <br>
  <br>
  
  <button  style="margin-bottom: 15px">Enviar</button>
</form>
  
        <%@ include file="/presentation/Footer.jsp" %>                  
    </body>
</html>

<%!
    private String erroneo(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return "is-invalid";
      else
        return "";
    }

    private String title(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return errores.get(campo);
      else
        return "";
    }

    private Map<String,String[]> getForm(Model model){
       Map<String,String[]> values = new HashMap<>();
       values.put("marcaFld", new String[]{model.getCurrent().getMarca().getNombre()});
       values.put("descripcionFld", new String[]{model.getCurrent().getDescripcion()});
       return values;
    }
%> 

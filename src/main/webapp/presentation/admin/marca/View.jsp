<%-- 
    Document   : View
    Created on : 19 abr. 2023, 15:14:50
    Author     : ribre
--%>
<%@page import="com.mycompany.proyecto1.presentation.admin.marca.Model"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
        <% Model model= (Model) request.getAttribute("model"); %>
        <% Map<String,String> errores = (Map<String,String>) request.getAttribute("errores"); %>
        <% Map<String,String[]> form = (errores==null)?this.getForm(model):request.getParameterMap();%>
        
        
<div class="panel" style="width:30%;">
        <form method="POST" action="presentation/admin/marca/create">
  <div class="fila">
    <label for="nombre">Nombre de la Marca:</label>
    <input class="<%=erroneo("nombreFld",errores)%>" type="text" id="nombre" 
           name="nombreFld" value="<%=form.get("nombreFld")[0]%>" title="<%=title("nombreFld",errores)%>">
  </div>
  <br>
  <div class="fila">
    <button type="submit" style="margin-bottom: 15px">Enviar</button>
  </div>
</form>
  </div>
  <br>
  
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
       values.put("nombreFld", new String[]{model.getCurrent().getNombre()});
       return values;
    }
%> 

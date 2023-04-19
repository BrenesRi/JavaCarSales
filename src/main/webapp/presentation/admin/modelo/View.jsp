<%-- 
    Document   : View
    Created on : Apr 19, 2023, 4:37:53 PM
    Author     : Kevin
--%>
<%@page import="com.mycompany.proyecto1.presentation.admin.modelo.Model"%>
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
        <form method="POST" action="presentation/admin/modelo/create">
  <div class="fila">
    <label for="marca">Marca:</label>
    <input class="<%=erroneo("marcaFld",errores)%>" type="text" id="marca" 
           name="nombreFld" value="<%=form.get("marcaFld")[0]%>" title="<%=title("marcaFld",errores)%>">
    <br>
    <label for="Modelo">Modelo:</label>
    <input class="<%=erroneo("descripcionFld",errores)%>" type="text" id="descripcion" 
           name="descripcionFld" value="<%=form.get("descripcionFld")[0]%>" title="<%=title("descripcionFld",errores)%>">
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
       values.put("marcaFld", new String[]{model.getCurrent().getMarca().getNombre()});
       values.put("descripcionFld", new String[]{model.getCurrent().getDescripcion()});
       return values;
    }
%> 

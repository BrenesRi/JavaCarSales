<%-- 
    Document   : View
    Created on : 20 abr. 2023, 09:08:03
    Author     : bermu
--%>
<%@page import="com.mycompany.proyecto1.presentation.admin.categoria.Model"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categoria</title>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>

        <% Model model= (Model) request.getAttribute("model"); %>
        <% Map<String,String> errores = (Map<String,String>) request.getAttribute("errores"); %>
        <% Map<String,String[]> form = (errores==null)?this.getForm(model):request.getParameterMap();%>


        <div class="panel" style="width:30%;">
            <form method="POST" action="presentation/admin/categoria/create">
                <div class="fila">
                    <label for="nombre">Descripcion de la categoria:</label>
                    <input class="<%=erroneo("descripcionFld",errores)%>" type="text" id="descripcionFld" 
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
       values.put("descripcionFld", new String[]{model.getCurrent().getDescripcion()});
       return values;
    }
%> 
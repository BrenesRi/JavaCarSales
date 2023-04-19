
<%@page import="com.mycompany.proyecto1.logic.Cuenta"%>
<%@page import="com.mycompany.proyecto1.presentation.cliente.cuenta.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
    Model model = (Model) request.getAttribute("model");
    Poliza poliza = model.getCurrent();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="/presentation/Head.jsp" %>
 <title>Poliza</title> 
</head>
<body >
<%@ include file="/presentation/Header.jsp" %>

    <div class="panel" style="width:50%;">
        <div class="fila encabezado">Cuenta</div>
        <div class="fila">
               <div class="etiqueta">Placa</div>
              <div class="campo"><%=Poliza.getPlaca()%></div>
        </div>
        <div class="fila">
          <div class="etiqueta">Valor</div>
          <div class="campo"><%=poliza.getValor()%></div>
        </div>
    </div>     
     <%@ include file="/presentation/Footer.jsp" %>
</body>
</html>









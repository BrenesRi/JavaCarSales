<%-- 
    Document   : ViewConfirmacion
    Created on : 22 abr. 2023, 16:47:31
    Author     : ribre
--%>
<%@page import="com.mycompany.proyecto1.logic.Poliza"%>
<%@page import="com.mycompany.proyecto1.logic.Marca"%>
<%@page import="com.mycompany.proyecto1.logic.Modelo"%>
<%@page import="com.mycompany.proyecto1.logic.Cobertura"%>
<%@page import="com.mycompany.proyecto1.logic.Categoria"%>

<%@page import="com.mycompany.proyecto1.presentation.cliente.poliza.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%
    Model model = (Model) request.getAttribute("model");
    Poliza c = model.getCurrent();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <title>Poliza</title> 
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <div style="margin: 0 auto"><H1 style="font-weight: bold; background-color:#34495E; color: #bbe0e9 ">Confirmar Poliza:</H1></div>
        <div class="panel" style="width:30%; margin: 0 auto;">
            <div class="fila" style="width: 30%; text-align: center;">
                <h2>Perteneciente al cliente <%=c.getCliente().getNombre()%> </h2>  
            </div>
        </div>
        <div class="panel" style="width:30%; margin: 0 auto;">
            <br>
            <div class="fila">
                <label>Placa del Automovil:</label>
                <span><%=c.getPlaca()%></span>
            </div>
            <br>
            <div class="fila">
                <label>Valor del Automovil:</label>
                <span><%=c.getValor()%></span>
            </div>
            <br>
            <div class="fila">
                <label>Fecha de realizada la Poliza:</label>
                <span><%=c.getFecha()%></span>
            </div>
            <br>
            <div class="fila">
                <label>Cliente al que pertenece la Poliza:</label>
                <span><%=c.getCliente().getNombre()%></span>
            </div>
            <br>
            <div class="fila">
                <label>Modelo:</label>
                <span><%=c.getModeloOb().getDescripcion()%></span>
            </div>
            <br>
            <div class="fila">
                <label>Marca del Modelo:</label>
                <span><%=c.getModeloOb().getMarca().getNombre()%></span>
            </div>
            <div class="fila">
                <label>Año:</label>
                <span><%=c.getAnio()%></span>
            </div>
            <div class="fila">
                <label>Pago:</label>
                <span><%=c.getPago()%></span>
            </div> <br>
            <div class="fila">
                <label>Costo final agregado el de las coberturas:</label>
                <span><%=c.getCostofinal()%></span>
            </div> <br>
            <div class="fila">
    <label>Coberturas:</label>
    <ul>
      <% for (Cobertura cobertura : c.getCoberturas()) { %>
        <li><%=cobertura.getDescripcion()%></li>
        <li><%=cobertura.getPorcentaje()%>&#37;</li>
      <% } %>
    </ul>
  </div>
    <div class="fila">
                <span><img src="presentation/admin/modelo/getImage?id=<%=c.getModeloOb().getId()%>" width="340" height ="180"></span>
            </div> <br>
        </div>
    </body>
</html>

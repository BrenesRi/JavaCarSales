<%-- 
    Document   : ViewDetail
    Created on : 21 abr. 2023, 20:52:58
    Author     : ribre
--%>
<%@page import="com.mycompany.proyecto1.logic.Poliza"%>
<%@page import="com.mycompany.proyecto1.logic.Cobertura"%>
<%@page import="com.mycompany.proyecto1.presentation.cliente.polizas.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
    Model model = (Model) request.getAttribute("model");
    List<Poliza> polizas = model.getCuentas();
    Poliza c = model.getSeleccionado();
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
        <br>
        <div class="panel" style="width:30%; margin: 0 auto;">
            <div class="fila" style="width: 30%; text-align: center;">
                <h2>Poliza No: <%=c.getNumero()%> Perteneciente al cliente <%=c.getCliente().getNombre()%> </h2>  
            </div>
        </div>
        <div class="panel" style="width:30%; margin: 0 auto;">
            <div class="fila">
                <label>Número de Poliza:</label>
                <span><%=c.getNumero()%></span>
            </div>
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
                <label>Costo final:</label>
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
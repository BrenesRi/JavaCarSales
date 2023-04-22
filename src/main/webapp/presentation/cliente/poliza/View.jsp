
<%@page import="com.mycompany.proyecto1.logic.Poliza"%>
<%@page import="com.mycompany.proyecto1.logic.Marca"%>
<%@page import="com.mycompany.proyecto1.logic.Modelo"%>
<%@page import="com.mycompany.proyecto1.logic.Cobertura"%>

<%@page import="com.mycompany.proyecto1.presentation.cliente.poliza.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%
    Model model = (Model) request.getAttribute("model");
    Poliza poliza = model.getCurrent();
    List<Marca> marcas = model.getMarcas();
    List<Modelo> modelos = model.getModelos();
    List<Cobertura> coberturas = model.getCoberturas();
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
        <div style="margin: 0 auto"><H1 style="font-weight: bold; background-color:#34495E; color: #bbe0e9 ">Registro de una nueva Poliza Automotriz</H1></div>
        <div class="panel" style="width:30%;">
            <form method="post" action="presentation/cliente/poliza/create">

                <label for="placa">Placa:</label>
                <input type="text" id="placa" name="placaFld">
                <br> <br>
                <label for="modelo">Marca y Modelo:</label>
                <select id="modelo" name="modeloFld">
                    <% for(Marca m: marcas){%>
                    <optgroup label="<%= m.getNombre() %>"> 
                        <% for(Modelo mo: modelos){%>
                        <% if(mo.getMarcaId()==m.getId()){%>
                        <option value="<%= mo.getDescripcion() %>"><%= mo.getDescripcion() %></option>
                        <% } %>
                        <% } %>
                        <% } %>
                    </optgroup>
                </select>
                <br> <br>
                <label for="anio">Año:</label>
                <select name="anioFld">
                    <% 
                    int añoActual = 2023;
                    for(int i = añoActual; i >= añoActual - 23; i--) {
                    %>
                    <option value="<%=i%>"><%=i%></option>
                    <% } %>
                </select>
                <br> <br>
                <label for="valor">Valor:</label>
                <input type="number" id="valor" name="valorFld">
                <br> <br>
                <label for="pagoFld">Método de Pago:</label>
                <label>
                    <input type="radio" name="pagoFld" value="Trimestral">
                    Trimestral
                </label>

                <label>
                    <input type="radio" name="pagoFld" value="Semestral">
                    Semestral
                </label>

                <label>
                    <input type="radio" name="pagoFld" value="Anual">
                    Anual
                </label>
                <br> <br>
                <button  style="margin-bottom: 15px">Siguiente (Coberturas) -></button>
            </form>
        </div>
        <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>









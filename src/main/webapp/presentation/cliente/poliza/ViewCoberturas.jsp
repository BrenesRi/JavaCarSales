<%-- 
    Document   : ViewCoberturas
    Created on : 22 abr. 2023, 15:10:30
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
    Poliza poliza = model.getCurrent();
    List<Marca> marcas = model.getMarcas();
    List<Modelo> modelos = model.getModelos();
    List<Cobertura> coberturas = model.getCoberturas();
    List<Categoria> categorias = model.getCategorias();
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
        <div style="margin: 0 auto"><H1 style="font-weight: bold; background-color:#34495E; color: #bbe0e9 ">Coberturas deseadas</H1></div>
        <div class="panel" style="width:30%;">
            <form method="post" action="presentation/cliente/poliza/coberturas">
                <% for(Categoria c: categorias){ %>
                <h4><%= c.getDescripcion() %></h4>
                <% for(Cobertura co: coberturas){ %>
                <% if(co.getCategoriaId()==c.getId()){ %>
                <label>
                    <input type="checkbox" name="coberturasFld" value="<%= co.getId() %>">
                    <%= co.getDescripcion() %>
                </label>
                <% } %>
                <% } %>
                <% } %>
                <br> <br>
                <button style="margin-bottom: 15px">Siguiente (Coberturas) -></button>
            </form>
        </div>
        <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>

<%-- 
    Document   : View
    Created on : 18 abr. 2023, 23:54:44
    Author     : ribre
--%>

<%@page import="com.mycompany.proyecto1.logic.Cliente"%>
<%@page import="com.mycompany.proyecto1.presentation.admin.datos.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
    Model model = (Model) request.getAttribute("model");
    List<Cliente> clientes = model.getClientes();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
 <%@ include file="/presentation/Head.jsp" %>
 <title>Clientes Actuales y Polizas</title> 
</head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <div style="width:50%;margin:auto;">
        <h1>Listado de Clientes</h1>     
    
        <table>
            <thead>
                <tr> <td>Numero</td> <td>Nombre</td> </tr>
            </thead>
            <tbody>
                <% for(Cliente c:clientes){%>
                <tr> <td><a href="presentation/cliente/poliza/show?numeroFld=<%=c.getCedula()%>"><%=c.getCedula()%> </td>  
                        <td><%=c.getNombre()%></td></tr>             
                        <%}%>
            </tbody>
        </table>
    </div>
         <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>

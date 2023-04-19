<%-- 
    Document   : View
    Created on : 19 abr. 2023, 10:55:33
    Author     : ribre
--%>
<%@page import="com.mycompany.proyecto1.logic.Marca"%>
<%@page import="com.mycompany.proyecto1.presentation.admin.marcas.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
    Model model = (Model) request.getAttribute("model");
    List<Marca> marcas = model.getMarcas();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
 <%@ include file="/presentation/Head.jsp" %>
 <title>Marcas Registradas</title> 
</head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <div style="width:50%;margin:auto;">
        <h1>Listado de Marcas</h1>     
    
        <table>
            <thead>
                <tr> <td>Numero</td> <td>Nombre</td> </tr>
            </thead>
            <tbody>
                <% for(Marca c:marcas){%>
                <tr> <td><a href="presentation/cliente/poliza/show?numeroFld=<%=c.getId()%>"><%=c.getId()%> </td>  
                        <td><%=c.getNombre()%></td></tr>             
                        <%}%>
            </tbody>
        </table>
    </div>
            
            <br>
            
             <div style="width:50%;margin:auto;">
            <form class="form" name="form" action="presentation/admin/marca/show" method="post" > 
                
                <div class="fila">
                    <div style="margin-bottom: 15px">
                        <button  class="boton" style="margin-bottom: 15px">Agregar nueva Marca</button>
                    </div>
                </div>
        </form>
                  </div>
         <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>

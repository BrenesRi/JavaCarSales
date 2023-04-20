<%-- 
    Document   : View
    Created on : 20 abr. 2023, 08:01:43
    Author     : bermu
--%>
<%@page import="com.mycompany.proyecto1.logic.Categoria"%>
<%@page import="com.mycompany.proyecto1.presentation.admin.categorias.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Model model = (Model) request.getAttribute("model");
    List<Categoria> categorias = model.getCategorias();
%>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <div style="width:50%;margin:auto;">
            <h1>Listado de Categorias</h1>     

            <table>
                <thead>
                    <tr> <td>Numero</td> <td>Descripcion</td> </tr>
                </thead>
                <tbody>
                    <% for(Categoria c:categorias){%>
                    <tr> <td><a href="presentation/admin/categoria/show?idFld=<%=c.getId()%>"><%=c.getId()%> </td>  
                        <td><%=c.getDescripcion()%></td></tr>             
                        <%}%>
                </tbody>
            </table>
        </div>

        <br>

        <div style="width:50%;margin:auto;">
            <form class="form" name="form" action="presentation/admin/categoria/show" method="post" > 
                <div class="fila">
                    <div style="margin-bottom: 15px">
                        <button  class="boton" style="margin-bottom: 15px">Agregar nueva Categoria</button>
                    </div>
                </div>
            </form>
        </div>
        <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>

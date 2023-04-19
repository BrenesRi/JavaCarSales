<%-- 
    Document   : View
    Created on : 19 abr. 2023, 11:36:51
    Author     : ribre
--%>
<%@page import="com.mycompany.proyecto1.logic.Modelo"%>
<%@page import="com.mycompany.proyecto1.presentation.admin.modelos.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
    Model model = (Model) request.getAttribute("model");
    List<Modelo> modelos = model.getModelos();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
 <%@ include file="/presentation/Head.jsp" %>
 <title>Modelos Registrados</title> 
</head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <div style="width:50%;margin:auto;">
        <h1>Listado de Modelos</h1>     
    
        <table>
            <thead>
                <tr> <td>Numero</td> <td>Nombre</td> <td>Marca</td> </tr>
            </thead>
            <tbody>
                <% for(Modelo c:modelos){%>
                <tr> <td><a href="presentation/cliente/poliza/show?numeroFld=<%=c.getId()%>"><%=c.getId()%> </td>  
                        <td><%=c.getDescripcion()%></td>
                        <td><%=c.getMarca().getNombre()%></td>
                
                </tr>             
                        <%}%>
            </tbody>
        </table>
    </div>
            
            <br>
            
            
            <div style="width:50%;margin:auto;">
            <form class="form" name="form" action="presentation/admin/modelo/show" method="post" > 
                
                <div class="fila">
                    <div style="margin-bottom: 15px">
                        <button  class="boton" style="margin-bottom: 15px">Agregar nuevo Modelo</button>
                    </div>
                </div>
        </form>
                  </div>
         <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>

<%-- 
    Document   : View
    Created on : Apr 20, 2023, 11:23:40 AM
    Author     : Kevin
--%>

<%@page import="com.mycompany.proyecto1.logic.Cobertura"%>
<%@page import="com.mycompany.proyecto1.presentation.admin.coberturas.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
    Model model = (Model) request.getAttribute("model");
    List<Cobertura> coberturas = model.getCoberturas();
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
        <h1>Listado de Coberturas</h1>     
    
        <table>
            <thead>
                <tr> <td>Numero:</td> <td>Nombre:</td> <td>Categoria:</td> <td>Costo Minimo:</td> <td>Porcentaje:</td>  </tr>
            </thead>
            <tbody>
                <% for(Cobertura c: coberturas){%>
                <tr> <td><a href="presentation/cliente/poliza/show?numeroFld=<%=c.getId()%>"><%=c.getId()%> </td>  
                        <td><%=c.getDescripcion()%></td>
                        <td><%=c.getCategoria().getDescripcion()%></td>
                        <td><%=c.getCostominimo()%></td>
                        <td><%=c.getPorcentaje()%></td>
                </tr>             
                        <%}%>
            </tbody>
        </table>
    </div>
            
            <br>
            
            
            <div style="width:50%;margin:auto;">
            <form class="form" name="form" action="presentation/admin/cobertura/show" method="post" > 
                
                <div class="fila">
                    <div style="margin-bottom: 15px">
                        <button  class="boton" style="margin-bottom: 15px">Agregar nueva Cobertura</button>
                    </div>
                </div>
        </form>
                  </div>
         <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>

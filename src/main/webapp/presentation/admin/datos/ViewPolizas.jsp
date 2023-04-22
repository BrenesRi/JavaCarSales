<%-- 
    Document   : ViewPolizas
    Created on : 21 abr. 2023, 20:13:33
    Author     : ribre
--%>

<%@page import="com.mycompany.proyecto1.logic.Cliente"%>
<%@page import="com.mycompany.proyecto1.logic.Poliza"%>
<%@page import="com.mycompany.proyecto1.presentation.admin.datos.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
    Model model = (Model) request.getAttribute("model");
    List<Cliente> clientes = model.getClientes();
    List<Poliza> polizas = model.getCuentas();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
 <%@ include file="/presentation/Head.jsp" %>
 <title>Polizas del cliente seleccionado</title> 
</head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <div style="width:50%;margin:auto;">
        <h1>Listado de Polizas del Cliente</h1>     
    
        <table>
            <thead>
                <tr> <td>Numero</td> <td>Placa</td> <td>Valor</td> <td>Fecha</td> <td>Auto</td> <td>Imagen</td>
                    <td>Costo Final</td> <td>Detalles</td> </tr>
            </thead>
            <tbody>
                <% for(Poliza c:polizas){%>
                <tr>
                    <td><%=c.getNumero()%> </td>  
                    <td><%=c.getPlaca()%></td>
                    <td><%=c.getValor()%></td>
                    <td><%=c.getFecha()%></td>
                    <td>
                        <%= c.getModeloOb().getMarca().getNombre()%>
                           <%= " - " %> 
                          <%=  c.getModeloOb().getDescripcion() %> 
                          <%=  " - " %> 
                          <%=  c.getAnio()%>  
                    </td>
                    <td><img src="presentation/admin/modelo/getImage?id=<%=c.getModeloOb().getId()%>" width="140" height ="80"></td>
                    <td><%=c.getCostofinal()%> </td>
                   <td><a href="presentation/cliente/polizas/detail?numeroFld=<%=c.getNumero()%>"><img src="images/lupa.png" width="50" height ="50"></td>
                    
                    
                
                </tr> 
<!--                         <tr> <td><form action="/Proyecto1/presentation/cliente/poliza/show">
                                    <input type="hidden" name="numeroFld" value="<%=c.getNumero()%>"> 
                                    <button class="link-button"> <%=c.getNumero()%> </button> </form> </td>  
                            <td><%=c.getValor()%></td></tr>  -->              
                        <%}%>
            </tbody>
        </table> 
    </div>
         <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>
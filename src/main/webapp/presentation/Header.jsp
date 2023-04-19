<%@page import="com.mycompany.proyecto1.logic.Usuario"%>
<% Usuario usuario=  (Usuario) session.getAttribute("usuario");  %>

<header>
    <div class="menu">

        <ul class="menu-ul"> 
            <div style="display:flex;flex-flow: row nowrap;">
                <img src="/Proyecto1/images/auto.jpg" width="70px" style="border-radius: 50% 10% 50% 10%;border:1px solid #000;">
                <h3>Seguros Infinito</h3>
            </div>
            <div class="info">
                <img src="/Proyecto1/images/llamada-telefonica.png" height="40px" style="margin-right: 10px;" alt="Llamada telefonica"/>
                <h3>+50604670937</h3>
            </div>
            <li>
                <a href="presentation/Index.jsp">Inicio</a>
            </li>
            <% if (usuario!=null){ %>
            <% if (usuario.getTipo()==1){ %>
            <li>
                <a href="presentation/cliente/polizas/show">Polizas</a>
                <ul>  <!--submenu --> </ul>
            </li>                        
            <li >
                <a  href="presentation/cliente/datos/show">Usuario: <%=usuario.getCedula()%></a>
                <ul>  <!--submenu --> </ul>
            </li> 
            <li >
                <a  href="presentation/login/logout">Logout</a>
                <ul>  <!--submenu --> </ul>
            </li>                
            <% } %>
            <% if (usuario.getTipo()==2){ %>
            <li>
                <a href="presentation/admin/datos/show">Clientes</a>
                <ul>  <!--submenu --> </ul>
            </li>
            
            <li>
                <a href="presentation/admin/marcas/show">Gestionar Marcas</a>
                <ul>  <!--submenu --> </ul>
            </li>
            
            <li>
                <a href="presentation/admin/modelos/show">Gestionar Modelos</a>
                <ul>  <!--submenu --> </ul>
            </li>
                     
            <li >
                <a  href="presentation/cliente/datos/show">Administrador: <%=usuario.getCedula()%></a>
                <ul>  <!--submenu --> </ul>
            </li> 
            <li >
                <a  href="presentation/login/logout">Logout</a>
                <ul>  <!--submenu --> </ul>
            </li>                
            <% } %>
            <% } %>
            <% if (usuario==null){%>
            <li>
                <a href="presentation/login/show">Login</a>
            </li>
            <% }%>   
        </ul>
    </div>
</header> 
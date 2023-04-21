<%@page import="com.mycompany.proyecto1.logic.Usuario"%>
<% Usuario usuario=  (Usuario) session.getAttribute("usuario");  %>

<header>
    <div>
        <ul class="menu"> 
            <div style="display:flex;flex-flow: row nowrap;">
                <img src="/Proyecto1/images/logo.png" width="85px" style="border-radius: 50%;border:double 1px #cecece;">
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
                <span style="text-transform: uppercase;">Opciones Cliente</span>
                <ul>
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
                </ul>
            </li>               
            <% } %>
            <% if (usuario.getTipo()==2){ %>

            <li>
                <span style="text-transform: uppercase;">Opciones Admin</span>
                <ul>
                    <li>
                        <a href="presentation/admin/datos/show">Gestionar Clientes</a>
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
                    <li>
                        <a href="presentation/admin/categorias/show">Gestionar Categorias</a>
                        <ul>  <!--submenu --> </ul>
                    </li> 
                    <li>
                        <a href="presentation/admin/coberturas/show">Gestionar Coberturas</a>
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
                </ul>
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
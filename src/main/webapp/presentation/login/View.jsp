
<%@page import="com.mycompany.proyecto1.presentation.login.Model"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
    </head>
    <body >

        <%@ include file="/presentation/Header.jsp" %>

        <% Model model= (Model) request.getAttribute("model"); %>
        <% Map<String,String> errores = (Map<String,String>) request.getAttribute("errores"); %>
        <% Map<String,String[]> form = (errores==null)?this.getForm(model):request.getParameterMap();%>

        <form class="form" name="form" action="presentation/login/login" method="post" > 
            <div class="panel" style="width:30%; margin: 0 auto;">
                <div class="fila" style="width: 30%; text-align: center;">
                    <h2>Login</h2>
                    <img src="/Proyecto1/images/logo.png" width="150px" style="border-radius: 50%;border:double 1px #cecece;object-fit: cover;width:100%;height:100%;">
                </div>
                <div class="fila grid">
                    <div class="etiqueta">Cedula</div>
                    <div class="campo">
                        <input class="<%=erroneo("cedulaFld",errores)%>" placeholder="Cedula del usuario" type="text" name="cedulaFld" value="<%=form.get("cedulaFld")[0]%>" title="<%=title("cedulaFld",errores)%>">
                    </div>
                    <img src="/Proyecto1/images/perfil.png" width="20px" alt="alt"/>
                </div>
                <div class="fila grid">
                    <div class="etiqueta">Clave</div>
                    <div class="campo"><input class="<%=erroneo("claveFld",errores)%>" placeholder="Clave del usuario" type="password" name="claveFld" value="<%=form.get("claveFld")[0]%>" title="<%=title("claveFld",errores)%>">
                    </div>
                    <img src="/Proyecto1/images/bloquear.png" width="20px" alt="alt"/>
                </div>
                <div class="fila">
                    <div style="margin-bottom: 15px">
                        <button  class="boton" style="margin-bottom: 15px">Ingresar</button>
                    </div>
                </div>
            </div>
        </form>
        <form method="post" action="presentation/login/register"> 
        <div class="fila">
            <div style="display:flex;flex-flow:column nowrap;justify-content: center;align-items: center;">
                <h2>No estás registrado?</h2>
                <button class="boton" style="margin-bottom: 15px">Crear cuenta</button>
            </div>
        </div>
        </form>
        <%@ include file="/presentation/Footer.jsp" %>                  
    </body>
</html>
<%!
    private String erroneo(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return "is-invalid";
      else
        return "";
    }

    private String title(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return errores.get(campo);
      else
        return "";
    }

    private Map<String,String[]> getForm(Model model){
       Map<String,String[]> values = new HashMap<>();
       values.put("cedulaFld", new String[]{model.getCurrent().getCedula()});
       values.put("claveFld", new String[]{model.getCurrent().getClave()});
       return values;
    }
    
%> 
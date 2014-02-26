<%-- 
    Document   : index
    Created on : 07-oct-2013, 10:28:18
    Author     : alumno
--%>

<%@page import="proyecto2.bank.negocio.CuentaBancaria"%>
<%@page import="proyecto2.bank.datos.CuentaBancariaDAO"%>
<%@page import="proyecto2.bank.datos.CuentaBancariaDAOImplHibernate"%>
<%@page import="proyecto2.bank.datos.MovimientoBancarioDAOImplHibernate"%>
<%@page import="proyecto2.bank.datos.EntidadBancariaDAOImplHibernate"%>
<%@page import="java.util.List"%>
<%@page import="proyecto2.bank.datos.EntidadBancariaDAO"%>
<%@page import="proyecto2.bank.negocio.EntidadBancaria"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String nombre = request.getParameter("nombre");
    EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImplHibernate();
    List<EntidadBancaria> entidadesBancarias = entidadBancariaDAO.findByNombre(nombre);
    
    CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAOImplHibernate();
    CuentaBancaria cuentaBancaria = cuentaBancariaDAO.findByCodigoCuentaCliente("BA11SU11111234567890");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entidades</title>
        <link href="css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap-responsive.css" rel="stylesheet" media="screen">
    </head>
    <body style="background-color: ghostwhite">
        <div style="margin: 20px;">
            Cuenta Bancaria
            <%=cuentaBancaria.getNumeroCuenta() %>
        </div>
        
        <div id="insertar" style="margin: 10px;">
            <b>Insertar nueva Entidad Bancaria: </b>
            <a href="viewforinsert.jsp" ><input type="button" value="Nueva" class="btn btn-primary" /></a>
        </div>
        <form action="index.jsp" style="margin: 10px;">
            <b>Nombre entidad:</b>
            <input type="text" name="nombre" class="input-medium search-query" />
            <input type="submit" value="Consulta" class="btn btn-warning"/>
        </form>
        <table class="table table-bordered">
            <tr class="info" style="font-weight: bold;">
                <td>ID</td><td>CODIGO</td><td>NOMBRE ENTIDAD</td><td>CIF</td><td>TIPO ENTIDAD</td><td>BORRAR</td><td>EDITAR</td>
            </tr>
            <%    for (EntidadBancaria entidadBancaria : entidadesBancarias) {%>
            <tr class="warning">
                <td><%=entidadBancaria.getIdEntidadBancaria()%></td>
                <td><%=entidadBancaria.getCodigoEntidadBancaria()%></td>
                <td><%=entidadBancaria.getNombreEntidadBancaria()%></td>
                <td><%=entidadBancaria.getCifEntidadBancaria()%></td>
                <td><%=entidadBancaria.getTipoEntidadBancaria()%></td>
                <td style="width: 50px;">
                    <a href="borrar.jsp?idEntidadBancaria=<%=entidadBancaria.getIdEntidadBancaria()%>"><i class="icon-remove"></i></a>  
                </td>
                <td style="width: 50px;">
                    <a href="viewforupdate.jsp?idEntidadBancaria=<%=entidadBancaria.getIdEntidadBancaria()%>"><i class="icon-edit"></i></a>
                </td>
            </tr>

            <% }
            %>
        </table>
    </body>
</html>

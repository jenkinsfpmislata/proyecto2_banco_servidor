<%-- 
    Document   : sucursalBancaria
    Created on : 17-dic-2013, 9:32:51
    Author     : alumno
--%>

<%@page import="proyecto2.bank.negocio.SucursalBancaria"%>
<%@page import="java.util.List"%>
<%@page import="proyecto2.bank.datos.SucursalBancariaDAOImplHibernate"%>
<%@page import="proyecto2.bank.datos.SucursalBancariaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    
    SucursalBancariaDAO sucursalDAO= new SucursalBancariaDAOImplHibernate();
    List<SucursalBancaria> sucursalesBancarias=sucursalDAO.findAll();
    
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SucursalIndex</title>
    </head>
    <body>
        <table class="table">
            <tr class="alert-danger"><td><b>ID</b></td><td><b>CODIGO</b></td><td><b>NOMBRE</b></td><td><b>CIF</b></td><td><b>TIPO ENTIDAD</b></td><td><b>BORRAR</b></td><td><b>EDITAR</b></td></tr>
       <% for(SucursalBancaria sucursal: sucursalesBancarias){%>
       <tr class="success">
        <td><%=sucursal.getIdSucursalBancaria()%></td>
        <td><%=entidad.getCodigoEntidad()%></td>
        <td><%=entidad.getNombre()%></td>
        <td><%=entidad.getCif()%></td>
        <td><%=entidad.getEntidad()%></td>
    </body>
</html>

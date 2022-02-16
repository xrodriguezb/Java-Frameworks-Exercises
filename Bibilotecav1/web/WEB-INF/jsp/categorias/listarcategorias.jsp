<%-- 
    Document   : categoria
    Created on : 17/10/2014, 10:31:26 AM
    Author     : xrodriguez
--%>

<script src="js/categoria.js" type="text/javascript"></script>      

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Listado de Categor&iacute;as</h1>
<div style="text-align: left" id="acciones_modulo">
    <div onclick="render_popup('crearcategoria',0);" class="acciones_boton">
        Agregar categor&iacute;a
    </div>   
</div>
<table id="tablaCategorias">
    <thead>
        <tr>
            <th>ID</th>
            <th>Categor&iacute;a</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="categoria" items="${categoria}">
            <tr>
                <td>
                    <c:out value="${categoria.getIdCategoria()}" />                    
                </td>
                <td>                       
                    <c:out value="${categoria.getTxtNombreCategoria()}" />
                </td>
                <td>
                    <div style="text-align: right">
                        <a href="javascript:borrarCategoria(<c:out value="${categoria.getIdCategoria()}" />)" title="Eliminar categoría"><img src="imagenes/delete-icon.gif" width="16" height="16" alt="delete-icon"/></a>
                        <a href="javascript:render_popup('crearcategoria', <c:out value="${categoria.getIdCategoria()}" />)" title="Editar categoría"><img src="imagenes/edit.gif" width="16" height="16" alt="edit"/></a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>


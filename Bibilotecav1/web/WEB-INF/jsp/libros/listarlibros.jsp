<%-- 
    Document   : libro
    Created on : 20/10/2014, 04:02:16 PM
    Author     : xrodriguez
--%>
<script src="js/libro.js" type="text/javascript"></script>    

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Listado de Libros</h1>
<div style="text-align: left" id="acciones_modulo">
    <div onclick="render_popup('crearlibro',0);" class="acciones_boton">
        Agregar libro
    </div>   
</div>

<table id="tablaLibros">
    <thead>
        <tr>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Autor</th>
            <th>Editorial</th>
            <th>ISBN</th>
            <th></th>
        </tr>
        </tr>
    </thead>
    <tbody>

        <c:forEach var="libro" items="${libro}">
            <tr>
                <td>
                    <c:out value="${libro.getIdLibro()}">
                    </c:out>                       
                </td>
                <td>                       
                    <c:out value="${libro.getTxtNombre()}">
                    </c:out>
                </td>
                <td>                       
                    <c:out value="${libro.getTxtAutor()}">
                    </c:out>
                </td>
                <td>                       
                    <c:out value="${libro.getTxtEditorial()}">
                    </c:out>
                </td>
                <td>                       
                    <c:out value="${libro.getTxtIsbn()}">
                    </c:out>
                </td>
                <td>
                    <a href="javascript:borrarLibro(<c:out value="${libro.getIdLibro()}" />)" title="Eliminar libro"><img src="imagenes/delete-icon.gif" width="16" height="16" alt="delete-icon"/></a>
                    <a href="javascript:render_popup('crearlibro', <c:out value="${libro.getIdLibro()}" />)" title="Editar libro"><img src="imagenes/edit.gif" width="16" height="16" alt="edit"/></a>

                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>       

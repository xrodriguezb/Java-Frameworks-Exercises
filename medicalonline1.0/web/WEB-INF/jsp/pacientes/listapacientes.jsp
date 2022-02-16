<%-- 
    Document   : listar
    Created on : 27/11/2014, 11:54:55 AM
    Author     : xrodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="js/pacientes.js" type="text/javascript"></script>
<script>
    $('#tablaPacientes')
            .removeClass('display')
            .addClass('table table-striped');
</script>
 <h2>Pacientes <small> > Listado.</small></h2>
<div id="submodulos_pacientes" style="padding: 3px">
   
</div>
<div>
    <table id="tablaPacientes">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido(s)</th>
                <th>Tel&eacute;fono</th> 
                <th>Celular</th>
                <th>Email</th>
                <th></td>
            </tr>
        </thead> 
        <tbody>
        <tbody>
            <tr>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
        </tbody>
        </tbody>
    </table>
</div>
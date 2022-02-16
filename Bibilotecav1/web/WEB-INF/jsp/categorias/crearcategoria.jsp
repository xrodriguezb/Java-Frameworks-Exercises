<%-- 
    Document   : nuevacategoria
    Created on : 17/10/2014, 12:09:41 PM
    Author     : xrodriguez
--%>

<script src="js/nuevacategoria.js" type="text/javascript"></script> 

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="contenedorForm">   
    <form id="formCategoria" autocomplete="off" action="opercategoria.htm" method="POST" class="basic-grey">
        <h1>Categor&iacute;a
            <span>Agregar nuevo elemento al cat&aacute;logo.</span>
        </h1>
        <label>
            <span>Nombre:</span>
            <input type="text" maxlength="60" placeholder="Nombre de la categoría" id="nombre" name="nombre" required value="<c:out value="${nombreCategoria}" />"/>
        </label>
        <input type="hidden" id="idCategoria" name="idCategoria" value="<c:out value="${idCategoria}"/>"/>
        <label>
            <span>&nbsp;</span>
            <input type="submit" value="Guardar" id="botonGuardar"/>
        </label>
    </form>
    <div class="info message" id="cat_ok" style="display:none">       
        <p>Se ha agregado/actualizado correctamente el elemento al cat&aacute;logo</p>
    </div>

    <div class="warning message" id="cat_error" style="display: none">      
        <p>No se pudo crear/actualizar el elemento de este cat&aacute;logo.<br/>Intente nuevamente.</p>
    </div>
</div>
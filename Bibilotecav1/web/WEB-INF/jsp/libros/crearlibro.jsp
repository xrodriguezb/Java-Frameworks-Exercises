<%-- 
    Document   : nuevolibro
    Created on : 17/10/2014, 01:18:42 PM
    Author     : xrodriguez
--%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="js/nuevolibro.js" type="text/javascript"></script>
<script>
    $(document).ready(function() {
    <c:if test="${idLibro > 0}">
        $("#nombre").val('<c:out value="${libro.getTxtNombre()}"/>');
        $("#autor").val('<c:out value="${libro.getTxtAutor()}"/>');
        $("#editorial").val('<c:out value="${libro.getTxtEditorial()}"/>');
        $("#isbn").val('<c:out value="${libro.getTxtIsbn()}"/>');
        $("#idLibro").val('<c:out value="${idLibro}"/>');
        $("#categoria").val('<c:out value="${idCategoria}"/>');
    </c:if>
    });
</script>
<div id="contenedorForm">    
    <form method="post" id="formLibro" action="operlibro.htm" autocomplete="off" class="basic-grey">
        <h1>Libro
            <span>Agregar nuevo elemento al inventario.</span>
        </h1>

        <label>
            <span>Nombre:</span>
            <input id="nombre" type="text" name="nombre" placeholder="Título del libro" required/>
        </label>

        <label>
            <span>Autor:</span>
            <input id="autor" type="text" name="autor" placeholder="Autor(es)" required/>
        </label>

        <label>
            <span>Editorial:</span>
            <input id="editorial" name="editorial" type="text" placeholder="Casa editorial" required/>
        </label>

        <label>
            <span>ISBN:</span>
            <input id="isbn" name="isbn" type="text" placeholder="Número ISBN" required/>
        </label>

        <label>
            <span>Categor&iacute;a</span>
            <select id="categoria" name="categoria" required>
                <c:forEach var="categorias" items="${categorias}">
                    <option value="${categorias.getIdCategoria()}">
                        <c:out value="${categorias.getTxtNombreCategoria()}"/>
                    </option>
                </c:forEach>
            </select>
        </label>

        <label>
            <span>&nbsp;</span>
            <input id="idLibro" name="idLibro" type="hidden"/>
            <input type="submit" value="Guardar" id="botonGuardar"/>
        </label>       
    </form>
    <div class="info message" id="cat_ok" style="display:none">       
        <p>Se ha agregado correctamente el nuevo elemento al cat&aacute;logo</p>
    </div>

    <div class="warning message" id="cat_error" style="display: none">      
        <p>No se pudo crear el nuevo elemento de este cat&aacute;logo.<br/>Intente nuevamente.</p>
    </div>
</div>
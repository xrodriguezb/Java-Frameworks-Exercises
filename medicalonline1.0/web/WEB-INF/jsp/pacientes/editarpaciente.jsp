<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style type="text/css">
    h1{
        margin: 30px 0;
        padding: 0 200px 15px 0;
        border-bottom: 1px solid #E5E5E5;
    }
    .bs-example{
        margin: 10px;
    }
</style>

<div class="bs-example">
    <div class="page-header">
        <h2>Pacientes <small> > Editar información.</small></h2>
    </div>
    <form class="form-inline" id="formPaciente" method="POST" autocomplete="off">
        <div class="form-group">
            <div class="form-group">
                <label class="control-label col-xs-3">Nombre:</label>
                <div class="col-xs-9">
                    <input type="text" class="form-control" placeholder="Nombre" required value="<c:out value="${paciente.getTxtNombre()}"/>" id="nombre" name="nombre">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3">Apellidos:</label>
                <div class="col-xs-9">
                    <input type="text" class="form-control" placeholder="Apellido" required value="<c:out value="${paciente.getTxtApellido()}"/>" id="apellido" name="apellido">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3" >Telefono:</label>
                <div class="col-xs-9">
                    <input type="tel" class="form-control" placeholder="Telefono" id="telefono" name="telefono">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3" >Celular:</label>
                <div class="col-xs-9">
                    <input type="tel" class="form-control" placeholder="Celular" id="celular" name="celular">
                </div>
            </div>
            <label class="control-label col-xs-3">Email:</label>
            <div class="col-xs-9">
                <input type="email" class="form-control" id="inputEmail" placeholder="Email" value="<c:out value="${paciente.getTxtEmail()}"/>" id="email" name="email">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-xs-3">Dirección:</label>
            <div class="col-xs-9">
                <textarea rows="3" class="form-control" placeholder="Dirección" required id="domicilio" name="domicilio"></textarea>
            </div>
        </div>
        <br>
    </form>
    <div class="alert alert-success" id="exito" style="display: none">Se ha creado el nuevo registro correctamente</div>
    <div class="alert alert-danger" id="error" style="display: none">No se pudo guardar la información. Intenta nuevamente</div>
    <div class="alert alert-warning" id="aviso" style="display: none">Se encontró otro registro con el mismo {campo}. <a href="#" class="alert-link">Ver paciente</a></div>


    <input type="button" class="btn btn-primary" value="Actualizar" onclick="paciente_saveOrUpdate();">  

</div>

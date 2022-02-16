<div class="page-header">
    <h2>Pacientes <small> > Editar información.</small></h2>
</div>
<form class="form-horizontal" id="formPaciente">
    <div class="form-group">
        <div class="form-group">
            <label class="control-label col-xs-3">Nombre:</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" placeholder="Nombre" required="">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3">Apellidos:</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" placeholder="Apellido" required="">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" >Telefono:</label>
            <div class="col-xs-9">
                <input type="tel" class="form-control" placeholder="Telefono">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" >Celular:</label>
            <div class="col-xs-9">
                <input type="tel" class="form-control" placeholder="Celular">
            </div>
        </div>
        <label class="control-label col-xs-3">Email:</label>
        <div class="col-xs-9">
            <input type="email" class="form-control" id="inputEmail" placeholder="Email">
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-xs-3">Dirección:</label>
        <div class="col-xs-9">
            <textarea rows="3" class="form-control" placeholder="Dirección" required=""></textarea>
        </div>
    </div>
    <br>
</form>

<div class="alert alert-success">Se ha creado el nuevo registro correctamente</div>
<div class="alert alert-danger">No se pudo guardar la información. Intenta nuevamente</div>
<div class="alert alert-warning">Se encontró otro registro con el mismo {campo}. <a href="#" class="alert-link">Ver paciente</a></div>

<div class="modal-footer">       
    <input type="button" class="btn btn-primary" value="Enviar">
    <input type="reset" class="btn btn-default" value="Limpiar">
</div>

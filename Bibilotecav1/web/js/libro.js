$(document).ready(function() {
    $('#tablaLibros').DataTable();
});


function borrarLibro(id) {
    if (confirm("Se procederá a dar de baja esta libro, ¿desea continuar?")) {
        $.facebox(div_loader);
        $.ajax({
            type: "POST",
            dataType: "json",
            url: 'operlibro.htm',
            data: "id=" + id+"&action=eliminar",
            success: function(jsonResponse) {
                $.facebox.close();
                result = jsonResponse.serverResponse;
                //Proceso terminado
                if (result.toString() == "ok") {
                    alert("Se ha eliminado correctamente el elemento de este catálogo");
                    render('listarlibros');
                }else{
                    alert("Ocurrió un error al procesar la baja de este registro. Intente nuevamente.")
                }
            },
            error: function(response) {
                //Error en la respuesta
            }
        });
    }
}
$(document).ready(function() {
    $('#tablaCategorias').dataTable({
        "aoColumnDefs": [{
                'bSortable': false,
                'aTargets': [2]
            }]
    });
});

function borrarCategoria(id) {
    if (confirm("Se procederá a dar de baja esta categoría, ¿desea continuar?")) {
        $.facebox(div_loader);
        $.ajax({
            type: "POST",
            dataType: "json",
            url: 'opercategoria.htm',
            data: "id=" + id+"&action=eliminar",
            success: function(jsonResponse) {
                $.facebox.close();
                result = jsonResponse.serverResponse;
                //Proceso terminado
                if (result.toString() == "ok") {
                    alert("Se ha eliminado correctamente el elemento de este catálogo");
                    render('listarcategorias');
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
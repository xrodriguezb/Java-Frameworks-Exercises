$(document).ready(function() {
    $('#formLibro').submit(function() {
        //Ocultamos las notificaciones si estan visibles
        $("#cat_ok").hide();
        $("#cat_error").hide();

        //Inhabilito el boton guardar
        $("#botonGuardar").attr("disabled", true);
        //Agrego el loader al div contenedor
        $('#contenedorForm').append(div_loader);
        
        //Defino que operacion hacer       
        action = (isNaN(parseInt($("#idLibro").val()))) ? 'guardar' : 'actualizar';

        $.ajax({type: $(this).attr('method'),
            url: $(this).attr('action'),
            data: $(this).serialize()+"&action="+action,
            dataType: 'json',
            error: function(xhr, ajaxOptions, thrownError) {
                $("#cat_error").fadeIn();
            },
            success: function(jsonResponse) {
                result = jsonResponse.serverResponse;
                if (result.toString() == "ok") {
                    $("#cat_ok").fadeIn();
                    setTimeout("render('listarlibros')", 2000);
                }
                else {
                    $("#cat_error").fadeIn();
                }
            }
        })
        //Oculto el loader
        $("#loader_div").hide();
        //Habilito boton guardar
        $("#botonGuardar").attr("disabled", false);
        return false;
    });
});


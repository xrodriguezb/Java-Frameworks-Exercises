$(document).ready(function() {

});


//Carga una vista
function render(comando) {
    //return false;
    $.facebox.close();
    $("#ajaxResponse").empty().append(div_loader);
    $.ajax({
        type: "GET",
        dataType: "html",
        url: comando + ".htm",
        success: function(response) {
            //Proceso terminado
            $("#ajaxResponse").empty().append(response);
        },
        error: function(response) {
            //Error en la respuesta
            alert(response);
        }
    });
}

function render_popup(comando,id) {
    $.facebox(div_loader);
    $.ajax({
        type: "GET",
        dataType: "html",
        url: comando + ".htm",
        data:"id="+id,
        success: function(response) {
            //Proceso terminado
            $.facebox(response);
        },
        error: function(response) {
            //Error en la respuesta
        }
    });
    return false;
}


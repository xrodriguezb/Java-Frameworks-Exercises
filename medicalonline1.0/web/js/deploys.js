var loadingContent = '<div id="loader_bar_container" style="padding:5px;" align="center">';
    loadingContent += '<div id="progress_bar" style="width: 400px" align="center">';
    //loadingContent += 'Por favor espere...';
    loadingContent += '<div class="progress progress-striped active">';
    loadingContent += '<div class="bar" style="width: 100%;"></div>';
    loadingContent += '/div>';
    loadingContent += ' </div>';
    loadingContent += '</div>';
    
    var errorMSG='<div class="alert alert-warning">No se pudo cargar el recurso. Intente nuevamente</div>';

$(document).ready(function() {

});


function desplegar(ruta) {
    $("#ajaxResponse").empty().hide();
    $.ajax({
        type: "GET",
        dataType: "html",
        url: ruta + '.htm',
        beforeSend: function() {
            console.log("Obteniendo recurso");
            $("#loader_bar_container").show();
        },
        success: function(response) {
            //Proceso terminado
            console.log("Recurso obtenido");
            //Condicionar este hide y fade in para pacientes y consultas
            if (ruta == "listapacientes" || ruta == "listaconsultas") {
                $("#ajaxResponse").empty().append(response);
            } else {
                $("#loader_bar_container").hide();
                $("#ajaxResponse").empty().append(response).fadeIn();
            }
        },
        error: function(response) {
            //Error en la respuesta
            $("#loader_bar_container").hide();
            console.log("No se pudo procesar la peticion");
        },
        statusCode: {
            404: function() {
                alert("Recurso no encontrado");
            },
            500: function() {
                alert("Error interno del servidor");
            }
        }
    });
}

function desplegar_popup(mapping) {
   
}

function aplicarEstilo(elemento) {
    $(elemento).toggleClass('active');
}


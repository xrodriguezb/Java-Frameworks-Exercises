$(document).ready(function() {

    $('#tablaPacientes').dataTable({
        "oLanguage": {
            "sUrl": "js/spanish.txt"
        },
        "bProcessing": true,
        "bServerSide": true,
        "sPaginationType": "full_numbers",
        "sAjaxSource": "generar_json_pacientes.htm",
        "columns": [
            {"data": "id"},
            {"data": "nombre"},
            {"data": "apellido"},
            {"data": "telefono"},
            {"data": "celular"},
            {"data": "email"},
            {"data": "editar"}
        ],
        "aoColumnDefs": [
            {
                'bSortable': false,
                'aTargets': [3]
            }
        ],
        "fnInitComplete": function() {
            $("#loader_bar_container").hide();
            $("#ajaxResponse").fadeIn();
        }

    });
});
function editarPaciente(id) {
    $.ajax({
        type: "POST", // o POST
        dataType: "html", // o JSON o TEXT
        url: 'editarpaciente.htm',
        data: 'id=' + id,
        beforeSend: function() {
            $.facebox(loadingContent);
        },
        success: function(response) {
            $.facebox(response);
        },
        error: function(response) {
            $.facebox(errorMSG);
        }
    }
    );
}

function paciente_saveOrUpdate() {
    $.ajax({
        type: "POST", // o POST
        dataType: "json", // o JSON o TEXT
        url: 'paciente_saveOrUpdate.htm',
        data: $("#formPaciente").serialize(),
        beforeSend: function() {
            $.facebox(loadingContent);
        },
        success: function(response) {
            $.facebox(response);
        },
        error: function(response) {
            $.facebox(errorMSG);
        }
    }
    );
}



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Medical Online</title>       
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">  
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/facebox.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
        <!--link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css"-->
        <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/plug-ins/9dcbecd42ad/integration/bootstrap/3/dataTables.bootstrap.css">
        


        <!-- librerías opcionales que activan el soporte de HTML5 para IE8 -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>

        <div class="navbar navbar">
            <div class="navbar-inner">
                <a class="brand" href="#">MedicalOnline</a>
                <ul class="nav">
                    <li><a href="javascript:desplegar('listapacientes');">Pacientes</a></li>
                    <li><a href="#">Consultas</a></li>
                    <li><a href="#">Configuración</a></li>
                </ul>
            </div>
        </div>

        <!-- CONTENEDOR DE DESPLIEGUE -->
        <div id="ajaxResponse" class="container">
        </div>


        <!-- BARRA DE PROGRESO -->
        <div id="loader_bar_container" style="padding:5px;display: none" align="center">
            <div id="progress_bar" style="width: 400px" align="center">
                Por favor espere...
                <div class="progress progress-striped active">
                    <div class="bar" style="width: 100%;"></div>
                </div>
            </div>
        </div>


        <script src="js/jquery.js"></script>        
        <script src="js/deploys.js"></script>
        <!--script src="js/bootstrap.min.js"></script-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
        <script src="js/jquery.dataTables.js"></script>
         <script src="//cdn.datatables.net/plug-ins/9dcbecd42ad/integration/bootstrap/3/dataTables.bootstrap.js"></script>
        <script src="js/facebox.js"></script>    
    </body>
</html>



<!DOCTYPE html>
<html>
    <head>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="js/panel.js" type="text/javascript"></script>
        <script src="js/facebox/facebox.js" type="text/javascript"></script>
        <script src="js/jquery.dataTables.js" type="text/javascript"></script>
        <script src="js/utileria.js" type="text/javascript"></script>       
        <link rel="stylesheet" type="text/css" href="css/facebox.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/notificaciones.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/botones.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/general.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/formularios.css" media="screen" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel de Control</title>
    </head>
    <body>
        <header>               
            <nav>
                <ul>
                    <li>
                        <a href="javascript:render('listarcategorias')">
                            Categor&iacute;as
                        </a>
                    </li>
                    <li>
                        <a href="javascript:render('listarlibros')">
                            Libros
                        </a>
                    </li>
                    <li>
                        <a href="javascript:render('reporte')">
                            Reportes
                        </a>
                    </li>                 
                </ul>
            </nav>
        </header>
        <div id="ajaxResponse"></div>
        <footer>
            <small>
                Copyright &copy; 2014 - XavierRodriguez                      
            </small>        
        </footer>
    </body>
</html>

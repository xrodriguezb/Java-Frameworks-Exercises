/*
 * Funciones reutilizadas entre modulos o generales del panel
 */

String.prototype.trim = function() {
    return this.replace(/^\s+|\s+$/g, "");
};
var div_loader = '<div style="text-align:center" id="loader_div"><p><img alt="buscando" src="imagenes/progressbar.gif" width="55" height="55"></div>';


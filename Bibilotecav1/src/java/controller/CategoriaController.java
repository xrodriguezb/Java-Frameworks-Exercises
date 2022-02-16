package controller;

import javax.servlet.http.HttpServletRequest;
import model.dao.CategoriaDAO;
import model.pojo.Categoria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoriaController {

    /*
     Metodo que recibe el tipo de accion INSERT, DELETE o UPDATE de una categoria
     Params:
     POST -> Tipo de accion a realizar (nombre y/o ID de la categoria)
     Return Sring respuesta -> Cadena json con el resultado de la accion
     */
    @RequestMapping(value = "opercategoria", method = RequestMethod.POST)
    public @ResponseBody
    String ejecutarAccion(HttpServletRequest request) {
        String accion = request.getParameter("action");
        String respuesta = "";
        if (accion.equals("guardar")) {
            respuesta = (CategoriaDAO.guardarCategoria(request.getParameter("nombre"))) ? "ok" : "error";
            respuesta = StringHelper.convertToUTF8(respuesta.trim());
        } else if (accion.equals("eliminar")) {
            respuesta = (CategoriaDAO.eliminarCategoria(Integer.parseInt(request.getParameter("id")))) ? "ok" : "error";
        } else if (accion.equals("actualizar")) {
            respuesta = (CategoriaDAO.actualizarCategoria(request.getParameter("nombre"), Integer.parseInt(request.getParameter("idCategoria")))) ? "ok" : "error";
            respuesta = StringHelper.convertToUTF8(respuesta.trim());
        }
        return "{\"serverResponse\":\"" + respuesta + "\"}";
    }
    
    @RequestMapping(value = "listarcategorias", method = RequestMethod.GET)
    public ModelAndView listarCategorias(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("categorias/listarcategorias");
        try {
            mv.addObject("categoria", CategoriaDAO.listarCategorias());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
    
    @RequestMapping(value = "crearcategoria", method = RequestMethod.GET)
    public ModelAndView crearCategoria(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("categorias/crearcategoria");
        int idCategoria = Integer.parseInt(request.getParameter("id"));
        if (idCategoria > 0) {
            try {
                Categoria cat = CategoriaDAO.verCategoriaPorID(idCategoria);
                mv.addObject("nombreCategoria", cat.getTxtNombreCategoria());
                mv.addObject("idCategoria", idCategoria);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mv;
    }
    
}

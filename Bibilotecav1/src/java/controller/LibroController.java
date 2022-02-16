/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.dao.CategoriaDAO;
import model.dao.LibroDAO;
import model.pojo.Categoria;
import model.pojo.Libro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author xrodriguez
 */
@Controller
public class LibroController {

    @RequestMapping(value = "/crearlibro", method = RequestMethod.GET)
    public ModelAndView crearLibro(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("libros/crearlibro");
        int idLibro = Integer.parseInt(request.getParameter("id"));
        if (idLibro == 0) {
            try {
                //Obtengo el listado del catalogo de categorias
                List<Categoria> lst = CategoriaDAO.listarCategorias();
                mv.addObject("categorias", lst);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                Libro libro = LibroDAO.verLibroPorID(idLibro);
                mv.addObject("libro", libro);
                mv.addObject("idLibro",idLibro);
                Categoria cat=(Categoria)libro.getCategoria();
                mv.addObject("idCategoria",cat.getIdCategoria());
                List<Categoria> lst = CategoriaDAO.listarCategorias();
                mv.addObject("categorias", lst);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mv;
    }

    @RequestMapping(value = "listarlibros", method = RequestMethod.GET)
    public ModelAndView listarLibros() {
        ModelAndView mv = new ModelAndView("libros/listarlibros");
        try {
            //Obtengo el listado del catalogo de categorias
            List<Libro> lst = LibroDAO.listarLibros();
            mv.addObject("libro", lst);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping(value = "/operlibro", method = RequestMethod.POST)
    public @ResponseBody
    String guardarLibro(HttpServletRequest request) {
        String accion = request.getParameter("action");
        String respuesta = "";
        if (accion.equals("guardar")) {
            Categoria cat = new Categoria();
            cat.setIdCategoria(Integer.parseInt(request.getParameter("categoria")));
            respuesta = (LibroDAO.guardarLibro(
                    request.getParameter("nombre"), request.getParameter("autor"), request.getParameter("editorial"), request.getParameter("isbn"), cat
            )) ? "ok" : "error";
            respuesta = StringHelper.convertToUTF8(respuesta.trim());
        } else if (accion.equals("actualizar")) {

        }
        return "{\"serverResponse\":\"" + respuesta + "\"}";

    }

    @ModelAttribute("datosLibro")
    public Libro populateForm() {
        return new Libro(); // creamos el bean para que se pueda popular
    }

}

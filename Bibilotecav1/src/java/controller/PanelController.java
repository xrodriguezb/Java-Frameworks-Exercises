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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author xrodriguez
 */
@Controller
public class PanelController {

    @RequestMapping("/panel")
    public ModelAndView verPanel() {
        ModelAndView mv = new ModelAndView("panel");
        return mv;
    }

}

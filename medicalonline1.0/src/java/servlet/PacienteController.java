/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.PacienteDAO;
import model.pojo.Paciente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author xrodriguez
 */
@Controller
public class PacienteController {

    @RequestMapping(value = "listapacientes", method = RequestMethod.GET)
    public ModelAndView listarPacientes(HttpServletRequest request) {

        ModelAndView mv = new ModelAndView("pacientes/listapacientes");
        //mv.addObject("pacientes", listadoPacientesAjax());
        return mv;
    }

    @RequestMapping(value = "editarpaciente", method = RequestMethod.POST)
    public ModelAndView editarPaciente(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("pacientes/editarpaciente");
        try {
            mv.addObject("paciente", PacienteDAO.verPacientePorID(Integer.parseInt(request.getParameter("id"))));
        } catch (Exception e) {
        }
        return mv;
    }

    @RequestMapping(value = "generar_json_pacientes")
    public @ResponseBody
    String listadoPacientesAjax(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        try {
            //Formo el where , defino orden y paginacion
            String search = "WHERE activo = 1 ";
            String sEcho = request.getParameter("sEcho");
            String order = "";
            String orderColumn = request.getParameter("iSortCol_0");
            String orderDir = request.getParameter("sSortDir_0");
            String start = (!request.getParameter("iDisplayStart").equals("")) ? request.getParameter("iDisplayStart") : "0";
            String length = (!request.getParameter("iDisplayLength").equals("")) ? request.getParameter("iDisplayLength") : "10";
            String searchValue = request.getParameter("sSearch");
            String searchable = request.getParameter("bSearchable_0");
            String[] campos = {"idPaciente", "txtNombre", "txtApellido", "txtTelefono", "txtCelular", "txtEmail"};

            if (!searchValue.equals("") && searchable.equals("true")) {
                int i = 0;
                search += "AND (";
                for (String campo : campos) {
                    String[] searchLikes = searchValue.split(" ");
                    search += (i == 0) ? "" : " OR " + "(";
                    int j = 0;
                    for (String sl : searchLikes) {
                        search += " " + (j == 0 ? "" : " AND ") + campo + " LIKE '%" + sl + "%' ";
                        j++;
                    }
                    search += ") ";
                    i++;
                }
                search += ") ";
            }

            order = (!orderColumn.equals("") && !orderDir.equals("")) ? "ORDER BY " + campos[Integer.parseInt(orderColumn)] + " " + orderDir : "ORDER BY " + campos[0] + " asc";
            List<Paciente> pacientesList = null;
            pacientesList = PacienteDAO.listarPacientes(search, order, Integer.parseInt(start), Integer.parseInt(length));
            List<Object> data = new ArrayList<>();
            for (Paciente paciente : pacientesList) {
                Map<String, Object> row = new HashMap<>();
                row.put("id", paciente.getIdPaciente());
                row.put("nombre", paciente.getTxtNombre());
                row.put("apellido", paciente.getTxtApellido());
                row.put("telefono", paciente.getTxtTelefono());
                row.put("celular", paciente.getTxtCelular());
                row.put("email", paciente.getTxtEmail());
                row.put("editar", "<button type=\"button\" class=\"btn btn-default\" onclick=\"editarPaciente(" + paciente.getIdPaciente() + ");\" title=\"Editar Paciente\"><span class=\"glyphicon glyphicon-pencil\"></span></button>");
                data.add(row);
            }

            DataTablePaciente dtp = new DataTablePaciente();
            dtp.setAaData(data);
            dtp.setiTotalDisplayRecords(PacienteDAO.totalPacientes());
            dtp.setiTotalRecords(PacienteDAO.totalPacientes());
            dtp.setsEcho(sEcho);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(dtp);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "paciente_saveOrUpdate", method = RequestMethod.POST)
    public @ResponseBody
    String guardarPaciente(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String resultado = "";

        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String celular = request.getParameter("celular");
        String domicilio = request.getParameter("domicilio");
        int id = (request.getParameter("id") != null) ? Integer.parseInt(request.getParameter("id")) : 0;
        //String motivoDuplicidad = "";
        Paciente p = new Paciente();
        p.setTxtNombre(request.getParameter("nombre"));
        p.setTxtApellido(request.getParameter("apellido"));
        try {
            if (email != null) {
                p.setTxtEmail(email);
            } else if (telefono != null) {
                p.setTxtTelefono(telefono);
            } else if (celular != null) {
                p.setTxtCelular(celular);
            }

            if (domicilio != null) {
                p.setTxtDomicilio(domicilio);
            }
            
            UUID pacienteToken = UUID.randomUUID();
            p.setTxtToken("PAC"+pacienteToken);
                        
            //Guardamos el nuevo paciente
            resultado = (PacienteDAO.guardarPaciente(p)) ? "{\"serverResponse\":\"ok\"}" : "{\"serverResponse\":\"error\"}";

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

    private @ResponseBody
    String verificaMotivoDuplicidad(List<Paciente> lst) {
        System.out.println("Verificando duplicidad...");
        String msg = "";
        if (lst.size() > 0) {
            for (Paciente pa : lst) {
                msg = "{\"serverResponse\":\"duplicado\",\"idPaciente\":\"" + pa.getIdPaciente() + "\"}";
                break;
            }
        }
        System.out.println("json: " + msg);
        return msg;

    }

    public static String toJson(Paciente pac) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(pac);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}

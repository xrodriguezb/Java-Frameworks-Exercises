/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Paciente;
import model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author xrodriguez
 */
public class PacienteDAO {

    public static List<Paciente> listarPacientes(String search, String order, int start, int length) {
        List<Paciente> lst = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            //Como puedo obtener todos usando solo el session.get
            String sql = "SELECT NEW model.pojo.Paciente(idPaciente,txtNombre,txtApellido,txtTelefono,txtCelular,txtEmail) "
                    + "FROM Paciente "
                    + search + " " + order;
            //System.out.println("CONSULTA: " + sql);
            Query query = session.createQuery(sql);
            query.setFirstResult(start);
            query.setMaxResults(length);
            lst = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }

    public static int totalPacientes() {
        int total = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String sql = "SELECT COUNT(idPaciente) FROM Paciente WHERE activo=1";
            Query query = session.createQuery(sql);
            total = Integer.parseInt(String.valueOf(query.uniqueResult()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public static Paciente verPacientePorID(int id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Paciente instance = (Paciente) session.get(Paciente.class, id);
            return instance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean guardarPaciente(Paciente pac) {
        boolean result = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            //session.beginTransaction();
            session.save(pac);
            // session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<Paciente> existePaciente(String email, String telefono, String celular,int id) {
        List<Paciente> result = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Criteria crit = session.createCriteria(Paciente.class);

            /*switch (campo) {
             case "email":
             crit.add(Restrictions.eq("txtEmail", valor));
             break;
             case "telefono":
             crit.add(Restrictions.eq("txtTelefono", valor));
             break;
             case "celular":
             crit.add(Restrictions.eq("txtCelular", valor));
             break;
             }*/
            result = crit.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

}

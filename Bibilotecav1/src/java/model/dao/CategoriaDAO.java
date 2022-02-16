/*
 Tratamiento de la clase persistente Categoria
 */
package model.dao;

import java.util.List;
import model.pojo.Categoria;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author xrodriguez
 */
public class CategoriaDAO {

    public static List<Categoria> listarCategorias() {
        List<Categoria> lst = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            //Como puedo obtener todos usando solo el session.get
            String sql = "from Categoria where intActivo=1";
            Query query = session.createQuery(sql);
            lst = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public static Categoria verCategoriaPorID(int idCategoria) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            //DUDA
            //Que es mejor, obtener un objeto de tipo Categoria por ID
            //O hacer una consulta con HQL
            Categoria instance = (Categoria) session.get(Categoria.class, idCategoria);
            return instance;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean guardarCategoria(String nuevaCategoria) {
        Categoria cat = new Categoria();
        cat.setTxtNombreCategoria(nuevaCategoria);
        cat.setIntActivo(true);
        boolean result = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cat);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean actualizarCategoria(String nombre, int idCategoria) {
        //Se puede hacer con flush o con saveOrUpdate
        boolean result = false;
        try {
            //es necesario el open sesion?
            Session session = HibernateUtil.getSessionFactory().openSession();
            //Puede ser Categoria.class o model.pojo.Categoria?
            Categoria instance = (Categoria) session.get(Categoria.class, idCategoria);
            instance.setTxtNombreCategoria(nombre);
            session.beginTransaction();
            session.saveOrUpdate(instance);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean eliminarCategoria(int idCategoria) {
        boolean result = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Categoria instance = (Categoria) session.get(Categoria.class, idCategoria);
            instance.setIntActivo(false);
            session.beginTransaction();
            session.saveOrUpdate(instance);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}

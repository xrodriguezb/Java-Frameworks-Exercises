/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Categoria;
import model.pojo.Libro;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author xrodriguez
 */
public class LibroDAO {

    public static boolean guardarLibro(String nombre, String autor, String editorial, String isbn, Categoria cat) {
        boolean result = false;
        try {
            Libro lib = new Libro();
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            lib.setTxtNombre(nombre);
            lib.setTxtAutor(autor);
            lib.setTxtEditorial(editorial);
            lib.setTxtIsbn(isbn);
            lib.setCategoria(cat);
            lib.setIntActivo(true);
            session.save(lib);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static boolean actualizarLibro(String nombre, String autor, String editorial, String isbn, Categoria cat,int idLibro) {
        boolean result = false;
        try {            
            Session session = HibernateUtil.getSessionFactory().openSession();
            Libro lib=(Libro)session.get(Libro.class, idLibro);
            session.beginTransaction();
            lib.setTxtNombre(nombre);
            lib.setTxtAutor(autor);
            lib.setTxtEditorial(editorial);
            lib.setTxtIsbn(isbn);
            lib.setCategoria(cat);
            lib.setIntActivo(true);
            session.saveOrUpdate(lib);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Libro> listarLibros() {
        List<Libro> lst = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String sql = "from Libro";
            Query query = session.createQuery(sql);
            lst = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
    public static Libro verLibroPorID(int idLibro) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Libro libro = (Libro) session.get(Libro.class, idLibro);
            return libro;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

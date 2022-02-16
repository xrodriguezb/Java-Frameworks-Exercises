/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.util.List;
import model.pojo.Paciente;

/**
 *
 * @author xrodriguez
 */
public class DataTablePaciente {

    int iTotalRecords;

    int iTotalDisplayRecords;

    String sEcho;

    String sColumns;

    List<Object> aaData;

    public int getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(int iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public int getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public String getsEcho() {
        return sEcho;
    }

    public void setsEcho(String sEcho) {
        this.sEcho = sEcho;
    }

    public String getsColumns() {
        return sColumns;
    }

    public void setsColumns(String sColumns) {
        this.sColumns = sColumns;
    }

    public List<Object> getAaData() {
        return aaData;
    }

    public void setAaData(List<Object> aaData) {
        this.aaData = aaData;
    }

}

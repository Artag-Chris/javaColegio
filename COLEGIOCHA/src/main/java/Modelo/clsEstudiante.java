/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import controlador.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian Henao A.
 */
public class clsEstudiante {
     //atributos
    private String docEst="";
    private String nomEst ="";
    private String apeEst="";
    private String dirEst="";
    private String telEst="";
    clsConexion objCone = new clsConexion();
    Connection conect = objCone.conectar();
    public String[] datos = new String[5];
    //encapsulamiento

    public String getDocEst() {
        return docEst;
    }

    public String getNomEst() {
        return nomEst;
    }

    public String getApeEst() {
        return apeEst;
    }

    public String getDirEst() {
        return dirEst;
    }

    public String getTelEst() {
        return telEst;
    }

    public void setDocEst(String docEst) {
        this.docEst = docEst;
    }

    public void setNomEst(String nomEst) {
        this.nomEst = nomEst;
    }

    public void setApeEst(String apeEst) {
        this.apeEst = apeEst;
    }

    public void setDirEst(String dirEst) {
        this.dirEst = dirEst;
    }

    public void setTelEst(String telEst) {
        this.telEst = telEst;
    }
    //construtor 

    public clsEstudiante() {
    }
    public clsEstudiante(String docEst, String nomEst, String apeEst,String dirEst,String telEst ){
    this.docEst=docEst;
    this.nomEst=nomEst;
    this.apeEst=apeEst;
    this.dirEst=dirEst;
    this.telEst=telEst;
    }
    //metodos 
    //guardar a la base de datos
    public void guardar() {
        try {
            objCone.conectar();
            PreparedStatement almacenar = conect.prepareStatement("insert into estudiante (docEst,nomEst,apeEst,dirEst,telEst) values(?,?,?,?,?)");
            almacenar.setString(1, getDocEst());
            almacenar.setString(2, getNomEst());
            almacenar.setString(3, getApeEst());
            almacenar.setString(4, getDirEst());
            almacenar.setString(5, getTelEst());
            almacenar.executeUpdate();
            objCone.cerrar();
            JOptionPane.showMessageDialog(null, "Registro guardado con éxito");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar " +ex);
        }
    }
    //metodo de busqueda en la base de datos
    public void buscarDatos() {
        try {
            String bus = JOptionPane.showInputDialog("Digite el codigo del estudiante");
            Statement mostrar = conect.createStatement();
            ResultSet resultado = mostrar.executeQuery("SELECT * FROM estudiante where docEst = '" +bus+ "'");
            

            while (resultado.next()) {
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(4);
                datos[4] = resultado.getString(5);                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "nope");
        }
    }
    //metodo para actualizar en base de datos 
     public void actualizar() {
        try {
            String bus = getDocEst();
            PreparedStatement almacenar = conect.prepareStatement("UPDATE estudiante SET nomEst='" + getNomEst() + "', apeEst='" + getApeEst() + "', dirEst='" + getDirEst() + "',telEst='" + getTelEst() + "' WHERE docEst='" + bus + "'");

            almacenar.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro actualizado con éxito");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar:");
        }
    }
}

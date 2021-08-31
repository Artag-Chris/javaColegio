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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian Henao A
 */
public class clsProfesor {
      //atributos 
    private String docPro="";
    private String nomPro="";
    private String apePro="";
    private String dirPro="";
    private String telPro="";
    private String emaPro="";
    private String titPro="";
    clsConexion objCone = new clsConexion();
    Connection conect = objCone.conectar();
    String[] datos = new String[7];
    DefaultTableModel tablaMat = new DefaultTableModel();
    String[] datosMateria = new String[3];
    
    //encapsulamiento

    public String getDocPro() {
        return docPro;
    }

    public String getNomPro() {
        return nomPro;
    }

    public String getApePro() {
        return apePro;
    }

    public String getDirPro() {
        return dirPro;
    }

    public String getTelPro() {
        return telPro;
    }

    public String getEmaPro() {
        return emaPro;
    }

    public DefaultTableModel getTablaMat() {
        return tablaMat;
    }

    public String getTitPro() {
        return titPro;
    }

    public String[] getDatos() {
        return datos;
    }
    
    

    public void setDocPro(String docPro) {
        this.docPro = docPro;
    }

    public void setNomPro(String nomPro) {
        this.nomPro = nomPro;
    }

    public void setApePro(String apePro) {
        this.apePro = apePro;
    }

    public void setDirPro(String dirPro) {
        this.dirPro = dirPro;
    }

    public void setTelPro(String telPro) {
        this.telPro = telPro;
    }

    public void setEmaPro(String emaPro) {
        this.emaPro = emaPro;
    }

    public void setTitPro(String titPro) {
        this.titPro = titPro;
    }

    public void setTablaMat(DefaultTableModel tablaMat) {
        this.tablaMat = tablaMat;
    }

    public void setDatos(String[] datos) {
        this.datos = datos;
    }
    
    //constructor

    public clsProfesor() {
    }
    public clsProfesor(String docPro,String nomPro,String apePro,String dirPro,String telPro,String emaPro,String titPro) {
        this.docPro=docPro;
        this.nomPro=nomPro;
        this.apePro=apePro;
        this.dirPro=dirPro;
        this.telPro=telPro;
        this.emaPro=emaPro;
        this.titPro=titPro;
    }
    //metodos 
    //guardar a la base de datos
    public void guardar() {
        try {
            objCone.conectar();
            PreparedStatement almacenar = conect.prepareStatement("insert into profesor (docPro,nomPro,apePro,dirPro,telPro,emaPro,titPro) values(?,?,?,?,?,?,?)");
            almacenar.setString(1, getDocPro());
            almacenar.setString(2, getNomPro());
            almacenar.setString(3, getApePro());
            almacenar.setString(4, getDirPro());
            almacenar.setString(5, getTelPro());
            almacenar.setString(6, getEmaPro());
            almacenar.setString(7, getTitPro());
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
            String bus = JOptionPane.showInputDialog("Digite el codigo del Profesor");
            Statement mostrar = conect.createStatement();
            ResultSet resultado = mostrar.executeQuery("SELECT * FROM profesor where docPro = '" +bus+ "'");
            

            while (resultado.next()) {
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(4);
                datos[4] = resultado.getString(5);
                datos[5] = resultado.getString(6);
                datos[6] = resultado.getString(7);                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "nope");
        }
    }
    //metodo para actualizar en base de datos 
     public void actualizar() {
        try {
            String bus = getDocPro();
            PreparedStatement almacenar = conect.prepareStatement("UPDATE profesor SET nomPro='" + getNomPro() + "', apePro='" + getApePro() + "', dirPro='" + getDirPro() + "',telPro='" + getTelPro() +"',emaPro='" + getEmaPro() +"',titPro='" + getTitPro()+"' WHERE docPro='" + bus + "'");

            almacenar.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro actualizado con éxito");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar:");
        }
    }
     //metodo para ver tabla de materias
     public void verTabla(){
        tablaMat.addColumn("Codigo");
        tablaMat.addColumn("Nombre");
        tablaMat.addColumn("Grado");
        try {
            Statement leer = conect.createStatement();
            ResultSet mostrar = leer.executeQuery("SELECT * FROM materia");

            while (mostrar.next()) {
                datosMateria[0] = mostrar.getString(1);
                datosMateria[1] = mostrar.getString(2);
                datosMateria[2] = mostrar.getString(3);

               tablaMat.addRow(datosMateria);
            }
        } catch (Exception e) {
        }
        
    }
     }



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
 * @author scris
 */
public class clsAcudiente {
    //atributos
    private String docAcu="";
    private String nomAcu ="";
    private String apeAcu="";
    private String dirAcu="";
    private String telAcu="";
    private String emaAcu="";
    clsConexion objCone = new clsConexion();
    Connection conect = objCone.conectar();
    private String[] datos = new String[6];
    private DefaultTableModel tablaEst = new DefaultTableModel();
    String[] datosEstudiantes = new String[5];
    //encapsulamiento

    public String getDocAcu() {
        return docAcu;
    }

    public DefaultTableModel getTablaEst() {
        return tablaEst;
    }
    

    public String getNomAcu() {
        return nomAcu;
    }

    public String getApeAcu() {
        return apeAcu;
    }

    public String getDirAcu() {
        return dirAcu;
    }

    public String getTelAcu() {
        return telAcu;
    }

    public String getEmaAcu() {
        return emaAcu;
    }

    public String[] getDatos() {
        return datos;
    }
    
    

    public void setDocAcu(String docAcut) {
        this.docAcu = docAcut;
    }

    public void setDatos(String[] datos) {
        this.datos = datos;
    }
    

    public void setNomAcu(String nomAcu) {
        this.nomAcu = nomAcu;
    }

    public void setApeAcu(String apeAcu) {
        this.apeAcu = apeAcu;
    }

    public void setDirAcu(String dirAcu) {
        this.dirAcu = dirAcu;
    }

    public void setTelAcu(String telAcu) {
        this.telAcu = telAcu;
    }

    public void setEmaAcu(String emaAcu) {
        this.emaAcu = emaAcu;
    }

    public void setTablaEst(DefaultTableModel tablaEst) {
        this.tablaEst = tablaEst;
    }
    
    //constructor

    public clsAcudiente() {
    }
    
     public clsAcudiente(String docAcu,String nomAcu, String apeAcu, String dirAcu, String telAcu, String emaAcu) {
         this.docAcu=docAcu;
         this.nomAcu=nomAcu;
         this.apeAcu=apeAcu;
         this.dirAcu=dirAcu;
         this.telAcu=telAcu;
         this.emaAcu=emaAcu;
    }
    
    //metodos 
     public void guardar(){
     try {
            objCone.conectar();
            PreparedStatement almacenar = conect.prepareStatement("insert into acudiente (docAcu,nomAcu,apeAcu,dirAcu,telAcu,emaAcu) values(?,?,?,?,?,?)");
            almacenar.setString(1, getDocAcu());
            almacenar.setString(2, getNomAcu());
            almacenar.setString(3, getApeAcu());
            almacenar.setString(4, getDirAcu());
            almacenar.setString(5, getTelAcu());
            almacenar.setString(6, getEmaAcu());
            almacenar.executeUpdate();
            objCone.cerrar();
            JOptionPane.showMessageDialog(null, "Registro guardado con éxito");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar " +ex);
        }
     }
     public void buscarDatos(){
     try {
            String bus = JOptionPane.showInputDialog("Digite el codigo del Acudiente");
            Statement mostrar = conect.createStatement();
            ResultSet resultado = mostrar.executeQuery("SELECT * FROM acudiente where docAcu = '" +bus+ "'");
            

            while (resultado.next()) {
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(4);
                datos[4] = resultado.getString(5);
                datos[5] = resultado.getString(6);
                                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "nope");
        }
     }
     //metodo de actualizar
    public void actualizar() {
       try {
            String bus = getDocAcu();
            PreparedStatement almacenar = conect.prepareStatement("UPDATE acudiente SET nomAcu='" + getNomAcu() + "', apeAcu='" + getApeAcu() + "', dirAcu='" + getDirAcu() + "',telAcu='" + getTelAcu() +"',emaAcu='" + getEmaAcu() +"' WHERE docAcu='" + bus + "'");

            almacenar.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro actualizado con éxito");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar:");
        }
    }
    public void verTabla(){
        tablaEst.addColumn("Codigo");
        tablaEst.addColumn("Nombre");
        tablaEst.addColumn("Apellido");
        tablaEst.addColumn("Direccion");
        tablaEst.addColumn("Telefono");
        try {
            Statement leer = conect.createStatement();
            ResultSet mostrar = leer.executeQuery("SELECT * FROM Estudiante");

            while (mostrar.next()) {
                datosEstudiantes[0] = mostrar.getString(1);
                datosEstudiantes[1] = mostrar.getString(2);
                datosEstudiantes[2] = mostrar.getString(3);
                datosEstudiantes[3] = mostrar.getString(4);
                datosEstudiantes[4] = mostrar.getString(5);

               tablaEst.addRow(datosEstudiantes);
            }
        } catch (Exception e) {
        }
        
    }

}

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
public class clsMateria {
    //atributos
    private byte codMat=0;
    private String nomMat="";
    private String graMat="";
    clsConexion objCone = new clsConexion();
    Connection conect = objCone.conectar();
    public String[] datos = new String[3];
    //encapsulamiento

    public byte getCodMat() {
        return codMat;
    }

    public String getNomMat() {
        return nomMat;
    }

    public String getGraMat() {
        return graMat;
    }

    public void setCodMat(byte codMat) {
        this.codMat = codMat;
    }

    public void setNomMat(String nomMat) {
        this.nomMat = nomMat;
    }

    public void setGraMat(String graMat) {
        this.graMat = graMat;
    }
    //constructor

    public clsMateria() {
    }
    
    public clsMateria(byte codMat, String nomMat, String gratMat) {
        this.codMat=codMat;
        this.nomMat=nomMat;
        this.graMat=gratMat;
    }
    //metodos
    //guardar
    public void guardar() {
        try {
            objCone.conectar();
            PreparedStatement almacenar = conect.prepareStatement("insert into materia (nomMat,graMat) values(?,?)");
            almacenar.setString(1, getNomMat());
            almacenar.setString(2, getGraMat());
            almacenar.executeUpdate();
            objCone.cerrar();
            JOptionPane.showMessageDialog(null, "Registro guardado con éxito");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar " +ex);

        }

    }
    //buscar
    //metodo de busqueda
    public void buscarDatos() {
        try {
            String bus = JOptionPane.showInputDialog("Digite el codigo de la materia");
            Statement mostrar = conect.createStatement();
            ResultSet resultado = mostrar.executeQuery("SELECT * FROM materia where codMat = '" + bus + "'");
            

            while (resultado.next()) {
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
            
            }
             } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "nope");
        }
    }  
    //actualizar
    public void actualizar() {
        try {
            objCone.conectar();
            Byte bus= getCodMat();
            PreparedStatement almacenar = conect.prepareStatement("UPDATE materia  SET nomMat='" + getNomMat() + "', graMat='" + getGraMat() + "' WHERE codMat='" + getCodMat() + "'");
         

            almacenar.executeUpdate();
            objCone.cerrar();
            JOptionPane.showMessageDialog(null, "Registro actualizado con éxito");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar:");
        }
    }
}
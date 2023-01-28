/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PoliCalendar.Controlador;

import PoliCalendar.Controlador.VentanaController.Actividad;
import PoliCalendar.Controlador.VentanaController.Carrera;
import PoliCalendar.Controlador.VentanaController.Estudiante;
import PoliCalendar.Controlador.VentanaController.Recordatorio;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class Conection {      
    public static  java.sql.Connection getConnectionSQL() {
        java.sql.Connection conect = null;
        try {
            conect = DriverManager.getConnection("jdbc:sqlserver://CARLOS-WIN11:1433;"
                    + "instance=SQLEXPRES;"
                    + "database=Civil;"
                    + "user=sa;"
                    + "password=P@ssw0rd;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;"
//                    + "trustServerCertificate=false;"
                    + "loginTimeout=30;");
            System.out.println("Conexion con SQL Server exitosa");
            //JOptionPane.showMessageDialog(null, "Conexion con PostgreSQL exitosa");
            return conect;
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error de Conexion " + e);
            System.out.println(e);
}
        return null;
    }
    public static  java.sql.Connection getConnectionSQL2() {
        java.sql.Connection conect = null;
        try {
            conect = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-AV5A5DAQ:1433;"
                    + "instance=SQLEXPRES;"
                    + "database=Sistemas;"
                    + "user=sa;"
                    + "password=P@ssw0rd;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;"
//                    + "trustServerCertificate=false;"
                    + "loginTimeout=30;");
            System.out.println("Conexion con SQL Server exitosa");
            //JOptionPane.showMessageDialog(null, "Conexion con PostgreSQL exitosa");
            return conect;
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error de Conexion " + e);
            System.out.println(e);
}
        return null;
    }    
   
    public static ObservableList<Carrera> getCarreras(){
        java.sql.Connection conn= getConnectionSQL();
        ObservableList<Carrera> list = FXCollections.observableArrayList();
        try{
            PreparedStatement SC = conn.prepareStatement("SELECT *FROM [Civil].[dbo].[vista_Carrera]");
            ResultSet RC = SC.executeQuery();
            
            while(RC.next()){
                list.add(new Carrera(RC.getString("NOMBRECARRERA"), RC.getString("IDFACULTAD"), RC.getString("MODALIDAD")));
            }
        }
        catch(Exception e){
            
        }
        return list;
    }
    //
    public static ObservableList<Estudiante> getEstudiantes(){
        java.sql.Connection conn= getConnectionSQL();
        ObservableList<Estudiante> list = FXCollections.observableArrayList();
        try{
            PreparedStatement SC = conn.prepareStatement("SELECT *FROM [Civil].[dbo].[ESTUDIANTE]");
            ResultSet RC = SC.executeQuery();
            
            while(RC.next()){
                list.add(new Estudiante(RC.getString("CODIGOUNICO"), RC.getString("IDFACULTAD"), RC.getString("NOMBRECARRERA"),RC.getString("NOMBREESTUDIANTE"),RC.getString("EDADESTUDIANTE"),RC.getString("SEMESTRE")));
            }
        }
        catch(Exception e){
            
        }
        return list;
    }
    public static ObservableList<Recordatorio> getRecordatorios(){
        java.sql.Connection conn= getConnectionSQL();
        ObservableList<Recordatorio> list = FXCollections.observableArrayList();
        try{
            PreparedStatement SC = conn.prepareStatement("SELECT *FROM [Civil].[dbo].[vista_Recordatorio]");
            ResultSet RC = SC.executeQuery();
            
            while(RC.next()){
                list.add(new Recordatorio(RC.getString("IDRECORDATORIO"), RC.getString("IDFACULTAD"), RC.getString("CODIGOUNICO"),RC.getString("UID"),RC.getString("PERIODO"),RC.getString("ENTREGADO")));
            }
        }
        catch(Exception e){
            
        }
        return list;
    }

    public static ObservableList<Actividad> getActividades(){
        java.sql.Connection conn= getConnectionSQL();
        ObservableList<Actividad> list = FXCollections.observableArrayList();
        try{
            PreparedStatement SC = conn.prepareStatement("SELECT *FROM [Civil].[dbo].[ACTIVIDAD]");
            ResultSet RC = SC.executeQuery();
            
            while(RC.next()){
                list.add(new Actividad(RC.getString("UID"), RC.getString("IDFACULTAD"), RC.getString("SUMMARY"),RC.getString("DESCRIPTION"),RC.getString("DATESTRAMP"),RC.getString("DATESTART"),RC.getString("DATEEND"),RC.getString("CATEGORIES")));
            }
        }
        catch(Exception e){
            
        }
        return list;
    }    
    //

    static void InsertEst(int codigoUnico, int Facultad, String Carrera, String Estudiante, int edad, int Semestre) throws SQLException {
          java.sql.Connection conn= getConnectionSQL();           
        
        PreparedStatement Val= conn.prepareStatement("set xact_abort on SELECT CODIGOUNICO FROM [Civil]"
                    + ".[dbo].[vista_Estudiante] WHERE CODIGOUNICO ="+ codigoUnico +"");
        ResultSet RVal = Val.executeQuery();
        if(RVal.getString("CODIGOUNICO").equals(""+codigoUnico)){
            System.out.println("Error codigo unico ya existente");
        }
        else{
        try{
            PreparedStatement SC = conn.prepareStatement("set xact_abort on INSERT INTO [Civil]"
                    + ".[dbo].[vista_Estudiante] VALUES("+codigoUnico +","+Facultad+",'"+Carrera+"','"+Estudiante+"',"+edad+","+Semestre+")");
            ResultSet RC = SC.executeQuery();
            
        }
        catch(Exception e){
            System.out.print(e);
        }
        }
    }
        

    static void updateEst(String codigoUnico, int Facultad, String Carrera, String Estudiante, int edad, int Semestre) {
        
    }

    static void saveCarrera(String Carrera, int Facultad, String Modalidad) {
                  java.sql.Connection conn= getConnectionSQL();           
        
        try{
            PreparedStatement SC = conn.prepareStatement("set xact_abort on INSERT INTO [Civil]"
                    + ".[dbo].[vista_Carrera] VALUES('"+Carrera +"',"+Facultad+",'"+Modalidad+"')");
            ResultSet RC = SC.executeQuery();
            
        }
        catch(Exception e){
            System.out.print(e);
        }
    }

    static void saveModCarrera(String Carrera, int Facultad, String Modalidad) {
        
    }

    static void saveModRecordatorio(String Recordatorio, String NuevoPed) {
        
    }

    static void saveModActividad(int Actividad, String fechaEnt) {
        
    }

    static void DeleteEstudiante(int codigoUnico) {
        java.sql.Connection conn= getConnectionSQL();           
        
        try{
            PreparedStatement SC = conn.prepareStatement("set xact_abort on DELETE FROM [Civil]"
                    + ".[dbo].[vista_Estudiante] WHERE CODIGOUNICO = " + codigoUnico);
            ResultSet RC = SC.executeQuery();
            
        }
        catch(Exception e){
            System.out.print(e);
        }
    }

    static void DeleteCarrera(String nombreCarrera) {
        java.sql.Connection conn= getConnectionSQL();           
        
        try{
            PreparedStatement SC = conn.prepareStatement("set xact_abort on DELETE FROM [Civil]"
                    + ".[dbo].[vista_Carrera] WHERE NOMBRECARRERA = " + nombreCarrera);
            ResultSet RC = SC.executeQuery();
            
        }
        catch(Exception e){
            System.out.print(e);
        }        

    }

    static void DeleteRecor(int Recordatorio) {
        java.sql.Connection conn= getConnectionSQL();           
        
        try{
            PreparedStatement SC = conn.prepareStatement("set xact_abort on DELETE FROM [Civil]"
                    + ".[dbo].[vista_Recordatorio] WHERE IDRECORDATORIO = " + Recordatorio);
            ResultSet RC = SC.executeQuery();
            
        }
        catch(Exception e){
            System.out.print(e);
        }        

    }

    static void saveModActividad(int Actividad) {
        java.sql.Connection conn= getConnectionSQL();           
        
        try{
            PreparedStatement SC = conn.prepareStatement("set xact_abort on DELETE FROM [Civil]"
                    + ".[dbo].[vista_Actividad] WHERE UID = " + Actividad);
            ResultSet RC = SC.executeQuery();
            
        }
        catch(Exception e){
            System.out.print(e);
        }        
        
    }

}

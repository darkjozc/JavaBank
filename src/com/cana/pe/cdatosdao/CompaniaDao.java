
package com.cana.pe.cdatosdao;

import com.cana.pe.cmodelo.Compania;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CompaniaDao {
    private String mensaje;
public String agregarCompania(Connection conn, Compania compania){
    PreparedStatement ps = null;
    String sql ="INSERT INTO COMPAÑIA (NOMBRE, NUMEROCOMPAÑIA)" + "VALUES(?, ?)";
    try {
        ps = conn.prepareStatement(sql);
        ps.setString(1,compania.getNombre());
        ps.setInt(2,compania.getNumeroCompañia());
        ps.execute();
        ps.close();
        mensaje ="La compañia fue creada Correctamente";         
    } catch (Exception e) {
        mensaje = "Alto! Perro!! error al crear compañia";
        System.out.println(e.getMessage());
      }
    return mensaje;   
}
public String elminarCompania(Connection conn, Compania compania){
       PreparedStatement ps = null;
       String sql ="DELETE FROM COMPAÑIA WHERE ID_COMPAÑIA = ?";
       try {
        ps = conn.prepareStatement(sql);
        ps.setInt(1, compania.getId_compañia());
        ps.execute();
        ps.close();
        mensaje = "La compañia fue eliminada Correctamente";
    } catch (Exception e) {
        mensaje = "Alto! error al elminar compañia. " + e.getMessage();
        System.out.println(e.getMessage());
    }
       return mensaje;
    }
public String modificarCompania(Connection conn, Compania compania){
    PreparedStatement ps = null;
    String sql = "UPDATE COMPAÑIA " 
            + "SET NOMBRE=?, NUMEROCOMPAÑIA=? "
            + "WHERE ID_COMPAÑIA=?";
    try {
        ps = conn.prepareStatement(sql);
        ps.setString(1, compania.getNombre());
        ps.setInt(2, compania.getNumeroCompañia());
        ps.setInt(3, compania.getId_compañia()); 
        ps.execute();
        ps.close();
        mensaje = "La compañia fue actualizada correactamente";
    } catch (Exception e) {
        mensaje = "Alto! error al actualizar compañia";
        System.out.println(e.getMessage());
    }
    return mensaje;
}
public void listarCompania(Connection conn, JTable table){
    DefaultTableModel model;
    Statement statement = null;
    ResultSet resultSet = null;
    
    String [] columnas = {"ID", " NOMBRE ", " NUMEROCOMPAÑIA "};
    model = new DefaultTableModel(null, columnas);
    String sql = "SELECT * FROM COMPAÑIA";
    String [] datosTP = new String[4];
    try {
        statement = conn.createStatement();
        resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            Compania td = new Compania();
            td.setId_compañia(resultSet.getInt("ID_COMPAÑIA"));
            td.setNombre(resultSet.getString("NOMBRE"));
            td.setNumeroCompañia(resultSet.getInt("NUMEROCOMPAÑIA"));
            
            datosTP[0] = td.getId_compañia()+"";
            datosTP[1] = td.getNombre()+"";
            datosTP[2] = td.getNumeroCompañia()+"";
            
            model.addRow(datosTP);
        }
        table.setModel(model);
    } catch (Exception e) {
          JOptionPane.showConfirmDialog(null, "Erro:" +e.getMessage());
           System.err.println(e.getMessage());
    }
    
    
}
}


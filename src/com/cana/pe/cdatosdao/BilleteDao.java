
package com.cana.pe.cdatosdao;

import com.cana.pe.cmodelo.Billete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BilleteDao {
    private String mensaje;
public String agregarBillete(Connection conn, Billete billete){
    PreparedStatement ps = null;
    String sql ="INSERT INTO BILLETE (FECHA, HORA, ITINERARIO, NUMERO_BILLETE, ID_CLIENTE, ID_COMPAÑIA) " 
               + "VALUES (?, ?, ?, ?, ?, ?)";
    try {
        ps = conn.prepareStatement(sql);
        ps.setString(1, billete.getFecha());
        ps.setString(2, billete.getHora());
        ps.setString(3, billete.getItinerario());
        ps.setInt(4, billete.getNumero_billete());
        ps.setInt(5, billete.getId_cliente());
        ps.setInt(6, billete.getId_compañia());
        ps.execute();
        ps.close();
        mensaje = "El billete fue creado correctamente";
    } catch (Exception e) {
         mensaje = "Alto! Perro!! error al crear el Billete"; 
         System.out.println(e.getMessage());
    }
    return mensaje;  
}
public String elminarBillete(Connection conn, Billete billete){
    PreparedStatement ps = null;
    String sql ="DELETE FROM BILLETE WHERE ID_BILLETE = ?";
    try {
        ps = conn.prepareStatement(sql);
        ps.setInt(1, billete.getId_billete());
        ps.execute();
        ps.close();
        mensaje = "El billete fue creado Correctamente";
    } catch (Exception e) {
        mensaje = "Alto! error al crear el Billete. " + e.getMessage();
        System.out.println(e.getMessage());
    }
    return mensaje;
}
public String modificarBillete(Connection conn, Billete billete){
    PreparedStatement ps = null;
     String sql = "UPDATE BILLETE SET FECHA=?, HORA=?, ITINERARIO=?, NUMERO_BILLETE=?, ID_CLIENTE=?, ID_COMPAÑIA=? "
               + "WHERE ID_BILLETE=?";
    try {
        ps = conn.prepareStatement(sql);
        ps.setString(1, billete.getFecha());
        ps.setString(2, billete.getHora());
        ps.setString(3, billete.getItinerario());
        ps.setInt(4, billete.getNumero_billete());
        ps.setInt(5, billete.getId_cliente());
        ps.setInt(6, billete.getId_compañia());
        ps.setInt(7, billete.getId_billete());
        ps.execute();
        ps.close();
        mensaje = "El billete fue actualizado correctamente";
    } catch (Exception e) {
        mensaje = "Alto! error al actualizar El Billete";
        System.out.println(e.getMessage());
    }
    return mensaje;
}
public void listarBillete(Connection conn, JTable table){
    DefaultTableModel model;
    Statement statement = null;
    ResultSet resultSet = null;
    String[] columnas = {"ID", "FECHA", "HORA", "ITINERARIO", "NUMERO_BILLETE", "ID_CLIENTE", "ID_COMPAÑIA"};
    model = new DefaultTableModel(null, columnas);
    String sql = "SELECT * FROM BILLETE";
    String [] datosTP = new String[7];
    try {
        statement = conn.createStatement();
        resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            Billete td = new Billete();
            td.setId_billete(resultSet.getInt("ID_BILLETE"));
            td.setFecha(resultSet.getString("FECHA"));
            td.setHora(resultSet.getString("HORA"));
            td.setItinerario(resultSet.getString("ITINERARIO"));
            td.setNumero_billete(resultSet.getInt("NUMERO_BILLETE"));
            td.setId_cliente(resultSet.getInt("ID_CLIENTE"));
            td.setId_compañia(resultSet.getInt("ID_COMPAÑIA"));
            
            datosTP[0] = td.getId_billete()+"";
            datosTP[1] = td.getFecha()+"";
            datosTP[2] = td.getHora()+"";
            datosTP[3] = td.getItinerario()+"";
            datosTP[4] = td.getNumero_billete()+"";
            datosTP[5] = td.getId_cliente()+"";
            datosTP[6] = td.getId_compañia()+"";
            model.addRow(datosTP);
        }
       table.setModel(model);
    } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, "Erro:" +e.getMessage());
           System.err.println(e.getMessage());
    }
    
}

public ArrayList<Billete> listarBilleteCombo(Connection conn){
    ArrayList<Billete> listaBillete = new ArrayList<>();
    Statement statement = null;
    ResultSet resultSet = null;
    String sql = "SELECT ID_BILLETE, HORA FROM BILLETE " + "ORDEN BY HORA";
    try {
        statement = conn.createStatement();
        resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            Billete td = new Billete();
            td.setId_billete(resultSet.getInt("ID_BILLETE"));
            td.setFecha(resultSet.getString("FECHA"));
            listaBillete.add(td); 
        }
        
    } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
         System.out.println(e.getMessage());
    }
    return listaBillete;
    
}

   
}

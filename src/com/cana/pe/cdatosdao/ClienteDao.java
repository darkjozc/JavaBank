
package com.cana.pe.cdatosdao;

import com.cana.pe.cmodelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




public class ClienteDao {
    private String mensaje;
 
public String agregarCliente(Connection conn, Cliente cliente) {
    PreparedStatement ps = null;
    String sql ="INSERT INTO CLIENTE(DNI,NOMBRE,TELEFENO,DIRECCION)" + "VALUES(?,?,?,?)";
    
    try {
        ps = conn.prepareStatement(sql);
        ps.setString(1, cliente.getDNI());
        ps.setString(2, cliente.getNombre());
        ps.setString(3, cliente.getTelefeno());
        ps.setString(4, cliente.getDireccion());
        ps.execute();
        ps.close();
        mensaje ="El Cliente fue creado correctamente";
    } catch (Exception e) {
        mensaje ="Alto Perro!!! error al crear al cliente " + e.getMessage();
        System.out.println(e.getMessage());
    }
    return mensaje;
}   

public String eliminarCliente(Connection conn, Cliente cliente){
    PreparedStatement ps = null;
    String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE = ?";
    try {
        ps = conn.prepareStatement(sql);
        ps.setInt(1, cliente.getId_cliente());
        ps.execute();
        ps.close();
        mensaje = "El cliente fue eliminado corectamente";
    } catch (Exception e) {
        mensaje = "Alto! error al elimiminar el cliente. " + e.getMessage();
        System.out.println(e.getMessage());
    }
    return mensaje;
}
public String modificarCliente(Connection conn, Cliente cliente){
    PreparedStatement ps = null;
    String sql = "UPDATE CLIENTE " 
            + "SET DNI=?, NOMBRE=?, TELEFENO=?, DIRECCION=? "
            + "WHERE ID_CLIENTE=?";
    try {
        ps = conn.prepareStatement(sql);
        ps.setString(1, cliente.getDNI());
        ps.setString(2, cliente.getNombre());
        ps.setString(3, cliente.getTelefeno());
        ps.setString(4, cliente.getDireccion());
        ps.setInt(5, cliente.getId_cliente());
        ps.execute();
        ps.close();
        mensaje = "El cliente fue actualizado correctamente";
    } catch (Exception e) {
        mensaje ="Alto! error al actualizar el cliente" + e.getMessage();
        System.out.println(e.getMessage());
    }
    return mensaje;
}
public void listarCliente(Connection conn, JTable table){
    DefaultTableModel model;
    Statement statement = null;
    ResultSet resultSet = null;
    
    String [] columnas = {"ID","DNI", "NOMBRE", "TELEFENO", "DIRECCION"};
    model = new DefaultTableModel(null,columnas);
    
    String sql = "SELECT * FROM CLIENTE";
    
    String [] datosTP = new String[5];
    
    try {
        statement = conn.createStatement();
        resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            Cliente td = new Cliente();
            td.setId_cliente(resultSet.getInt("ID_CLIENTE"));
            td.setDNI(resultSet.getString("DNI"));
            td.setNombre(resultSet.getString("NOMBRE"));
            td.setTelefeno(resultSet.getString("TELEFENO"));
            td.setDireccion(resultSet.getString("DIRECCION"));
            
            datosTP[0] = td.getId_cliente()+"";
            datosTP[1] = td.getDNI()+"";
            datosTP[2] = td.getNombre()+"";
            datosTP[3] = td.getTelefeno()+"";
            datosTP[4] = td.getDireccion()+"";
            
            model.addRow(datosTP);  
        }
        table.setModel(model);
   } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, "Erro:" +e.getMessage());
           System.err.println(e.getMessage());
    }
}
}

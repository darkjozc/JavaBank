
package com.cana.pe.cnegocio;

import com.cana.pe.cdatosdao.ClienteDao;
import com.cana.pe.cmodelo.Cliente;
import com.cana.pe.db.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;


public class ClienteBO {
    public String mensaje;
    ClienteDao cld = new ClienteDao();
    
public String agregarCliente(Cliente cliente) throws SQLException{
    Connection c = Conexion.getConnection();
    
    try {
        mensaje = cld.agregarCliente(c, cliente);
        c.commit();
    } catch (Exception e) {
        c.rollback();
    } finally{
        c.close();
    }
    return mensaje; 
}
public String eliminarCliente (Cliente cliente) throws SQLException{
    Connection c =  Conexion.getConnection();
    try {
        mensaje = cld.eliminarCliente(c, cliente);
        c.commit();
    } catch (Exception e) {
        c.rollback();
    } finally{
        c.close();
    }
    return mensaje; 
}
public String modificarCliente(Cliente cliente) throws SQLException{
    Connection c = Conexion.getConnection();
    try {
        mensaje = cld.modificarCliente(c, cliente);
        c.commit();
    } catch (Exception e) {
        c.rollback();
    } finally{
        c.close();
      }
    return mensaje;
}      
public void listarCliente(JTable table) throws SQLException{
    Connection c = Conexion.getConnection();
    try {
        cld.listarCliente(c, table);   
    } catch (Exception e) {
        System.err.println("Error: "+e.getMessage());
    } finally {
        c.close();
    }
}
  
}

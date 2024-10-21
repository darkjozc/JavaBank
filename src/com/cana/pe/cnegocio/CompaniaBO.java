
package com.cana.pe.cnegocio;

import com.cana.pe.cdatosdao.CompaniaDao;
import com.cana.pe.cmodelo.Compania;
import com.cana.pe.db.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;


public class CompaniaBO {
    public String mensaje;
    CompaniaDao cld = new CompaniaDao();
    
public String agregarCompania(Compania compania) throws SQLException{
    Connection c = Conexion.getConnection();
    try {
        mensaje = cld.agregarCompania(c, compania);
        c.commit();
    } catch (Exception e) {
        c.rollback();
    } finally {
        c.close();
    }
    return mensaje;
    
}
public String elminarCompania(Compania compania) throws SQLException{
         Connection c = Conexion.getConnection();
         try {
         mensaje = cld.elminarCompania(c, compania);
         c.commit();
    } catch (Exception e) {
        c.rollback();
    } finally {
        c.close();
    }
      return mensaje;
}
public String modificarCompania(Compania compania) throws SQLException{
    Connection c = Conexion.getConnection();
    try {
        mensaje = cld.modificarCompania(c, compania);
        c.commit();
    } catch (Exception e) {
        c.rollback();
    } finally {
        c.close();
    }
    return mensaje;
    
}
public void listarCompania(JTable table) throws SQLException{
    Connection c = Conexion.getConnection();
    try {
        cld.listarCompania(c, table);
    } catch (Exception e) {
        System.err.println("Error: "+e.getMessage());
    } finally {
        c.close();
    }
}
       
}

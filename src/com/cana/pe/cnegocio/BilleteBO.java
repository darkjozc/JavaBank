
package com.cana.pe.cnegocio;

import com.cana.pe.cdatosdao.BilleteDao;
import com.cana.pe.cmodelo.Billete;
import com.cana.pe.db.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;




public class BilleteBO {
     public String mensaje;
    BilleteDao cld = new BilleteDao();

public String agregarBillete(Billete billete) throws SQLException{
        Connection c = Conexion.getConnection();
    try {
        mensaje = cld.agregarBillete(c, billete);
        c.commit();
    }catch (Exception e){
        c.rollback();
    } finally {
        c.close();
    }
    return mensaje;
}
public String eliminarBillete(Billete billete) throws SQLException{
    Connection c = Conexion.getConnection();
    try {
        mensaje = cld.elminarBillete(c, billete);
        c.commit();
    } catch (Exception e) {
        c.rollback();
    } finally {
        c.close();
    }
    return mensaje;
}
public String modificarBillete (Billete billete) throws SQLException{
    Connection c = Conexion.getConnection();
    try {
        mensaje = cld.modificarBillete(c, billete);
        c.commit();
    } catch (Exception e) {
        c.rollback();
    } finally {
        c.close();
    }
    return mensaje;
}
public void listarBillete(JTable table) throws SQLException{
    Connection c = Conexion.getConnection(); 
    try {
        cld.listarBillete(c, table);
    } catch (Exception e) {
        System.err.println("Error: "+e.getMessage());
    } finally {
          c.close();
    }
}
public ArrayList<Billete>listarBilleteCombo(){
    ArrayList<Billete>listaBillete = new ArrayList<>();
    Connection c = Conexion.getConnection();
    listaBillete = cld.listarBilleteCombo(c);
    try {
        c.close();
    } catch (Exception e) {
        System.out.println("Error:" + e.getMessage());
    }
    return listaBillete;
    
}
}

package com.cana.pe.ctest;

import com.cana.pe.cmodelo.Cliente;
import com.cana.pe.cnegocio.ClienteBO;
import java.sql.SQLException;
import java.text.ParseException;


public class Test {
    ClienteBO clbo = new ClienteBO();
    Cliente cl = new Cliente();
    
public void  insertar() throws SQLException, ParseException{
    
    cl.setDNI("12315");
    cl.setNombre("juafgn");
    cl.setTelefeno("123");
    cl.setDireccion("asdsa");
    
    clbo.agregarCliente(cl);
    
   
    
}
 public static void main(String[] args) throws SQLException, ParseException {
        Test t = new  Test();
        t.insertar();
        //t.eliminar();
        //t.modificar();
    }   
    
}

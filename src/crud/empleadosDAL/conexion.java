
package crud.empleadosDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class conexion {
    String strConexionDB="jdbc:sqlite:C:/Users/Usuario/Downloads/sqliteadmin/db/sistema.s3db";
    Connection conn= null;
    
    public conexion(){
        try {
           Class.forName("org.sqlite.JDBC");
           conn=DriverManager.getConnection(strConexionDB);
            System.out.println("conexion establecida");
        } catch (Exception e) {
            System.out.println("error de conexion" +e);
        }
        }
        public int ejecutarSentenciaSQL(String strSetenciaSQL){
            try{
                PreparedStatement pstm = conn.prepareStatement(strSetenciaSQL);
                pstm.execute();
                return 1;
                
            } catch(SQLException e){
                    System.out.println(e);
                    return 0;
            }
        }
        public ResultSet consultarRegistros(String strSentenciaSQL){
            try {
                  PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
                  ResultSet respuesta= pstm.executeQuery();
                  return respuesta;
                  
                  
                  
            } catch (Exception e) {
                System.out.println(e);
                return null;
            }
        }
        
        
        
    }
    


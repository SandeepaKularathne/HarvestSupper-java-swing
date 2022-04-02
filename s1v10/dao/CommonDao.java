package dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CommonDao{ 

    public static ResultSet get(String qry){ 
        
        ResultSet rslt = null;

        try{

            Connection dbcon = DriverManager.getConnection( "jdbc:mysql://localhost/harvest","us2","1234");
            Statement stm = dbcon.createStatement();

            rslt = stm.executeQuery(qry);
        }

        catch(SQLException e){ 

            System.out.println("Can't Connect as : "+ e.getMessage());
        }


        return rslt;
    }

    public static String insert(String qry){ 

        String msg = "0";

        try{

            Connection dbcon = DriverManager.getConnection( "jdbc:mysql://localhost/harvest","us2","1234");
            Statement stm = dbcon.createStatement();

            int rows = stm.executeUpdate(qry);
            if(rows!=0) msg="1";
        }

        catch(SQLException e){ 

            System.out.println("Database Error as : "+ e.getMessage());
            msg = "Database Error";
        }


        return msg;
    }
}
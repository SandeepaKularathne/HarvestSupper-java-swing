import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusEmployeeDao{ 

    public static StatusEmployee getById(int id){ 

        StatusEmployee statusEmployee = new StatusEmployee();

        try{ 

            String qry = "select * from statusEmployee where id="+id;
            ResultSet rslt = CommonDao.get(qry);

            rslt.next(); 

                statusEmployee.setId(rslt.getInt(1));
                statusEmployee.setName(rslt.getObject(2).toString() );

        }

        catch(SQLException e){ 

            System.out.println("Can't Connect as : "+ e.getMessage());
        }


            return statusEmployee;

    }
}
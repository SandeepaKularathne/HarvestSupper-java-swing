import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

public class StatusItemDao {

    public static StatusItem getById(int id) {

        StatusItem statusitem = new StatusItem();

        try {

            String qry = "select * from statusitem where id=" + id;
            ResultSet rslt = CommonDao.get(qry);

            rslt.next();
                statusitem.setId(rslt.getInt(1));
                statusitem.setName(rslt.getObject(2).toString()); 

        } 
        
        catch (SQLException e) {
            System.out.println("Can't Get Results as : " + e.getMessage());
        }

        return statusitem;

    }

    public static List<StatusItem> getAll(){ 

        List<StatusItem> statusitems = new ArrayList();

        try{ 

            String qry = "select * from statusitem";
            ResultSet rslt = CommonDao.get(qry);

                while(rslt.next()){ 

                    StatusItem statusitem = new StatusItem();

                    statusitem.setId(rslt.getInt("id"));
                    statusitem.setName(rslt.getObject("name").toString() );
                    
                    statusitems.add(statusitem);
                }
        }

        catch(SQLException e){ 

            System.out.println("Can't Connect as : "+ e.getMessage());
        }

            return statusitems;

    }

}



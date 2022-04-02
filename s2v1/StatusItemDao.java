import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusItemDao {

    public static StatusItem getById(int id) {

        StatusItem statusitem = new StatusItem();

        try {
            String qry = "select * from statusitem where id=" + id;
            ResultSet rslt = CommonDao.get(qry);
            rslt.next();
            statusitem.setId(rslt.getInt("id"));
            statusitem.setName(rslt.getObject("name").toString());

        } catch (SQLException e) {
            System.out.println("Can't Get Results as : " + e.getMessage());
        }

        return statusitem;

    }

}



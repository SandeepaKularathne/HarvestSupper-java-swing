import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusemployeeDao {

    public static Statusemployee getById(int id) {

        Statusemployee statusemployee = new Statusemployee();

        try {
            String qry = "select * from statusemployee where id=" + id;
            ResultSet rslt = CommonDao.get(qry);
            rslt.next();
            statusemployee.setId(rslt.getInt("id"));
            statusemployee.setName(rslt.getObject("name").toString());

        } catch (SQLException e) {
            System.out.println("Can't Get Results as : " + e.getMessage());
        }

        return statusemployee;

    }

}



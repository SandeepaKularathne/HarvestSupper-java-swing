import java.sql.ResultSet;
import java.sql.SQLException;

public class DesignationDao {

    public static Designation getById(int id) {

        Designation designation = new Designation();

        try {
            String qry = "select * from designation where id=" + id;
            ResultSet rslt = CommonDao.get(qry);
            rslt.next();
            designation.setId(rslt.getInt("id"));
            designation.setName(rslt.getObject("name").toString());

        } catch (SQLException e) {
            System.out.println("Can't Get Results as : " + e.getMessage());
        }

        return designation;

    }

}
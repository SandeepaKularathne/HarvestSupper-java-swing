import java.sql.ResultSet;
import java.sql.SQLException;

public class GenderDao {

    public static Gender getById(int id) {

        Gender gender = new Gender();

        try {
            String qry = "select * from gender where id=" + id;
            ResultSet rslt = CommonDao.get(qry);
            rslt.next();
            gender.setId(rslt.getInt("id"));
            gender.setName(rslt.getObject("name").toString());

        } catch (SQLException e) {
            System.out.println("Can't Get Results as : " + e.getMessage());
        }

        return gender;

    }

}
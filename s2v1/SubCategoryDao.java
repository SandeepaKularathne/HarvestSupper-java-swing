import java.sql.ResultSet;
import java.sql.SQLException;

public class SubCategoryDao {

    public static SubCategory getById(int id) {

        SubCategory subcategory = new SubCategory();

        try {
            String qry = "select * from subcategory where id=" + id;
            ResultSet rslt = CommonDao.get(qry);
            rslt.next();
            subcategory.setId(rslt.getInt("id"));
            subcategory.setName(rslt.getObject("name").toString());

        } catch (SQLException e) {
            System.out.println("Can't Get Results as : " + e.getMessage());
        }

        return subcategory;

    }

}
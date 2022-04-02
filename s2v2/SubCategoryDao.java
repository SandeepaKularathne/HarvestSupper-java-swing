import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

public class SubCategoryDao {

    public static SubCategory getById(int id) {

        SubCategory subcategory = new SubCategory();

        try {
            String qry = "select * from subcategory where id="+id;
            ResultSet rslt = CommonDao.get(qry);
            rslt.next();
            subcategory.setId(rslt.getInt(1));
            subcategory.setName(rslt.getObject(2).toString());

        } catch (SQLException e) {
            System.out.println("Can't Get Results as : " + e.getMessage());
        }

        return subcategory;

    }

    public static List<SubCategory> getAll() {

        List<SubCategory> subcategorys = new ArrayList();

        try {
            String qry = "select * from subcategory";
            ResultSet rslt = CommonDao.get(qry);

            while (rslt.next()) {

                SubCategory subcategory = new SubCategory();

                subcategory.setId(rslt.getInt("id"));
                subcategory.setName(rslt.getObject("name").toString());
                
                subcategorys.add(subcategory);
            }

        } catch (SQLException e) {
            System.out.println("Can't Get Results as : " + e.getMessage());
        }

        return subcategorys;

    }
    
}
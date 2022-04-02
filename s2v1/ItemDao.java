import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class ItemDao {

    public static List<Item> getAll() {

        List<Item> items = new ArrayList();

        try {
            String qry = "select * from item";
            ResultSet rslt = CommonDao.get(qry);

            while (rslt.next()) {

                Item item = new Item();

                item.setId(rslt.getInt("id"));
                item.setBrand( BrandDao.getById( rslt.getInt("brand_id") ) );
                item.setSubCategory( SubCategoryDao.getById( rslt.getInt("subcategory_id") ) );
                item.setName(rslt.getObject("name").toString());
                item.setCode(rslt.getObject("code").toString());

                item.setPricePurchase(rslt.getDouble("pricepurchase"));
                item.setPriceSale(rslt.getDouble("pricesale"));
                item.setQoh(rslt.getInt("qoh"));
                item.setRop(rslt.getInt("rop"));
                item.setStatusItem( StatusItemDao.getById( rslt.getInt("statusitem_id") ) ); 
                item.setDoIntroduced(LocalDate.parse(rslt.getObject("dointroduced").toString()));

                items.add(item);
            }

        } catch (SQLException e) {
            System.out.println("Can't Get Results as : " + e.getMessage());
        }

        return items;
    }

}




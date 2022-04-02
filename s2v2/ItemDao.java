import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;

import java.util.List;
import java.util.ArrayList;

public class ItemDao {

    public static List<Item> get(String qry) {

        List<Item> items = new ArrayList();

        try {

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



    public static List<Item> getAll(){ 

        String qry = "select * from item";
        List<Item> items = get(qry);
        return items;

    } 

    public static List<Item> getAllByName(String name){ 

        String qry = "select * from item where name like '"+name+"%'";
        List<Item> items = get(qry);
        return items;

    } 

    public static List<Item> getAllByBrand(Brand brand){ 

        String qry = "select * from employee where brand_id = "+ brand.getId() +"";
        List<Item> items = get(qry);
        return items;

    }

    public static List<Item> getAllBySubcategory(SubCategory subcategory){ 

        String qry = "select * from employee where subcategory_id = "+ subcategory.getId() +"";
        List<Item> items = get(qry);
        return items;

    }

    public static List<Item> getAllByNameAndBrandAndSubCategory(String name , Brand brand, SubCategory subcategory){ 

        String qry = "select * from item where name like '"+name+"%' and brand_id = "+brand.getId()+" and subcategory_id = "+subcategory.getId() +";";
        List<Item> items = get(qry);
        return items;

    }

}
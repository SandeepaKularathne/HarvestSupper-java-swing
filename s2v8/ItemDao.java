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
                    item.setQOH(rslt.getInt("qoh"));
                    item.setROP(rslt.getInt("rop"));
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
        
        String qry = "select * from item where brand_id = "+ brand.getId() +";";
        List<Item> items = get(qry);
        return items;

    }

    public static List<Item> getAllBySubcategory(SubCategory subcategory){ 

        String qry = "select * from item where subcategory_id = "+ subcategory.getId() +";";
        List<Item> items = get(qry);
        return items;

    }

    public  static List<Item> getAllByNameAndBrand(String name,Brand brand){
        
        String qry = "select * from item where name like '"+name+"%' and brand_id = "+brand.getId()+";";
        List<Item> items =  get(qry);
        return items;

    }

    public  static List<Item> getAllBySubCategoryAndBrand(SubCategory subCategory,Brand brand){
        
        String qry = "select * from item where brand_id = "+brand.getId()+" and subcategory_id = "+subCategory.getId()+";";
        List<Item> items =  get(qry);
        return items;

    }

    public  static List<Item> getAllByNameAndSubCategory(String name,SubCategory subCategory){
        
        String qry = "select * from item where name like '"+name+"%' and subcategory_id = "+subCategory.getId()+";";
        List<Item> items =  get(qry);
        return items;

    }

    public static List<Item> getAllByNameAndBrandAndSubCategory(String name , Brand brand, SubCategory subcategory){ 

        String qry = "select * from item where name like '"+name+"%' and brand_id = "+brand.getId()+" and subcategory_id = "+subcategory.getId() +";";
        List<Item> items = get(qry);
        return items;

    }

    public  static Item getByCode(String code){
        Item item =null;
        
        String qry = "select * from item where code ='"+code+"'";
        try{
            ResultSet rslt = CommonDao.get(qry); 
            if(rslt!=null && rslt.next()){
    
                item.setId(rslt.getInt("id"));
                item.setBrand( BrandDao.getById( rslt.getInt("brand_id") ) );
                item.setSubCategory( SubCategoryDao.getById( rslt.getInt("subcategory_id") ) );
                item.setName(rslt.getObject("name").toString());
                item.setCode(rslt.getObject("code").toString());

                item.setPricePurchase(rslt.getDouble("pricepurchase"));
                item.setPriceSale(rslt.getDouble("pricesale"));
                item.setQOH(rslt.getInt("qoh"));
                item.setROP(rslt.getInt("rop"));
                item.setStatusItem( StatusItemDao.getById( rslt.getInt("statusitem_id") ) ); 
                item.setDoIntroduced(LocalDate.parse(rslt.getObject("dointroduced").toString()));

            }
    
        }catch(SQLException e1){
            System.out.println("Can't Connect as : " + e1.getMessage());
        }
    
        return item;
    }
    
    public static String save(Item item){
        
        String msg="0";
    
        String sql ="insert into item(brand_id,subcategory_id,name,code,pricepurchase,pricesale,qoh,rop,statusitem_id,dointroduced) Values("+
            item.getBrand().getId()+","+
            item.getSubCategory().getId()+",'"+
            item.getName()+"',"+
            item.getCode()+","+

            item.getPricePurchase()+","+
            item.getPriceSale()+","+
            item.getQOH()+","+
            item.getROP()+","+
            item.getStatusItem().getId()+",'"+
            item.getDoIntroduced().toString()+"')";

        msg = CommonDao.insert(sql);
        
        return msg;
    }

    public static String update(Item item){ 
        
        String msg = "0";

        String sql = "UPDATE item Set brand_id='"+
                    item.getBrand().getId()+"',  subcategory_id='"+
                    item.getSubCategory().getId()+"', name='"+
                    item.getName()+"', code='"+
                    item.getCode()+"', pricepurchase='"+
                    item.getPricePurchase()+"', pricesale='"+
                    item.getPriceSale()+"', qoh='"+
                    item.getQOH()+"', rop='"+
                    item.getROP()+"', statusitem_id='"+
                    item.getStatusItem().getId()+"', dointroduced='"+
                    item.getDoIntroduced().toString()+"' WHERE id="+item.getId();
                    
        msg = CommonDao.insert(sql);
        
        return msg;
   
    }

    public static String delete(Item item){ 
        
        String msg = "0";

        String sql = "delete from harvest.item where id="+item.getId();
        msg = CommonDao.insert(sql);
        
        return msg;

    }

}
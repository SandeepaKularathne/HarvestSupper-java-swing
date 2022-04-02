import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class ItemController {

    public static List<Item> get(Hashtable<String , Object> ht) {

        List<Item> items = new ArrayList<>(); 

        if(ht==null){ items = ItemDao.getAll(); } 
        else{ 

            String name = (String) ht.get("name");
            Brand brand = (Brand) ht.get("brand");
            SubCategory subcategory = (SubCategory) ht.get("subcategory");

            if(name==null)
                items = ItemDao.getAllByName(name);
            else if (brand==null)
                items = ItemDao.getAllByBrand(brand);
            else if (subcategory==null)
                items = ItemDao.getAllBySubcategory(subcategory);
            else
                items = ItemDao.getAllByNameAndBrandAndSubCategory(name, brand, subcategory);

        }   
        return items;

    }

    public static String post(Item item){
    
        String msg ="";
        String err ="";
        
        Item iteCode =ItemDao.getByCode(item.getCode());
    
        if(iteCode!=null) err =err +"\nCode Exists";
    
        if(err.isEmpty()){
    
            String dberr = ItemDao.save(item);
            if(dberr.equals("1"))
            msg ="1";
            else            
            msg ="DB error as: "+ dberr;
    
        }else{
            msg= "Data Errors: \n" + err;
        }
        return msg;
    } 

    public static String put(Item item){ 

        String msg = "";
        String err= ""; 

        //Item iteCode =ItemDao.getByCode(item.getCode());
        //if(iteCode!=null && iteCode.getId() != item.getId() ) err = err + "\nCode Exists";
        
        if(err.isEmpty()){ 
            String dberr = ItemDao.update(item);
            if(dberr.equals("1"))
            msg="1";
            else
            msg="DB error as : " + dberr;
        }
        else{ 
            msg = "Validation Errors : \n" + err;
        }
        return msg;
    }

    public static String delete(Item item){ 

        String msg = "";
        
            String dberr = ItemDao.delete(item);
            if(dberr.equals("1"))
            msg="1";
            else
            msg="DB error as : " + dberr;
        
        return msg;
    }

}


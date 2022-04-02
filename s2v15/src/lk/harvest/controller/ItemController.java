package lk.harvest.controller;

import lk.harvest.entity.Item;
import lk.harvest.entity.Brand;
import lk.harvest.entity.StatusItem;
import lk.harvest.entity.SubCategory;

import lk.harvest.dao.ItemDao;

import java.util.Hashtable;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class ItemController {

    public static List<Item> get(HashMap<String , Object> ht) {

        List<Item> items = new ArrayList<>(); 

        if(ht==null){ items = ItemDao.getAll(); } 
        else{ 

            String name = (String) ht.get("name");
            Brand brand = (Brand) ht.get("brand");
            SubCategory subcategory = (SubCategory) ht.get("subcategory");


            if(name == null && subcategory == null && brand == null )
                items = ItemDao.getAll();

            if(name != null && subcategory == null && brand == null )
                items = ItemDao.getAllByName(name);
            
            if(name == null && subcategory != null && brand == null )
                items = ItemDao.getAllBySubcategory(subcategory);
                
            if(name == null && subcategory == null && brand != null ){
                items = ItemDao.getAllByBrand(brand);
            }
                
            if (name != null  && subcategory == null && brand != null)
                items = ItemDao.getAllByNameAndBrand(name, brand);
                
            if (name == null  && subcategory != null && brand != null)
                items = ItemDao.getAllBySubCategoryAndBrand(subcategory, brand);

            if (name != null  && subcategory != null && brand == null)
                items = ItemDao.getAllByNameAndSubCategory(name, subcategory);
        }   
        return items;

    }

    public static String post(Item item){
    
        String msg ="";
        String err ="";
    
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


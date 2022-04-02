import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;

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

}


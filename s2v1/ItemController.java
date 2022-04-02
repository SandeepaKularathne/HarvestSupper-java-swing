import java.util.List;

public class ItemController {

    public static List<Item> get() {

        List<Item> items = null; 

        items = ItemDao.getAll();
        // If ItemDao.getAll() failed to give Item List 
        // Controller will try to get them from another source such as Calling Web Service....

        return items;

    }

}


import java.util.List;

public class SubCategoryController {

    public static List<SubCategory> get() {

        List<SubCategory> subcategorys = SubCategoryDao.getAll();
        // If SubCategoryDao.getAll() failed to give SubCategory List 
        // Controller will try to get them from another source such as Calling Web Service....

        return subcategorys;

    }

}


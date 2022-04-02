import java.util.List;

public class BrandController {

    public static List<Brand> get() {

        List<Brand> brands = BrandDao.getAll();
        // If BrandDao.getAll() failed to give Brand List 
        // Controller will try to get them from another source such as Calling Web Service....

        return brands;

    }

}


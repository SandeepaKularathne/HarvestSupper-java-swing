package controller;

import entity.Brand;
import dao.BrandDao;

import java.util.List;

public class BrandController {

    public static List<Brand> get() {

        List<Brand> brands = BrandDao.getAll();
       return brands;

    }

}


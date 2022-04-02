package lk.harvest.controller;

import lk.harvest.entity.Brand;
import lk.harvest.dao.BrandDao;

import java.util.List;

public class BrandController {

    public static List<Brand> get() {

        List<Brand> brands = BrandDao.getAll();
       return brands;

    }

}


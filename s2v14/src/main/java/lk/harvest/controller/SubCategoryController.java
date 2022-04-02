package lk.harvest.controller;

import lk.harvest.entity.SubCategory;
import lk.harvest.dao.SubCategoryDao;

import java.util.List;

public class SubCategoryController {

    public static List<SubCategory> get() {

        List<SubCategory> subcategorys = SubCategoryDao.getAll();
        return subcategorys;

    }

}


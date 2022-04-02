package lk.harvest.controller;

import lk.harvest.entity.Designation;
import lk.harvest.dao.DesignationDao;

import java.util.List;

    public class DesignationController{ 

        public static List<Designation> get(){ 

            List<Designation> designations = DesignationDao.getAll();
            return designations;

        }
}
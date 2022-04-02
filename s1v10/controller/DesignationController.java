package controller;

import entity.Designation;
import dao.DesignationDao;

import java.util.List;

    public class DesignationController{ 

        public static List<Designation> get(){ 

            List<Designation> designations = DesignationDao.getAll();
            return designations;

        }
}
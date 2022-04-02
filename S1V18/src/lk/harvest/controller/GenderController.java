package lk.harvest.controller;

import lk.harvest.entity.Gender;
import lk.harvest.dao.GenderDao;

import java.util.List;


/*
    public class EmployeeController{ 

        public static List<Employee> get(){ 

            List<Employee> employees = EmployeeDao.getAll();
            return employees;


    } */

    public class GenderController{ 

        public static List<Gender> get(){ 

            List<Gender> genders = GenderDao.getAll();
            return genders;

        }
}
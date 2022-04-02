package controller;

import entity.StatusEmployee;
import dao.StatusEmployeeDao;

import java.util.List;

    public class StatusEmployeeController{ 

        public static List<StatusEmployee> get(){ 

            List<StatusEmployee> statusEmployees = StatusEmployeeDao.getAll();
            return statusEmployees;

        }
}
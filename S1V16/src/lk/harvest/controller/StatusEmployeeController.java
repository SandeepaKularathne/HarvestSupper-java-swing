package lk.harvest.controller;

import lk.harvest.entity.StatusEmployee;
import lk.harvest.dao.StatusEmployeeDao;

import java.util.List;

    public class StatusEmployeeController{ 

        public static List<StatusEmployee> get(){ 

            List<StatusEmployee> statusEmployees = StatusEmployeeDao.getAll();
            return statusEmployees;

        }
}
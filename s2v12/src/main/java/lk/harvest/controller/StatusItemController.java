package lk.harvest.controller;

import lk.harvest.entity.StatusItem;
import lk.harvest.dao.StatusItemDao;

import java.util.List;

public class StatusItemController {

    public static List<StatusItem> get() {

        List<StatusItem> statusitems = StatusItemDao.getAll();
        return statusitems;

    }

}


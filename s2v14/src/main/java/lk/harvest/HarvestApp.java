package lk.harvest;

import lk.harvest.ui.ItemUi;
import javax.swing.JFrame;

public class HarvestApp {

    public static void main(String[] args) {

        ItemUi iteMgr = new ItemUi();
        iteMgr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iteMgr.setVisible(true);

    }

}
package lk.harvest;

import lk.harvest.ui.EmployeeUi;

import javax.swing.JFrame;

/**
 * @author sandeepa
 * This is the main entry for harvest supper Aplication
 */
public class HarvestApp{

    public static void main(String[] args) {
        
        EmployeeUi empMgr = new EmployeeUi();
        empMgr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        empMgr.setVisible(true);
    }
    
}
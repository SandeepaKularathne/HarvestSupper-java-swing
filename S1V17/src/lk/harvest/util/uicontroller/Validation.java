package lk.harvest.util.uicontroller;

import com.toedter.calendar.JDateChooser;
import lk.harvest.entity.Designation;
import lk.harvest.entity.Employee;
import lk.harvest.entity.Gender;
import lk.harvest.entity.StatusEmployee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Hashtable;

public class Validation {
    private static Color valid = new Color(200,255,200);
    private static Color invalid = Color.pink;
    private static Color initial = Color.white;
    private static Color updated = Color.YELLOW;

    public static void txtNameKR(KeyEvent e, Employee oldEmployee, Employee employee, JTextField txtName, Hashtable<String,String> rgxname){
        String name = txtName.getText();
        if( name.matches(rgxname.get("name"))){
            employee.setName(name);
            txtName.setBackground(valid);
            if(oldEmployee!=null && !name.equals(oldEmployee.getName()))
                txtName.setBackground(updated);
        }else{
            employee.setName(null);
            txtName.setBackground(invalid);
            if (name.length() == 0){txtName.setBackground(initial); }
        }
    }

    public static void txtNicKR(KeyEvent e, Employee oldEmployee, Employee employee, JTextField txtNic,Hashtable<String,String> rgxname){
        String nic = txtNic.getText().toUpperCase();
        if( nic.matches(rgxname.get("nic"))){
            employee.setNic(nic);
            txtNic.setBackground(valid);
            if(oldEmployee!=null && !nic.equals(oldEmployee.getNic()))
                txtNic.setBackground(updated);
        }else{
            employee.setNic(null);
            txtNic.setBackground(invalid);
            if (nic.length() == 0){txtNic.setBackground(initial); }
        }
    }

    public static void txtEmailKR(KeyEvent e, Employee oldEmployee, Employee employee, JTextField txtEmail ,Hashtable<String,String> rgxname){
        String email = txtEmail.getText();
        if( email.matches(rgxname.get("email"))){
            employee.setEmail(email);
            txtEmail.setBackground(valid);
            if(oldEmployee!=null && !email.equals(oldEmployee.getEmail()))
                txtEmail.setBackground(updated);
        }else{
            employee.setEmail(null);
            txtEmail.setBackground(invalid);
            if (email.length() == 0){txtEmail.setBackground(initial); }
        }
    }

    public static void txtMobileKR(KeyEvent e, Employee oldEmployee, Employee employee, JTextField txtMobile,Hashtable<String,String> rgxname){

        String mobile = txtMobile.getText();
        if(  mobile.matches(rgxname.get("mobile"))){
            employee.setMobile(mobile);
            txtMobile.setBackground(valid);
            if(oldEmployee!=null && !mobile.equals(oldEmployee.getMobile()))
                txtMobile.setBackground(updated);
        }else{
            employee.setMobile(null);
            txtMobile.setBackground(invalid);
            if (mobile.length() == 0){txtMobile.setBackground(initial); }
        }

    }

    public static void cmbGenderAp(ActionEvent e, Employee oldEmployee, Employee employee, JComboBox cmbGender){

        int genindex = cmbGender.getSelectedIndex();
        Gender genders = (Gender) cmbGender.getSelectedItem();
        if( genindex !=0){
            employee.setGender( (Gender)cmbGender.getSelectedItem() );
            cmbGender.setBackground(valid);
            if(oldEmployee!=null && !genders.equals(oldEmployee.getGender()))
                cmbGender.setBackground(updated);
        }else{
            employee.setGender(null);
            cmbGender.setBackground(invalid);
        }
    }

    public static void cmbDesignationAp(ActionEvent e, Employee oldEmployee, Employee employee, JComboBox cmbDesignation){
        int desindex = cmbDesignation.getSelectedIndex();
        Designation designations = (Designation)cmbDesignation.getSelectedItem();
        if( desindex!=0){
            employee.setDesignation( (Designation)cmbDesignation.getSelectedItem() );
            cmbDesignation.setBackground(valid);
            if(oldEmployee!=null && !designations.equals(oldEmployee.getDesignation()))
                    cmbDesignation.setBackground(updated);
        }else{
            employee.setDesignation(null);
            cmbDesignation.setBackground(invalid);
        }
    }

    public static void cmbStatusEmployeeAp(ActionEvent e, Employee oldEmployee, Employee employee, JComboBox cmbStatusEmployee){

        int steindex = cmbStatusEmployee.getSelectedIndex();
        StatusEmployee statusemployees = (StatusEmployee)cmbStatusEmployee.getSelectedItem();
        if( steindex!=0){
            employee.setStatusEmployee( (StatusEmployee)cmbStatusEmployee.getSelectedItem() );
            cmbStatusEmployee.setBackground(valid);
            if(oldEmployee!=null && !statusemployees.equals(oldEmployee.getStatusEmployee()))
                    cmbStatusEmployee.setBackground(updated);
        }else{
            employee.setStatusEmployee(null);
            cmbStatusEmployee.setBackground(invalid);
        }
    }

    public static void dteDobPc(PropertyChangeEvent e, Employee oldEmployee, Employee employee, JDateChooser dteDob){

        java.util.Date dobDate = dteDob.getDate();
        if( dobDate !=null){

            LocalDate dobDate1 = dteDob.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate nowDate = LocalDate.now();
            LocalDate oldDate = nowDate.minusYears(18);
            int comDate = oldDate.compareTo(dobDate1);
            JTextField dtpDisplay=(JTextField)dteDob.getDateEditor().getUiComponent();

            if( comDate >= 0){
                employee.setDob(dobDate1);
                dtpDisplay.setBackground(valid);
                if(oldEmployee!=null && !dobDate1.equals(oldEmployee.getDob()))
                        dtpDisplay.setBackground(updated);
            }else{
                employee.setDob(null);
                dtpDisplay.setBackground(invalid);
            }
        }
    }
}

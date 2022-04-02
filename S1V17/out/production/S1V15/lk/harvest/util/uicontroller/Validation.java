package lk.harvest.util.uicontroller;

import com.toedter.calendar.JDateChooser;
import lk.harvest.entity.Brand;
import lk.harvest.entity.Item;
import lk.harvest.entity.StatusItem;
import lk.harvest.entity.SubCategory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.time.LocalDate;

public class Validation {
    private static Color valid = new Color(200,255,200);
    private static Color invalid = Color.pink;
    private static Color initial = Color.white;
    private static Color updated = Color.YELLOW;

    public static void txtNameKR(KeyEvent e, Item oldItem, Item item, JTextField txtName){

        String name = txtName.getText();
        if( name.matches("^[A-Z][a-z]*$")){
            item.setName(name);
            if(oldItem!=null){
                if(!name.equals(oldItem.getName()))
                    txtName.setBackground(updated);
                else
                    txtName.setBackground(valid);
            }else
                txtName.setBackground(valid);
        }else{
            item.setName(null);
            txtName.setBackground(invalid);
        }

    }

    public static void txtCodeKR(KeyEvent e,Item oldItem, Item item, JTextField txtCode){

        String code = txtCode.getText();
        if(code.matches("^\\d{1,5}$")){
            item.setCode(code);
            if(oldItem!=null){
                if(!code.equals(oldItem.getCode()))
                    txtCode.setBackground(updated);
                else
                    txtCode.setBackground(valid);
            }else
                txtCode.setBackground(valid);
        }else{
            txtCode.setBackground(invalid);
            item.setCode(null);
        }

    }

    public static void txtPricePurchaseKR(KeyEvent e,Item oldItem, Item item, JTextField txtPricePurchase){

        String pricepurchase = txtPricePurchase.getText();
        if(pricepurchase.matches("^\\d{1,6}(.\\d{1})?$|^\\d{1,6}(.\\d{2})?$")){
            item.setPricePurchase(Double.parseDouble(pricepurchase));
            if(oldItem!=null){
                if(Double.parseDouble(pricepurchase)!= oldItem.getPricePurchase())
                    txtPricePurchase.setBackground(updated);
                else
                    txtPricePurchase.setBackground(valid);
            }else
                txtPricePurchase.setBackground(valid);
        }else{
            txtPricePurchase.setBackground(invalid);
            item.setPricePurchase(Double.parseDouble(null));
        }

    }

    public static void txtPriceSaleKR(KeyEvent e,Item oldItem, Item item, JTextField txtPriceSale){

        String pricesale = txtPriceSale.getText();
        if(pricesale.matches("^\\d{1,6}(.\\d{1})?$|^\\d{1,6}(.\\d{2})?$")){
            item.setPriceSale(Double.parseDouble(pricesale));
            if(oldItem!=null){
                if(Double.parseDouble(pricesale)!= oldItem.getPriceSale())
                    txtPriceSale.setBackground(updated);
                else
                    txtPriceSale.setBackground(valid);
            }else
                txtPriceSale.setBackground(valid);
        }else{
            txtPriceSale.setBackground(invalid);
            item.setPriceSale(Double.parseDouble(null));
        }

    }

    public static void txtQOHKR(KeyEvent e,Item oldItem, Item item, JTextField txtQOH){

        String qoh = txtQOH.getText();
        if(qoh.matches("^\\d{1,5}$")){
            item.setQOH(Integer.parseInt(qoh));
            if(oldItem!=null){
                if(Integer.parseInt(qoh) != oldItem.getQOH())
                    txtQOH.setBackground(updated);
                else
                    txtQOH.setBackground(valid);
            }else
                txtQOH.setBackground(valid);
        }else{
            txtQOH.setBackground(invalid);
            item.setQOH(0);
        }

    }

    public static void txtROPKR(KeyEvent e,Item oldItem, Item item, JTextField txtROP){

        String rop = txtROP.getText();
        if(rop .matches("^\\d{1,5}$")){
            item.setROP(Integer.parseInt(rop));
            if(oldItem!=null){
                if(Integer.parseInt(rop) != oldItem.getROP())
                    txtROP.setBackground(updated);
                else
                    txtROP.setBackground(valid);
            }else
                txtROP.setBackground(valid);
        }else{
            txtROP.setBackground(invalid);
            item.setROP(0);
        }

    }

    public static void cmbBrandAp(ActionEvent e,Item oldItem, Item item, JComboBox cmbBrand){

        int brandindex = cmbBrand.getSelectedIndex();
        Brand brands = (Brand) cmbBrand.getSelectedItem();
        if(brandindex != 0){
            item.setBrand((Brand)cmbBrand.getSelectedItem() );
            if(oldItem!=null){
                if(!brands.equals(oldItem.getBrand()))
                    cmbBrand.setBackground(updated);
                else
                    cmbBrand.setBackground(valid);
            }else
                cmbBrand.setBackground(valid);
        }else{
            cmbBrand.setBackground(invalid);
            item.setBrand(null);
        }
    }

    public static  void cmblSubCategoryAp(ActionEvent e,Item oldItem, Item item, JComboBox cmblSubCategory){

        int subindex = cmblSubCategory.getSelectedIndex();
        SubCategory subcategorys = (SubCategory) cmblSubCategory.getSelectedItem();
        if(subindex != 0){
            item.setSubCategory((SubCategory)cmblSubCategory.getSelectedItem() );
            if(oldItem!=null){
                if(!subcategorys.equals(oldItem.getBrand()))
                    cmblSubCategory.setBackground(updated);
                else
                    cmblSubCategory.setBackground(valid);
            }else
                cmblSubCategory.setBackground(valid);
        }else{
            cmblSubCategory.setBackground(invalid);
            item.setSubCategory(null);
        }
    }

    public static void cmbStatusItemAp(ActionEvent e,Item oldItem, Item item, JComboBox cmbStatusItem){

        int Siindex = cmbStatusItem.getSelectedIndex();
        StatusItem statusitems = (StatusItem) cmbStatusItem.getSelectedItem();
        if(Siindex != 0){
            cmbStatusItem.setBackground(valid);
            item.setStatusItem((StatusItem)cmbStatusItem.getSelectedItem() );
            if(oldItem!=null){
                if(!statusitems.equals(oldItem.getBrand()))
                    cmbStatusItem.setBackground(updated);
                else
                    cmbStatusItem.setBackground(valid);
            }else
                cmbStatusItem.setBackground(valid);
        }else{
            cmbStatusItem.setBackground(invalid);
            item.setStatusItem(null);
        }
    }

    public static void dteDoIntroducedAp(PropertyChangeEvent e,Item oldItem, Item item,JDateChooser dteDoIntroduced){

        java.util.Date dt = dteDoIntroduced.getDate();
        JTextField dtpDisplay=(JTextField)dteDoIntroduced.getDateEditor().getUiComponent();
        if( dt !=null){
            LocalDate dointroduced = LocalDate.of(dt.getYear()+1900,dt.getMonth()+1,dt.getDate());
            item.setDoIntroduced(dointroduced);
            if(oldItem!=null){
                if(!dointroduced.equals(oldItem.getDoIntroduced()))
                    dtpDisplay.setBackground(updated);
                else
                    dtpDisplay.setBackground(valid);
            }else
                dtpDisplay.setBackground(valid);
        }

    }
}

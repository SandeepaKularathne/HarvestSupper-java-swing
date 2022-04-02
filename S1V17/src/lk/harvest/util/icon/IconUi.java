package lk.harvest.util.icon;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class IconUi {

    public static Icon iconSerchBlack = new ImageIcon("src/resources/search.png");
    public static Icon iconSerchRed = new ImageIcon("src/resources/search1.png");
    public static Icon iconAddBlack = new ImageIcon("src/resources/Users-Add-User-icon.png");
    public static Icon iconAddRed= new ImageIcon("src/resources/add-user-icon.png");
    public static Icon iconClearRed= new ImageIcon("src/resources/clear-red.png");
    public static Icon iconClearBlack= new ImageIcon("src/resources/clear-black.png");
    public static Icon iconDeleteRed= new ImageIcon("src/resources/delete-red.png");
    public static Icon iconDeleteBlack= new ImageIcon("src/resources/delete-black.png");
    public static Icon iconUpdateRed= new ImageIcon("src/resources/update-red.png");
    public static Icon iconUpdateBlack= new ImageIcon("src/resources/update-black.png");

    public static void SearchMouseEnter(MouseEvent e, JButton btnSearch) { btnSearch.setIcon(iconSerchRed);}
    public static void SearchMouseExit(MouseEvent e, JButton btnSearch) {btnSearch.setIcon(iconSerchBlack);}
    public static void AddMouseEnter(MouseEvent e, JButton btnAdd) {btnAdd.setIcon(iconAddRed);}
    public static void AddMouseExit(MouseEvent e, JButton btnAdd) {btnAdd.setIcon(iconAddBlack);}
    public static void ClearMouseEnter(MouseEvent e, JButton btnClear) {btnClear.setIcon(iconClearRed);}
    public static void ClearMouseExit(MouseEvent e, JButton btnClear) {btnClear.setIcon(iconClearBlack);}
    public static void SearchClearMouseEnter(MouseEvent e, JButton btnSearchClear) {btnSearchClear.setIcon(iconClearRed);}
    public static void SearchClearMouseExit(MouseEvent e, JButton btnSearchClear) {btnSearchClear.setIcon(iconClearBlack);}
    public static void DeleteMouseEnter(MouseEvent e, JButton btnDelete) {btnDelete.setIcon(iconDeleteRed);}
    public static void DeleteMouseExit(MouseEvent e, JButton btnDelete) {btnDelete.setIcon(iconDeleteBlack);}
    public static void UpdateMouseEnter(MouseEvent e, JButton btnUpdate) {btnUpdate.setIcon(iconUpdateRed);}
    public static void UpdateMouseExit(MouseEvent e, JButton btnUpdate) {btnUpdate.setIcon(iconUpdateBlack);}


}

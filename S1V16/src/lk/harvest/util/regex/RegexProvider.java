package lk.harvest.util.regex;

import lk.harvest.entity.*;
import java.lang.reflect.Method;

public class RegexProvider {

    public static String get(){

       Employee emp = new Employee();
       String regexname ="";

       try {

            Method setName = emp.getClass().getMethod("SetName", String.class);
            Patern name = setName.getAnnotation(Patern.class);
            regexname = name.regexp();

       } catch (NoSuchMethodException e) {
           System.out.println("No Method");
       }

       return regexname;
   } 
}

package lk.harvest.util.regex;

import lk.harvest.entity.*;

import java.lang.annotation.Annotation;
import java.util.Hashtable;
import java.lang.reflect.Method;
import java.util.Locale;

public class RegexProvider {

    public static Hashtable<String,String> get(){

       Employee emp = new Employee();
       Hashtable<String,String>htregexname = new Hashtable();

       Method ms[] =emp.getClass().getMethods();
       //Method ms[] =emp.getClass().getFields();
       for (Method m: ms){
           Pattern a= m.getAnnotation(lk.harvest.util.regex.Pattern.class);
           if (a != null){
               htregexname.put(m.getName().substring(3).toLowerCase(), a.regexp());
               //htregexname.put(m.getName(), a.regexp());
           }
       }
      /* try {

            Method setName = emp.getClass().getMethod("setName", String.class);
            Pattern name = setName.getAnnotation(Pattern.class);

            Method setNic = emp.getClass().getMethod("setNic", String.class);
            Pattern nic = setNic.getAnnotation(Pattern.class);

            htregexname.put("name", name.regexp());
            htregexname.put("nic", nic.regexp());

       } catch (NoSuchMethodException e) {
            System.out.println("No Method");
       }*/

       return htregexname;
   } 
}

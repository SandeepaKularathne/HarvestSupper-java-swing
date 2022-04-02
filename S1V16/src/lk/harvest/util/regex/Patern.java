package lk.harvest.util.regex;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

@interface Patern{
    String regexp();
}

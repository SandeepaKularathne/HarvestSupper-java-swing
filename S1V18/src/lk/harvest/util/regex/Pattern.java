package lk.harvest.util.regex;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
//@Target(ElementType.FIELD)


public @interface Pattern {
    String regexp();
}

package boj.zlica.busline.util;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {

    String message() default "Los unos godina";
    int lower() default 18;
    int upper() default 60;

    Class<?>[] groups() default {};
    Class<? extends Payload> []payload() default {};
}

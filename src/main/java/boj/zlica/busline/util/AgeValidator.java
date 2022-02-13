package boj.zlica.busline.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

    private int lower;
    private int upper;

    @Override
    public void initialize(Age age) {
        ConstraintValidator.super.initialize(age);
        this.lower = age.lower();
        this.upper = age.upper();
        //post construct work can write here
    }

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {
        //moja logika
        if(age==null) return false;
        if(age < lower || age>upper) return false;

        return true;
    }
}

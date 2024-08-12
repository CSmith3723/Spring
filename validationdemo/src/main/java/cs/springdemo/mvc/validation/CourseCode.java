package cs.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) //Where are the constraints defined?
@Target({ElementType.METHOD, ElementType.FIELD}) //where can the annotation be used?
@Retention(RetentionPolicy.RUNTIME) //how long do we keep the annotation active/valid?
public @interface CourseCode {

    //default course code
    public String value() default "SPRING";

    //default error message
    public String message() default "must start with SPRING";

    //default group -- no default here
    public Class<?>[] groups() default {};

    //default payload
    public Class<? extends Payload>[] payload() default {};

}

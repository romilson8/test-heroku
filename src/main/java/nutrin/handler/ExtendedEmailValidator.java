package nutrin.handler;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Email(message="Por favor fornecer um e-mail válido")
@Pattern(regexp=".+@.+\\..+", message="Por favor fornecer um e-mail válido")
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface ExtendedEmailValidator {
    String message() default "Por favor fornecer um e-mail válido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
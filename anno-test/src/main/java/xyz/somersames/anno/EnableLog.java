package xyz.somersames.anno;

import org.springframework.context.annotation.Import;
import xyz.somersames.anno.register.LogRegister;

import java.lang.annotation.*;

/**
 * @author somersames
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({LogRegister.class})
public @interface EnableLog {
}

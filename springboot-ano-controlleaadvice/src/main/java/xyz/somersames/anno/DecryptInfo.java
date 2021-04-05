package xyz.somersames.anno;

import java.lang.annotation.*;

/**
 * @author somersames
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DecryptInfo {
    /**
     * 代表解密的类型
     * @return
     */
    String type() default "idCard";
}

package xyz.somersames.anno.register;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author somersames
 */
public class LogRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println("自定义注解--start");
        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(LogAop.class).getBeanDefinition();
        registry.registerBeanDefinition("logAspect",beanDefinition);
        System.out.println("自定义注解--end");
    }
}

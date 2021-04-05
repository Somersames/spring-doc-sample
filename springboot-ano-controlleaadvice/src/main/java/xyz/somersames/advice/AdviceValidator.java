package xyz.somersames.advice;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import xyz.somersames.entity.Advice;


public class AdviceValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Advice.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Advice advice = (Advice) target;
        if(advice.getAge() >= 1 && StringUtils.isEmpty(advice.getName())){
            errors.rejectValue("name","advice.name","年龄大于1岁的，姓名不能为空");
        }
    }
}

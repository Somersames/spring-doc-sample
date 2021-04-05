package xyz.somersames.advice;

import org.springframework.util.StringUtils;
import xyz.somersames.entity.Advice;

import java.beans.PropertyEditorSupport;

public class ProductEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(StringUtils.isEmpty(text)){
            return;
        }
        String[] strings = text.split("-");
        Advice advice = new Advice();
        advice.setName(strings[0]);
        advice.setAge(Integer.parseInt(strings[1]));
        setValue(advice);
    }
}

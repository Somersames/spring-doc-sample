package xyz.somersames.advice;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.util.Date;

public class DateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(StringUtils.isEmpty(text)){
            return;
        }
        // 格式化
        setValue(new Date());
    }
}

package com.example.recard.validator;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Log4j2
public abstract class AbstractValidator<T> implements Validator {

    @Override
    public boolean supports(Class<?> cl){
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void validate(Object target, Errors errors){
        try{
            doValidate((T) target, errors);
        }catch(RuntimeException e){
            log.error("중복 검사 에러", e);
            throw e;
        }
    }

    protected abstract void doValidate(final T dto, final Errors errors);

}

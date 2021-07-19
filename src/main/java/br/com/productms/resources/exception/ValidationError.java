package br.com.productms.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();
  
    public List<FieldMessage> getErrors() {
		return errors;
	}

	public void setErrors(List<FieldMessage> errors) {
		this.errors = errors;
	}

	public ValidationError(Integer status, String msg) {
        super(status, msg);
        this.errors = errors;
    }

    public void addError(String fieldName, String mensagem){
        errors.add(new FieldMessage(fieldName, mensagem));
    }

}

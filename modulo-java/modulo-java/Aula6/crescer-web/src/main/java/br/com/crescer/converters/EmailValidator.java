package br.com.crescer.converters;

import br.com.crescer.utils.FacesUtils;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @author Carlos H. Nonnemacher
 */
@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        FacesUtils.addMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail inválido", " "));
    }

}

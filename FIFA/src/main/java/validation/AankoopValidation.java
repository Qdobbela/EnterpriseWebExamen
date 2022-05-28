package validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import domain.Aankoop;

public class AankoopValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Aankoop.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Aankoop aankoop = (Aankoop) target;
		int v1 = aankoop.getVoetbalcode1();
		int v2 = aankoop.getVoetbalcode2();
		if(v1 > v2) {
			errors.rejectValue("voetbalcode1", "validation.Voetbalcode", "voetbalcode 1 moet kleiner zijn dan voetbalcode 2");
		}
	}

}

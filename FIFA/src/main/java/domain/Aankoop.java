package domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Aankoop {
	
	public Aankoop() {
		
	}
	
	@NotEmpty(message="mag niet leeg zijn")
	@Email(message = "moet een geldig email adres zijn")
	private String email;
	
	@NotNull(message="mag niet leeg zijn")
	@Min(1)
	@Max(25)
	private int aantal;

	@NotNull(message="mag niet nul zijn")
	private int voetbalcode1;
	
	@NotNull(message="mag niet nul zijn")
	private int voetbalcode2;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	public int getVoetbalcode1() {
		return voetbalcode1;
	}

	public void setVoetbalcode1(int voetbalcode1) {
		this.voetbalcode1 = voetbalcode1;
	}

	public int getVoetbalcode2() {
		return voetbalcode2;
	}

	public void setVoetbalcode2(int voetbalcode2) {
		this.voetbalcode2 = voetbalcode2;
	}
}

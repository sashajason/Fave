package ch.zhaw.infm.springboottemplate.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public class Benutzer {
	
	public Benutzer(String email, String benutzername, String passwort) {
		this.email = email;
		this.benutzername = benutzername;
		this.passwort = passwort;
	}
	
	public Benutzer()
	{
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long benutzerId;

	public Long getBenutzerId() {
		return benutzerId;
	}

	private String email;

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String benutzername;

	public String getBenutzername() {
		return this.benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	private String passwort;

	public String getPasswort() {
		return this.passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

}

package ch.zhaw.infm.springboottemplate.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Konsument extends Benutzer {

	public Konsument(String email, String benutzername, String passwort, String name, String vorname,
			Date geburtsdatum) {
		super(email, benutzername, passwort);
		this.name = name;
		this.vorname = vorname;
		this.geburtsdatum = geburtsdatum;
	}

	public Konsument() {
		super();
	}

	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String vorname;

	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	@Temporal(TemporalType.DATE)
	private Date geburtsdatum;

	public Date getGeburtsdatum() {
		return this.geburtsdatum;
	}

	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
}

package ch.zhaw.infm.springboottemplate.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Veranstalter extends Benutzer {

	public Veranstalter(String email, String benutzername, String passwort,
			Set<Veranstaltung> veranstaltungen, String firmenname, String strasse, int plz, String ort) {
		super(email, benutzername, passwort);
		this.veranstaltungen = veranstaltungen;
		this.firmenname = firmenname;
		this.strasse = strasse;
		this.plz = plz;
		this.ort = ort;
	}

	public Veranstalter() {
	}

	@ManyToMany
	private Set<Veranstaltung> veranstaltungen;

	public Set<Veranstaltung> getVeranstaltungen() {
		return this.veranstaltungen;
	}

	private String firmenname;

	public String getFirmenname() {
		return this.firmenname;
	}

	public void setFirmenname(String firmenname) {
		this.firmenname = firmenname;
	}

	private String strasse;

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	private int plz;

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	private String ort;

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

}

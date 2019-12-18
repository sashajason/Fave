package ch.zhaw.infm.springboottemplate.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Artist {

	
	
	public Artist(@NotNull Genre genre, Set<Veranstaltung> veranstaltungen, String name,
			String beschreibung, String artistImage) {
		this.genre = genre;
		this.veranstaltungen = veranstaltungen;
		this.name = name;
		this.beschreibung = beschreibung;
		this.artistImage = artistImage;
	}
	
	public Artist() {
		super();
	}




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long artistId;

	public Long getArtistId() {
		return artistId;
	}

	@NotNull
	@OneToOne
	private Genre genre;

	public Genre getGenre() {
		return genre;
	}

	@OneToMany
	private Set<Veranstaltung> veranstaltungen;

	public Set<Veranstaltung> getVeranstaltungen() {
		return this.veranstaltungen;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String beschreibung;

	public String getBeschreibung() {
		return this.beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	private String artistImage;

	public String getArtistImage() {
		return this.artistImage;
	}

}

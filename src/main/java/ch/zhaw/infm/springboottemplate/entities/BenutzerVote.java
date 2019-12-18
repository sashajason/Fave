package ch.zhaw.infm.springboottemplate.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BenutzerVote {

	public BenutzerVote(Benutzer benutzer, Artist artist, float investition) {
		this.benutzer = benutzer;
		this.artist = artist;
		this.investition = investition;
	}

	public BenutzerVote() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long benutzerVoteId;

	@OneToOne
	private Benutzer benutzer;

	@OneToOne
	private Artist artist;

	public Artist getArtist() {
		return artist;
	}

	private float investition;

	public float getInvestition() {
		return this.investition;
	}

	public void setInvestition(float investition) {
		this.investition = investition;
	}

}

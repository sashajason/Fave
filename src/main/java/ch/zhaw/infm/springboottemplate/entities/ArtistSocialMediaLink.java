package ch.zhaw.infm.springboottemplate.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class ArtistSocialMediaLink implements Serializable {

	public ArtistSocialMediaLink(@NotNull Artist artist, String spotify, String instagram,
			String youtube, String facebook, String twitter) {
		this.artist = artist;
		this.spotify = spotify;
		this.instagram = instagram;
		this.youtube = youtube;
		this.facebook = facebook;
		this.twitter = twitter;
	}

	public ArtistSocialMediaLink() {
		super();
	}

	public ArtistSocialMediaLink(Artist artist) {
		this.artist = artist;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long artistSocialMediaLinkId;

	public Long getartistSocialMediaLinkId() {
		return artistSocialMediaLinkId;
	}

	@NotNull
	@OneToOne
	private Artist artist;

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	private String spotify;

	public String getSpotify() {
		return spotify;
	}

	public void setSpotify(String spotify) {
		this.spotify = spotify;
	}

	private String instagram;

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	private String youtube;

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

	private String facebook;

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	private String twitter;

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
}

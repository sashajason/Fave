package ch.zhaw.infm.springboottemplate.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    public Long getLocationId() {
        return locationId;
    }
    
 private String name;
    
    public String getName() {
    	return name;
    }

    public void setName(String name) {
    	this.name = name;
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

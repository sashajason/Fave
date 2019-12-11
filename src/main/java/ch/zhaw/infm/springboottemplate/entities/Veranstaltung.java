package ch.zhaw.infm.springboottemplate.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Veranstaltung {

	public Veranstaltung(Location location) {
		this.location = location;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long veranstaltungId;

    public Long getVeranstaltungId() {
        return veranstaltungId;
    }
	
    @OneToOne
    @NotNull
    private Location location;

    public Location getLocation() {
        return location;
    }
    
    @Temporal(TemporalType.DATE)
    public Date datum;
    
    public Date getDatum() {
    	return this.datum;
    }
    
       
    public void setDatum(Date datum) {
    	 this.datum = datum;
    }
       
    private boolean ausverkauft;
    
    public boolean getAusverkauft() {
    	return this.ausverkauft;
    }
    
    public void setAusverkauft(boolean ausverkauft) {
    	this.ausverkauft = ausverkauft;
    }
    
    private int anzBesucher;
    
    public int getAnzBesucher() {
    	return this.anzBesucher;
    }
    
    public void setAnzBesucher(int anzBesucher) {
    	this.anzBesucher = anzBesucher;
    }
    
    private float investition;
    
    public float getInvestition(){
    	return this.investition;
    }
    
    public void setInvestition(float investition) {
    	this.investition = investition;
    }
}

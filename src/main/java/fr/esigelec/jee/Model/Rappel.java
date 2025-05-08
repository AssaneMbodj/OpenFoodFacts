package fr.esigelec.jee.Model;


import java.util.Date;

public class Rappel {
    private Date dateRappel;
    private String motif;
    private String marque;
	public Date getDateRappel() {
		return dateRappel;
	}
	public void setDateRappel(Date dateRappel) {
		this.dateRappel = dateRappel;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public Rappel(Date dateRappel, String motif, String marque) {
		super();
		this.dateRappel = dateRappel;
		this.motif = motif;
		this.marque = marque;
	}
	@Override
	public String toString() {
		return "Rappel [dateRappel=" + dateRappel + ", motif=" + motif + ", marque=" + marque + "]";
	}

    
}
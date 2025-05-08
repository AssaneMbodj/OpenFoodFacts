package fr.esigelec.jee.Model;

public class Produit {
    private String nom;
    private String ingredients;
    private String codeBarres;
    private String urlPhoto;
	public Produit(String nom, String ingredients, String codeBarres, String urlPhoto) {
		super();
		this.nom = nom;
		this.ingredients = ingredients;
		this.codeBarres = codeBarres;
		this.urlPhoto = urlPhoto;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getCodeBarres() {
		return codeBarres;
	}
	public void setCodeBarres(String codeBarres) {
		this.codeBarres = codeBarres;
	}
	public String getUrlPhoto() {
		return urlPhoto;
	}
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}
	@Override
	public String toString() {
		return "Produit [nom=" + nom + ", ingredients=" + ingredients + ", codeBarres=" + codeBarres + ", urlPhoto="
				+ urlPhoto + "]";
	}

  
}
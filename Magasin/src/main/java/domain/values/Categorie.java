package domain.values;

public class Categorie {
	private String intitule;
	
	public Categorie(final String categorie) {
		intitule = categorie;
	}
	
	public String getCategorie() {
		return intitule;
	}
	
	public void setCategorie(String categorie) {
		if (respectRules(categorie)) {
			intitule = categorie;
		}
		
		throw new IllegalArgumentException();
	}
	
	private boolean respectRules(String categorie) {
		if (categorie == null) {
			return false;
		}
		
		if (categorie.length() > 32) {
			return false;
		}
		
		return true;
	}
}

package domain.value;

public class FamilleArticle {
	private String intitule;
	
	public FamilleArticle(final String familleArticle) {
		intitule = familleArticle;
	}
	
	public String getFamilleArticle() {
		return intitule;
	}
	
	public void setFamilleArticle(String familleArticle) {
		if (respectRules(familleArticle)) {
			intitule = familleArticle;
		}
		
		throw new IllegalArgumentException();
	}
	
	private boolean respectRules(String familleArticle) {
		if (familleArticle == null) {
			return false;
		}
		
		if (familleArticle.length() > 32) {
			return false;
		}
		
		return true;
	}
}

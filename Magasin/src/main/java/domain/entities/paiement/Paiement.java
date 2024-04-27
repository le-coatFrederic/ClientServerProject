package domain.entities.paiement;

public class Paiement implements IPaiement {
	private String intitule;
	private PaiementMethod methode;
	
	@Override
	public String getIntitule() {
		return intitule;
	}

	@Override
	public PaiementMethod getMethod() {
		return methode;
	}

	@Override
	public void setIntitule(String intitule) {
		if (intitule == null || intitule == "") {
			throw new IllegalArgumentException();
		}
		
		this.intitule = intitule;
	}

	@Override
	public void setMethod(PaiementMethod method) {
		if (method == null) {
			throw new IllegalArgumentException();
		}
		
		this.methode = method;
	}

}

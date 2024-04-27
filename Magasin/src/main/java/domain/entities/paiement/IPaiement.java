package domain.entities.paiement;

public interface IPaiement {
	public String getIntitule();
	public PaiementMethod getMethod();
	public void setIntitule (String intitule);
	public void setMethod(PaiementMethod method);
}

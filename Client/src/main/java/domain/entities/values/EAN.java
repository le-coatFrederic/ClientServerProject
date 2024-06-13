package domain.entities.values;

public class EAN {
	private String ean;
	
	public EAN(final String ean) {
		this.ean = ean;
	}
	
	public String getEan() {
		return ean;
	}
	
	public void setEan(final String ean) {
		if (respectEan(ean) == false) {
			throw new IllegalArgumentException();
		}
		
		this.ean = ean;
	}
	
	public boolean respectEan(final String ean) {
		if (ean.length() > 13 || ean.length() < 13 || ean == null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return ean;
	}
}

package magasin.domain.entities.article;

public class EuropeanEAN implements IEAN {
    private String ean;
    private int characterLimit;

    public EuropeanEAN(final int characterLimit_param) {
        characterLimit = characterLimit_param;
    }
    
    @Override
    public string getEAN() {
        return ean;
    }

    @Override
    public void setEAN(final String ean_param) {
        ean = ean_param;
    }
}

package heptathlon.domain.dto;

import java.io.Serializable;

public class ShopDTO implements Serializable {
    private long id;
    private String intitule;
    
    public ShopDTO(long id, String intitule) {
        this.id = id;
        this.intitule = intitule;
    }

    public long getId() {
        return id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    @Override
    public String toString() {
        return "ShopDTO [id=" + id + ", intitule=" + intitule + "]";
    }

    
}

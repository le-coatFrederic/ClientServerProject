package heptathlon.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Shop")
public class Shop {
    @Id
    @GeneratedValue
    private long id;
    private String intitule;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Invoice> invoices = new HashSet<>();

    public Shop() {
    }

    public Shop(long id, String intitule) {
        this.id = id;
        this.intitule = intitule;
    }

    public long getId() {
        return id;
    }

    public String getIntitule() {
        return intitule;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
        for (Invoice invoice : invoices) {
            invoice.setShop(this);
        }
    }

    public void addInvoice(Invoice invoiceToAdd) {
        this.invoices.add(invoiceToAdd);
        invoiceToAdd.setShop(this);
    }

    public void removeInvoice(Invoice invoiceToRemove) {
        this.invoices.remove(invoiceToRemove);
    }

    public void update(Shop newShop) {
        if (newShop == null) {
            throw new IllegalArgumentException();
        }

        this.setIntitule(newShop.getIntitule());
        this.setInvoices(newShop.getInvoices());
    }
}

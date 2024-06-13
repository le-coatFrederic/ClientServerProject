package usecase;

import java.util.Date;
import java.util.List;

import domain.entity.Facture;

public interface IFactureListe {
    public List<Facture> getAllFactures();
    public List<Facture> getAllFacturesMontantSuperieur(double montant);
    public List<Facture> getAllFacturesMontantInferieur(double montant);
    public List<Facture> getAllFacturesDateAnterieure(Date date);
    public List<Facture> getAllFacturesDatePosterieure(Date date);
    public List<Facture> getAllFacturesDate(Date date);
    public List<Facture> getAllFacturesPlageDate(Date dateBorneInf, Date dateBorneSup);
    public double getMontantTotal();
    public double getMontantTotalFiltre(List<Facture> facturesFiltrees);
}

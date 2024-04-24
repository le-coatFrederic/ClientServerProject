package domain.entities.entrepot;

import java.util.ArrayList;

public class EntrepotAnnuaire {
	private ArrayList<Entrepot> entrepots;
	
	public EntrepotAnnuaire() {
		entrepots = new ArrayList<Entrepot>();
	}
	
	public ArrayList<Entrepot> getEntrepots() {
		return entrepots;
	}
	
	public Entrepot getEntrepot(int index) {
		return entrepots.get(index);
	}
	
	public void removeEntrepot(Entrepot entrepot) {
		entrepots.remove(entrepots.indexOf(entrepot));
	}
}

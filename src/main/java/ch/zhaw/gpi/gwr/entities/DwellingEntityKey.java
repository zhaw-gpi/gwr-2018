package ch.zhaw.gpi.gwr.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 * Zusammengesetzter Primary Key für die DwellingEntity
 * 
 * Der Wohnungsidentifikator ist eine Kombination aus Gebäude (EGID) und einem EWID
 * 
 * @author Jasmin Schleeh <matthjas@students.zhaw.ch> und scep
 */
public class DwellingEntityKey implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // Eidgenössischer Wohnungsidentifikator
    private int ewid;
    
    // Gebäude Entität
    private BuildingEntity building;

    //default Constructor
    public DwellingEntityKey() {
        // nichts tun
    }

    // Constructor um direkt beide Werte zu übergeben   
    public DwellingEntityKey(int ewid, BuildingEntity building) {
        this.ewid = ewid;
        this.building = building;
    }

    // Eigene equals-Implementation
    @Override
    public boolean equals(Object obj) {
        //Falls ein Objekt übergeben wurde und es von unserem Typ ist
        if(obj != null && obj instanceof DwellingEntityKey){
            // Cast des Objekts in unser Key-Objelt
            DwellingEntityKey objCasted = (DwellingEntityKey)obj;
            // falls beide Werte dieselben sind: ja, sonst nein.
            // Wichtig: Hier könnte man noch das Building selbst genauer prüfen, wir haben dies aber zum Vereifachen weggelassen
            return objCasted.ewid == this.ewid && objCasted.building == this.building;
        }
        // return standard equals antwort
        return super.equals(obj); 
    }    

    // Eigene hashCode-Implementation
    @Override
    public int hashCode() {
        return Objects.hash(this.ewid, this.building);
    }
}

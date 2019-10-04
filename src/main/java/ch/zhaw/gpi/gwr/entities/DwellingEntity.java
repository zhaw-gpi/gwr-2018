package ch.zhaw.gpi.gwr.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entitäts-Klasse für Wohnungen
 * 
 * Jasmin Schleeh <matthjas@students.zhaw.ch> und scep
 */
@Entity(name="Wohnung")
// Klasse für die zusammengesetzte ID
@IdClass(DwellingEntityKey.class) 
public class DwellingEntity {
    // ZUSAMMENGESETZTE ID START
    // Manuell gesetzter Eidgenössischer Wohnungsidentifikator
    @Id
    @Min(value = 1)
    @Max(value = 900)
    private int ewid;
        
    // Beziehung zu einem Gebäude
    @Id
    @ManyToOne
    @JoinColumn(name = "egid")
    private BuildingEntity building;
    // ZUSAMMENGESETZTE ID ENDE
    
    // Administrative Wohnungsnummer (z.B. der Gemeinde)
    @Size(min = 1, max = 12)
    private String whgNr;

    // Stockwerk
    @NotNull
    @Min(value = 3100)
    @Max(value = 3419)
    private int wStwk;

    // Mehrgeschossigkeit (1 = ja, 2 = nein)
    @NotNull
    @Min(value = 1)
    @Max(value = 2)
    private int wMehrG;

    // Lage auf dem Stockwerk
    @NotNull
    @Size(min = 3, max = 40)
    private String wBez;

    // Anzahl Zimmer
    @NotNull
    @Min(value = 1)
    @Max(value = 99)
    private int wAZim;

    // GETTER und SETTER
    public int getEwid() {
        return ewid;
    }

    public DwellingEntity setEwid(int ewid) {
        this.ewid = ewid;
        return this;
    }
    
    public String getwhgNr() {
        return this.whgNr;
    }

    public DwellingEntity setwhgNr(String whgNr) {
        this.whgNr = whgNr;
        return this;
    }

    public int getwStwk() {
        return this.wStwk;
    }

    public DwellingEntity setwStwk(int wStwk) {
        this.wStwk = wStwk;
        return this;
    }

    public int getwMehrG() {
        return this.wMehrG;
    }

    public DwellingEntity setwMehrG(int wMehrG) {
        this.wMehrG = wMehrG;
        return this;
    }

    public String getwBez() {
        return this.wBez;
    }

    public DwellingEntity setwBez(String wBez) {
        this.wBez = wBez;
        return this;
    }

    public int getwAZim() {
        return this.wAZim;
    }

    public DwellingEntity setwAZim(int wAZim) {
        this.wAZim = wAZim;
        return this;
    }
    
    public BuildingEntity getBuilding() {
        return building;
    }

    public DwellingEntity setBuilding(BuildingEntity building) {
        this.building = building;
        return this;
    }

}
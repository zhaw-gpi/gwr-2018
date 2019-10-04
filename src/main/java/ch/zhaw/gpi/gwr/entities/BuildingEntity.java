package ch.zhaw.gpi.gwr.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entitäts-Klasse für Gebäude
 * 
 * @author scep
 */
@Entity(name="Gebaeude")
public class BuildingEntity {
    // Eidgenössischer Gebäudeidentifikator
    @Id
    private int egid;

    // Postleitzahl
    @NotNull
    @Min(value = 1000)
    @Max(value = 9999)
    private int dplz4;

    // Strassenname
    @NotNull
    @Size(max = 60)
    private String strName;

    // Hauseingangsnummer
    @NotNull
    @Size(min = 1, max = 12)
    private String deinr;

    // GETTER und SETTER
    public int getEgid() {
        return egid;
    }

    public BuildingEntity setEgid(int egid) {
        this.egid = egid;
        return this;
    }

    public int getDplz4() {
        return dplz4;
    }

    public BuildingEntity setDplz4(int dplz4) {
        this.dplz4 = dplz4;
        return this;
    }

    public String getStrName() {
        return strName;
    }

    public BuildingEntity setStrName(String strName) {
        this.strName = strName;
        return this;
    }

    public String getDeinr() {
        return deinr;
    }

    public BuildingEntity setDeinr(String deinr) {
        this.deinr = deinr;
        return this;
    }

    
}
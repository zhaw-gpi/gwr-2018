package ch.zhaw.gpi.gwr.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class BuildingEntity implements Serializable {
    // Automatisch generierte Gebäude-Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gebId;

    // Postleitzahl
    @NotNull
    @Min(value = 1000)
    @Max(value = 9999)
    private int dplz4;

    // Strassenname
    @NotNull
    @Size(max = 60)
    private String strName;

    // Hausnummer
    @NotNull
    @Size(min = 1, max = 12)
    private String deinr;

    // Referenz auf Wohnungen zu diesem Gebäude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Gebaeude")
    private List<DwellingEntity> Wohnungen;

    // GETTER und SETTER
    public Long getgebId() {
        return this.gebId;
    }

    public void setgebId(Long gebId) {
        this.gebId = gebId;
    }

    public int getdplz4() {
        return this.dplz4;
    }

    public void setdplz4(int dplz4) {
        this.dplz4 = dplz4;
    }

    public String getstrName() {
        return this.strName;
    }

    public void setstrName(String strName) {
        this.strName = strName;
    }

    public String getdeinr() {
        return this.deinr;
    }

    public void setdeinr(String deinr) {
        this.deinr = deinr;
    }

    public List<DwellingEntity> getWohnungen() {
        if (Wohnungen == null) {
            Wohnungen = new ArrayList<>();
        }
        return this.Wohnungen;
    }

    public void setWohnungen(List<DwellingEntity> Wohnungen) {
        this.Wohnungen = Wohnungen;
    }

    public void addWohnung(DwellingEntity Wohnung) {
        this.Wohnungen.add(Wohnung);
        Wohnung.setGebaeude(this);
    }

    public void removeWohnung(DwellingEntity Wohnung) {
        this.Wohnungen.remove(Wohnung);
        Wohnung.setGebaeude(null);
    }

}
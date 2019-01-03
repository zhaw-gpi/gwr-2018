package ch.zhaw.gpi.gwr.repositories;

import ch.zhaw.gpi.gwr.entities.BuildingEntity;
import ch.zhaw.gpi.gwr.entities.DwellingEntity;
import ch.zhaw.gpi.gwr.entities.DwellingEntityKey;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository-Klasse für Wohnung-Entität, welche CRUD-Operationen auf die dahinterliegende Datenbank kapselt
 * 
 * Jasmin Schleeh <matthjas@students.zhaw.ch> und scep
 */
public interface DwellingRepository extends JpaRepository<DwellingEntity, DwellingEntityKey>{
    
    /**
     * Methode, um alle Wohnungen in einem Gebäude zu erhalten
     * 
     * @param buildingEntity    Das Gebäude
     * @return                  Die Wohnungen im Gebäude
     */
    public List<DwellingEntity> findByBuilding(BuildingEntity buildingEntity);
}

# Gebäude- und Wohnungsregister 2018 (gwr-2018)

> Autoren der Dokumentation: Björn Scheppler

> Dokumentation letztmals aktualisiert: 3.9.2018

Dieses Projekt simuliert das Gebäude- und Wohnungsregister der Schweiz, welches Operationen über SOAP unter anderem für die [Umzugsplattform](https://github.com/zhaw-gpi/eumzug-plattform-2018) bereitstellt.

## Wie können Studierende Bonus-Punkte sammeln (in Aufgabenstellung verschieben)
1. Weitere Operationen bereitstellen
2. Eine kleine Webapplikation erstellen als Schnittstelle für CRUD-Operationen
3. Validierung (min-length & Co. für die Requests einbauen)

## (Technische) Komponenten
1. **Spring Boot Starter** beinhaltend:
    1. Spring Boot-Standardkonfiguration mit Tomcat als Applikations- und Webserver
    2. Web-Komponenten von Spring
    3. Main-Methode in GwrApplication-Klasse
2. **Persistierungs-Komponenten**:
    1. H2-Datenbank-Unterstützung inklusive Console-Servlet über ApplicationConfiguration-Klasse
    2. Datenmodell (JPA-Diagramm GwrModel.jpa)
    3. Java Persistence API (JPA) und persistence.xml
    4. Package Repositories und Package entities für Building und Dwelling
    6. initialData.sql (und initialData.xlsx) in test/ressources, um die Datenbank initial mit sinnvollen Stammdaten zu füllen
3. **SOAP WebService-Komponenten** (PS: mit Apache CXF gelöst statt nur spring-boot-starter-webservices, da letzteres mit der komplexen Struktur des XSD nicht umgehen kann)
    1. SOAP-Webservice-Komponenten (Java API for XML Web Services-Komponenten,  CXF-Servlet-Komponenten)
    2. WebServiceConfiguration-Klasse
    3. JAXB-Konfiguration für Wohnungen (global.xjb)
    4. XML-Schema Definition als Basis für das WSDL und die durch ein Maven-Plugin generierten Klassen (gwr.xsd)
    5. Schnittstellen-Definition (Endpoint: GebaeudeUndWohnungsRegisterServiceEndpoint)
4. **Business-Logik**:
    1. GwrBuildingController mit der Methode, um zu prüfen, ob an einer Adresse ein Gebäude existiert
    2. GwrDwellingController mit einer Methode, um Wohnungen an einer Adresse zurück zu erhalten
5. "Sinnvolle" **Grundkonfiguration** in application.properties für Tomcat, Datenbank und Datumsformat
6. **Test-Fälle** als soapUI-Projekt (GebaeudeUndWohnungsRegisterServiceTests-soapui-project.xml)

## Deployment und Start
1. **Erstmalig** oder bei Problemen ein **Clean & Build (Netbeans)**, respektive `mvn clean install` (Cmd) durchführen
2. Bei Änderungen am POM-File oder bei **(Neu)kompilierungsbedarf** genügt ein **Build (Netbeans)**, respektive `mvn install`
3. Für den **Start** ist ein **Run (Netbeans)**, respektive `java -jar .\target\NAME DES JAR-FILES.jar` (Cmd) erforderlich. Dabei wird Tomcat gestartet, die Datenbank erstellt/hochgefahren mit den Eigenschaften (application.properties) und die verschiedenen Resourcen-URL-Mappings vorgenommen.
4. Initial sind **Daten in der Datenbank anzulegen**. Hierzu an der Console anmelden (http://localhost:8090/console; jdbc:h2:./gwr, Benutzer sa, kein Passwort) und die SQL-Befehle in test/resources/initalData.sql ausführen.
5. Das **Beenden** geschieht mit **Stop Build/Run (Netbeans)**, respektive **CTRL+C** (Cmd)


## Nutzung der Applikation
### Tests mit soapUI
1. Starten wie im vorherigen Kapitel beschrieben, damit der SOAP WebService läuft und über die URL http://localhost:8090/soap verfügbar ist
2. Testen über folgende Varianten:
    1. In soapUI händisch neue SOAP-Requests generieren mit der WSDL http://localhost:8090/soap/GebaeudeUndWohnungsRegisterService?wsdl. Welche Gebäude und Wohnungen dabei gefunden werden können, kann über die H2-Konsole geprüft werden in den Tabellen GEBAEUDE und WOHNUNG. Anmeldedaten siehe bei Deployment und Start oben.
    2. Die vorgefertigten Requests/TestSuite nutzen im soapUI-Projekt \src\test\resources\GebaeudeUndWohnungsRegisterServiceTests-soapui-project.xml

### Tests aus der Umzugsplattform heraus
Hierzu den Anweisungen folgen in https://github.com/zhaw-gpi/eumzug-plattform-2018

## Mitwirkende
1. Björn Scheppler: Hauptarbeit
2. Peter Heinrich: Der stille Support im Hintergrund mit vielen Tipps sowie zuständig für den Haupt-Stack mit SpringBoot & Co.
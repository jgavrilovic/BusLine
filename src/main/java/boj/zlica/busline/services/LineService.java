package boj.zlica.busline.services;

import boj.zlica.busline.dto.LineEntity;

import java.util.List;

public interface LineService {

    /**Metoda vraca listu entiteta iz tabele line_entity, ovaj servis poziva LineController
     * @return List <LineEntity> - prikaz svih LineEntity entiteta iz baze
     */
    List<LineEntity> showLines();

    /**Metoda vraca atribut iz tabele line_entity zahtevan pomocu parametra id
     * @param id - prosledjen kroz poziv LineControllera
     * @return LineEntity - prikaz entiteta pod odredjenim id-ijem
     * */
    LineEntity showById(Long id);

    /**Metoda kreira novu liniju(LiveEntity) koji treba da bude sacuvan u bazi
     * @param startLocation - pocetna lokacija vozila
     * @param endLocation - krajnja lokacija vozila
     * @param ticketPrice - cena karte
     * @param transportType - tip transporta(BUS,VAN)
     * */
    void createLine(String startLocation, String endLocation, Integer ticketPrice, String transportType);

    /**Metoda dohvata podatak sa odredjenim idjem pomocu id parametra i menja podatke u odnosu na prosledjene parametre,
     * dobijene iz LineControllera preko body poruke
     * @param id - kroz URL dobijen parametar, id podatka koji se menja
     * @param startLocation - pocetna lokacija vozila
     * @param endLocation - krajnja lokacija vozila
     * @param ticketPrice - cena karte
     * @param transportType - tip transporta(BUS,VAN)
     * */
    void editLine(Long id, String startLocation, String endLocation, Integer ticketPrice, String transportType);

}

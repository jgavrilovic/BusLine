package boj.zlica.busline.services;

import boj.zlica.busline.entities.LineEntity;

import java.util.List;
import java.util.Optional;

public interface LineService {

    List<LineEntity> showLines();
    LineEntity showById(Long id);
    void createLine(String startLocation, String endLocation, Integer ticketPrice, String transportType);
    void editLine(Long id, String startLocation, String endLocation, Integer ticketPrice, String transportType);

}

package boj.zlica.busline.controllers;

import boj.zlica.busline.entities.LineEntity;
import boj.zlica.busline.entities.TransportType;
import boj.zlica.busline.services.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/lines")
public class LineControllerImpl implements LineController{

    @Autowired
    LineService lineService;


    @Override
    public List<LineEntity> searchAllLines() {
        return lineService.showLines();
    }

    /**TODO
     *  nema provere ako id nepostoji, potrebna implementacija rola
     *  */
    @Override
    public ResponseEntity<?> searchById(Long id) {
        return new ResponseEntity<>(lineService.showById(id), HttpStatus.OK);
    }

    /**TODO
     *  potrebna implementacija rola, mozda i validacija argumenata
     *  */
    @Override
    public ResponseEntity<String> createLine(Map<String, Object> lineMap) {
        String startLocation = (String) lineMap.get("start_location");
        String endLocation = (String) lineMap.get("end_location");
        Integer ticketPrice = (Integer) lineMap.get("ticket_price");
        String transportType = (String) lineMap.get("transport_type");

        lineService.createLine(startLocation,endLocation,ticketPrice,transportType);
        return new ResponseEntity<>("Linija je uspesno kreirana",HttpStatus.CREATED);
    }

    /**TODO
     *  potrebna implementacija rola, mozda i validacija argumenata
     *  moguce je uraditi optimizaciju editLine
     *  status mozda nije odgovarajuci
     *  */
    @Override
    public ResponseEntity<?> editLine(Long id, Map<String,Object> lineMap) {

        String startLocation = (String) lineMap.get("start_location");
        String endLocation = (String) lineMap.get("end_location");
        Integer ticketPrice = (Integer) lineMap.get("ticket_price");
        String transportType = (String) lineMap.get("transport_type");

        lineService.editLine(id, startLocation,endLocation,ticketPrice,transportType);
        return new ResponseEntity<>("Linija je uspesno izmenjena",HttpStatus.OK);
    }


}

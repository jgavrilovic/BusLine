package boj.zlica.busline.services;

import boj.zlica.busline.entities.LineEntity;
import boj.zlica.busline.entities.TransportType;
import boj.zlica.busline.repositories.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LineServiceImpl implements LineService{


    @Autowired
    LineRepository lineRepository;


    @Override
    public List<LineEntity> showLines() {
            return lineRepository.findAll();
    }

    @Override
    public LineEntity showById(Long id) {
        //TODO: ne moze se null vratiti, mora informacija o gresci
        if(lineRepository.findById(id).isPresent())
            return lineRepository.findById(id).get();
        return null;
    }

    @Override
    public void createLine(String startLocation, String endLocation, Integer ticketPrice, String transportType) {
        //kreira se entitet i cuva se u bazi
        LineEntity lineEntity = new LineEntity();
        lineEntity.setStartLocation(startLocation);
        lineEntity.setEndLocation(endLocation);
        lineEntity.setTicketPrice(ticketPrice);
        lineEntity.setTransportType((TransportType.valueOf(transportType)));
        lineRepository.save(lineEntity);
    }

    @Override
    public void editLine(Long id, String startLocation, String endLocation, Integer ticketPrice, String transportType) {
        //TODO: sigurno moze optimizacije provere koji se podatak menja a koji ne.
        LineEntity lineEntity = showById(id);

        if(lineEntity.getStartLocation().equals(startLocation)){
            System.out.println("Nije potrebna izmena starta");
        }else{
            lineEntity.setStartLocation(startLocation);
        }

        if(lineEntity.getEndLocation().equals(endLocation)){
            System.out.println("Nije potrebna izmena enda");
        }else{
            lineEntity.setEndLocation(endLocation);
        }

        if(lineEntity.getTicketPrice().equals(ticketPrice)){
            System.out.println("Nije potrebna izmena cene");
        }else{
            lineEntity.setTicketPrice(ticketPrice);
        }
        if(lineEntity.getTransportType() == TransportType.valueOf(transportType)){
            System.out.println("Nije potrebna izmena transporta");
        }else{
            lineEntity.setTransportType(TransportType.valueOf(transportType));
        }

        lineRepository.save(lineEntity);
    }


}

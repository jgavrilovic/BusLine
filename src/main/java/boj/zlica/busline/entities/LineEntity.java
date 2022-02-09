package boj.zlica.busline.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

//TODO: izmeni naziv tabele
@Data
@Entity
public class LineEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idLine;

    @Column(name = "start_location")
    private String startLocation;

    @Column(name = "end_location")
    private String endLocation;

    @Column(name = "ticket_price")
    private Integer ticketPrice;

    @Column(name = "transport_type")
    @Enumerated(EnumType.STRING)
    private TransportType transportType;

    //TODO: vreme kretanja,dolaska, tip karte(povratna,jednosmerna), datum vazenja karte itd..

    public LineEntity(){}





}

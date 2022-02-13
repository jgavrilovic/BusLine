package boj.zlica.busline.controllers;

import boj.zlica.busline.dto.LineEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public interface LineController {

    /**Vraca sve podatke iz tabele "line_entity", putanja: api/lines/searchAll
     * @return List <LineEntity> lista entiteta LineEntity
     * */
    @GetMapping("/searchAll")
    List<LineEntity> searchAllLines();

    /**Vraca podatak iz tabele "line_entity" zatrazen preko parametra id, putanja: api/lines/searchById/1
     * @param id id linije prosledjen kroz URL
     * @return LineEntity entitet LineEntity
     * */
    @GetMapping("/searchById/{id}")
    ResponseEntity<?> searchById(@PathVariable("id") Long id);

    /**Kreira novu stavku u tabeli "line_entity", putanja: api/lines/create
     * @param  lineMap Objekat prosledjen sa korisnicke strane kroz body u JSON formatu
     * @return HttpStatus.CREATED
     * */
    @PostMapping("/create")
    ResponseEntity<String> createLine(@RequestBody Map<String,Object> lineMap);

    /**Menja podatak iz tabele "line_entity", zatrazen preko parametra id, putanja: api/edit/{id}
     * @param id id prosledjen iz URLa
     * @param lineMap Objekat prosledjen sa korisnicke strane kroz body u JSON formatu
     * */
    @PutMapping("/edit/{id}")
    ResponseEntity<?> editLine(@PathVariable("id") Long id, @RequestBody Map<String,Object> lineMap);


}

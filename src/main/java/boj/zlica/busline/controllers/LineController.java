package boj.zlica.busline.controllers;

import boj.zlica.busline.entities.LineEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public interface LineController {

    @GetMapping("/searchAll")
    List<LineEntity> searchAllLines();

    @GetMapping("/searchById/{id}")
    ResponseEntity<?> searchById(@PathVariable("id") Long id);

    @PostMapping("/create")
    ResponseEntity<String> createLine(@RequestBody Map<String,Object> lineMap);

    @PutMapping("/edit/{id}")
    ResponseEntity<?> editLine(@PathVariable("id") Long id, @RequestBody Map<String,Object> lineMap);


}

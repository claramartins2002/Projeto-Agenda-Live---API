package com.estudosAngular.API.Lives.controller;

import com.estudosAngular.API.Lives.entity.Lives;
import com.estudosAngular.API.Lives.service.LiveServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LiveController {
    @Autowired
    LiveServices liveServices;

    @GetMapping("/lives")
    public ResponseEntity<Page<Lives>> getAllLives(@PageableDefault(page=0, size=10, sort="id", direction = Sort.Direction.DESC) Pageable pageable, @RequestParam(required = false) String flag){
        Page<Lives> livePage = liveServices.findAll(pageable, flag);
        if(livePage.isEmpty()){
            return new ResponseEntity<>(NOT_FOUND);
        }
        else {
            return new ResponseEntity<Page<Lives>>(livePage, OK);
        }
     }
     @GetMapping("/lives/{id}")
    public ResponseEntity<Lives> getOneLive(@PathVariable(value="id") String id){
         Lives live0=liveServices.findById(id);

             return new ResponseEntity<Lives>(live0, OK);
         }

    @PutMapping("/lives/{id}")
    public Lives editLive(@PathVariable(value="id") String id, @RequestBody Lives live){
        Lives live0=liveServices.findById(id);

            return liveServices.edit(live, live.getId().toString());

    }

     @PostMapping("/lives")
    public ResponseEntity<Lives> saveLive(@RequestBody Lives live){
        live.setData(LocalDateTime.now());
        return new ResponseEntity<Lives>(liveServices.save(live), OK);
     }

     @DeleteMapping("/lives/{id}")
    public ResponseEntity<Lives> deleteLive(@PathVariable(value="id") String id) {
         Lives live0=liveServices.findById(id);

             return liveServices.delete(live0);
         }
     }



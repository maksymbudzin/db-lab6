package com.budzin.controller;
import com.budzin.domain.Owner_information;
import com.budzin.dto.Owner_informationDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.budzin.service.Owner_informationService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/Owner_information")
@RestController
public class Owner_informationController {
    private final Owner_informationService owner_informationService;

    public Owner_informationController(Owner_informationService owner_informationService) {
        this.owner_informationService = owner_informationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Owner_informationDto>> getAll() {
        List<Owner_information> owner_informations = owner_informationService.getAll();
        List<Owner_informationDto> owner_informationDtos = new ArrayList<>();
        for (Owner_information owner_information : owner_informations) {
            Owner_informationDto owner_informationDto = new Owner_informationDto(
                    owner_information.getId(),
                    owner_information.getName(),
                    owner_information.getSurname(),
                    owner_information.getCountry()

            );
            owner_informationDtos.add(owner_informationDto);
        }
        return new ResponseEntity<>(owner_informationDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Owner_informationDto> getById(@PathVariable Integer id) {
        Owner_information owner_information = owner_informationService.getById(id);
        if (owner_information != null) {
            Owner_informationDto owner_informationDto = new Owner_informationDto(
                    owner_information.getId(),
                    owner_information.getName(),
                    owner_information.getSurname(),
                    owner_information.getCountry()

            );
            return new ResponseEntity<>(owner_informationDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Owner_information newOwner_information) {
        owner_informationService.create(newOwner_information);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Owner_informationDto> update(@PathVariable Integer id,
                                            @RequestBody Owner_information owner_information) {
        Owner_information owner_information1 = owner_informationService.getById(id);
        if (owner_information1 != null) {
            owner_informationService.update(id, owner_information);
            Owner_informationDto owner_informationDto = new Owner_informationDto(
                    owner_information.getId(),
                    owner_information.getName(),
                    owner_information.getSurname(),
                    owner_information.getCountry()

            );
            return new ResponseEntity<>(owner_informationDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (owner_informationService.getById(id) != null) {
            owner_informationService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
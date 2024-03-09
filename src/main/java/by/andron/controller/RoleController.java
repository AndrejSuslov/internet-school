package by.andron.controller;

import by.andron.dto.RoleCreationDto;
import by.andron.dto.RoleDto;
import by.andron.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/roles")
public class RoleController {

    private final RoleService service;

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleDto> save (@RequestBody RoleCreationDto dto){
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> update (@PathVariable("id") Long id, @RequestBody RoleCreationDto dto){
        service.update(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete (@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

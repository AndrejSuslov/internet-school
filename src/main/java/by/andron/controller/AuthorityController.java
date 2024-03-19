package by.andron.controller;

import by.andron.dto.AuthorityCreationDto;
import by.andron.dto.AuthorityDto;
import by.andron.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping
public class AuthorityController {

    private final AuthorityService service;

    @PreAuthorize("hasAuthority('READ_AUTHORITY')")
    @GetMapping("/{id}")
    public ResponseEntity<AuthorityDto> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('READ_AUTHORITY')")
    @GetMapping
    public ResponseEntity<List<AuthorityDto>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('CREATE_AUTHORITY')")
    @PostMapping
    public ResponseEntity<AuthorityDto> save(@RequestBody AuthorityCreationDto dto){
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('UPDATE_AUTHORITY')")
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable("id") Long id, @RequestBody AuthorityCreationDto dto){
        service.update(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('DELETE_AUTHORITY')")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

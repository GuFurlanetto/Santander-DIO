package one.digitalinnovation.personalapi.controller;


import lombok.AllArgsConstructor;
import one.digitalinnovation.personalapi.dto.request.PersonDTO;
import one.digitalinnovation.personalapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personalapi.exception.PersonNotFoundException;
import one.digitalinnovation.personalapi.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController
{

    private PersonServices personServices;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personServices.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personServices.listAll();

    }

    @GetMapping("/{id}")
    public PersonDTO findById (@PathVariable long id) throws PersonNotFoundException {
        return personServices.findById(id);
    }

    @GetMapping("/{id}")
    public MessageResponseDTO updateById (@PathVariable long id, @RequestBody PersonDTO personDTO) throws PersonNotFoundException {
        return personServices.updateById(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById (@PathVariable long id) throws PersonNotFoundException {
        personServices.delete(id);
    }
}

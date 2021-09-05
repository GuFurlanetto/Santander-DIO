package one.digitalinnovation.personalapi.service;

import one.digitalinnovation.personalapi.dto.request.PersonDTO;
import one.digitalinnovation.personalapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personalapi.entity.Person;
import one.digitalinnovation.personalapi.repository.PersonRepository;
import one.digitalinnovation.personalapi.services.PersonServices;
import one.digitalinnovation.personalapi.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.personalapi.utils.PersonUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServices personServices;

    @Test
    void testGivenPersonDTOThenReturnSavedPerson() {
        PersonDTO personDTO = createFakeDTO();

        Person expectedSavedPerson = PersonUtils.createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccesMessage = createExpectedMessageResponse(expectedSavedPerson.getId());

        MessageResponseDTO succesMessage = personServices.createPerson(personDTO);

        assertEquals(expectedSuccesMessage, succesMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(long id) {
        return MessageResponseDTO.builder()
                .message("Created person with ID:"+ id)
                .build();
    }
}

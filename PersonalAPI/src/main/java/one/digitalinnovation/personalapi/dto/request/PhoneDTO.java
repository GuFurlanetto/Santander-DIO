package one.digitalinnovation.personalapi.dto.request;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personalapi.enums.PhoneType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    private long id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @NotNull
    @Size(min = 13, max = 14)
    private String number;
}

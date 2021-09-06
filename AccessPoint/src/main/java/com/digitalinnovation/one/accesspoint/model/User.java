package com.digitalinnovation.one.accesspoint.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userName;

    @ManyToOne
    private UserCategory userCategory;

    @ManyToOne
    private Company company;

    @ManyToOne
    private AccessLevel accessLevel;

    @ManyToOne
    private WorkDay workDay;


    private BigDecimal tolerance;

    private LocalDateTime journeyStarts;

    private LocalDateTime journeyEnds;

}

package com.digitalinnovation.one.accesspoint.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
public class Transition {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class TransitionId implements Serializable {
        private long transitionId;
        private long userId;
    }

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private TransitionId id;

    private LocalDateTime entryDate;

    private LocalDateTime endDate;

    private BigDecimal period;

    @ManyToOne
    private Occurrence occurrence;

    @ManyToOne
    private Calendar calendar;

}

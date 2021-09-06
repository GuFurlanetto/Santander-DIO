package com.digitalinnovation.one.accesspoint.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
public class AnnualLeave {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class AnnualLeaveId implements Serializable {
        private long annualLeaveId;
        private long transitionId;
        private long userId;
    }

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private AnnualLeaveId id;

    private LocalDateTime workDate;

    private BigDecimal totalHours;

    private BigDecimal hoursBalance;

}

package com.innteam.buildup.commons.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DomainObject {
    public static final String JOIN_TABLE_SEPARATOR = "_";

    @Id
    private UUID id;

    private Timestamp creationDate;

    @PrePersist
    public void prePersist() {
        if (this.creationDate == null) {
            this.creationDate = new Timestamp(System.currentTimeMillis());
        }
    }
}

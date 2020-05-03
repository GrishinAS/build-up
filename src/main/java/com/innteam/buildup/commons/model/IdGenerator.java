package com.innteam.buildup.commons.model;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.UUIDGenerator;

import java.io.Serializable;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class IdGenerator extends UUIDGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor s, @NonNull Object obj) {
        final DomainObject object = (DomainObject) obj;
        if (object == null) {
            throw new IllegalArgumentException();
        }

        return object.getId() == null ? super.generate(s, obj) : object.getId();
    }
}

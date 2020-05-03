package com.innteam.buildup.commons.model;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@FieldDefaults(level = AccessLevel.PRIVATE)
public interface UserRepository extends JpaRepository<User, UUID> {

}

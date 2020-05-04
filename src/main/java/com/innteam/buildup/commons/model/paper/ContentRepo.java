package com.innteam.buildup.commons.model.paper;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContentRepo extends JpaRepository<Content, UUID> {
}

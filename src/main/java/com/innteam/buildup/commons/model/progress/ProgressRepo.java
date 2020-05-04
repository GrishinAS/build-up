package com.innteam.buildup.commons.model.progress;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProgressRepo extends JpaRepository<Process, UUID> {
}

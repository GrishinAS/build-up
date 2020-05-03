package com.innteam.buildup.commons.model.paper;

import com.innteam.buildup.commons.model.paper.Paper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaperRepo extends JpaRepository<Paper, UUID> {
}

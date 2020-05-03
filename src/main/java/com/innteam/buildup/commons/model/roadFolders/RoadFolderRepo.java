package com.innteam.buildup.commons.model.roadFolders;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoadFolderRepo extends JpaRepository<RoadFolder, UUID> {
}

package com.innteam.buildup.commons.model.roadFolders;

import com.innteam.buildup.commons.model.DomainObject;
import com.innteam.buildup.commons.model.paper.Content;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = RoadFolder.TABLE_NAME)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoadPoint extends DomainObject {
    String name;
    @Lob
    @Column(length = 100000)
    String description;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Content> contents;
}

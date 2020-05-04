package com.innteam.buildup.commons.model.roadFolders;

import com.innteam.buildup.commons.model.DomainObject;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = RoadFolder.TABLE_NAME)
public class RoadFolder extends DomainObject {
    static final String TABLE_NAME = "roadFolders";
    private String name;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<RoadPoint> internal;
}

package com.innteam.buildup.commons.model.user;

import com.innteam.buildup.commons.model.DomainObject;
import com.innteam.buildup.commons.model.paper.Content;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Progress.TABLE_NAME)
public class Progress extends DomainObject {
    static final String TABLE_NAME = "progress";
   @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
   Content content;
    Long timeSpent;
    PaperActivityStatus status;
}

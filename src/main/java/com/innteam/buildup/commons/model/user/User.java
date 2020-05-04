package com.innteam.buildup.commons.model.user;

import com.innteam.buildup.commons.model.DomainObject;
import com.innteam.buildup.commons.model.progress.Progress;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@NoArgsConstructor
@Table(name = User.TABLE_NAME)
public class User extends DomainObject {

    public static final String TABLE_NAME = "users";

    public User(String name, long freeTimePerDay, int freeDaysPerWeek) {
        this.name = name;
        this.freeTimePerDay = freeTimePerDay;
        this.freeDaysPerWeek = freeDaysPerWeek;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Progress> progressList = new ArrayList<>();

    @Size(min = 1)
    String name;

    //в минутах
    @Min(0)
    long freeTimePerDay;

    @Min(0)
    int freeDaysPerWeek;
}

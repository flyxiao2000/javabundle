package com.xcloud.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString(of = {"id","age","name"})
public class City {
    private Long id;
    private Integer age;

    @JsonProperty("cityName")
    private String name;

    @JsonIgnore
    private Integer userID;
//    private Section section;
}

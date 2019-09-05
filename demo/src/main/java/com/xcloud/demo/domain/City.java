package com.xcloud.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class City {
    private Long id;
    private Integer age;

    @JsonProperty("cityName")
    private String name;

    @JsonIgnore
    private Integer userID;
//    private Section section;
}

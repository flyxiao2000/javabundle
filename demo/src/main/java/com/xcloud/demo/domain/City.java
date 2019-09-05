package com.xcloud.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

@AllArgsConstructor
@Getter
@Setter
public class City {
    private Long id;
    private Integer age;

    @JsonProperty("cityName")
    private String name;

//    private Section section;
}

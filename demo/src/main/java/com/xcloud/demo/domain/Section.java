package com.xcloud.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class Section {
    private Long id;

    @JsonProperty("sectionName")
    private String name;
}

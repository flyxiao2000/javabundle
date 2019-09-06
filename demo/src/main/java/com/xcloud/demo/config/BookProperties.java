package com.xcloud.demo.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Configuration
@Getter
@Setter
@ToString
@Validated
public class BookProperties {
    @Value("${demo.book.name}")
    //@NotEmpty
    private String name;

    @NotEmpty
    @NotNull
    @Value("${demo.book.writer}")
    private String writer;
}

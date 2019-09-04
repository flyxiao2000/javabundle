package com.xcloud.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CommonResp {
    private Integer code;
    private String msg;
}

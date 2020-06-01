package com.hengshui.domain;

import lombok.Data;

@Data
public class Account {
    private Integer id;
    private Integer uid;
    private Double money;
    private Integer cardNumber;

    private User user;
}

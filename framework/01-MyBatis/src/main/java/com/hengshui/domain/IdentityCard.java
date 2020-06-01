package com.hengshui.domain;


import lombok.Data;

@Data
public class IdentityCard {

    private Integer id;
    private Integer uid;
    private String userIdentityCard;
    private String address;

    private User user;
}

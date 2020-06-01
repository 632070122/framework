package com.hengshui.domain;

import lombok.Data;

import java.util.List;

@Data
public class Role {

    private Integer roleId;
    private String roleName;
    private String roleDesc;

    private List<User> users;
}

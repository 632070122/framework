package com.hengshui.domain;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    private IdentityCard identityCard;

    private List<Account> accounts;

    private Account account;

    private List<Role> roles;
}

package com.hengshui.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class User implements Serializable {

    private String username;
    private Integer age;

    private Account account;

    private List<Account> accountList;

    private Map<String,Account> accountMap;
}

package com.angubaidullin.springapp.dto;

import com.angubaidullin.springapp.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestDTO {
    private Long id;
    private String name;
    private String email;
    private String bill;

}

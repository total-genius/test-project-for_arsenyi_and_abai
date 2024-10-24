package com.angubaidullin.springapp.dto;

import com.angubaidullin.springapp.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String bill;

    public AccountResponseDTO(Account account) {
        this.id = account.getId();
        this.name = account.getName();
        this.email = account.getEmail();
        this.bill = account.getBill();
    }
}

package com.angubaidullin.springapp.controller;

import com.angubaidullin.springapp.dto.AccountRequestDTO;
import com.angubaidullin.springapp.dto.AccountResponseDTO;
import com.angubaidullin.springapp.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    public AccountResponseDTO save(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.save(accountRequestDTO);
    }
}

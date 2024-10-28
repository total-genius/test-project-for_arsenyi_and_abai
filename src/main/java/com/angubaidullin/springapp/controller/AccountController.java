package com.angubaidullin.springapp.controller;

import com.angubaidullin.springapp.dto.AccountRequestDTO;
import com.angubaidullin.springapp.dto.AccountResponseDTO;
import com.angubaidullin.springapp.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/accounts/{id}")
    public AccountResponseDTO findById(@PathVariable Long id) {
        return accountService.findById(id);
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteById(@PathVariable Long id) {
        accountService.delete(id);
    }

    @GetMapping("accounts/account")
    public List<AccountResponseDTO> findByName(@RequestParam String name) {
        return accountService.findByName(name);
    }


    @PostMapping("/accounts/add/all")
    public List<AccountResponseDTO> save(@RequestBody List<AccountRequestDTO> accountRequestDTO) {

        List<AccountResponseDTO> list = accountRequestDTO.stream().map(el -> accountService.save(el)).toList();

        return list;
    }
}

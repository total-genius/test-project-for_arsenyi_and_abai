package com.angubaidullin.springapp.service;

import com.angubaidullin.springapp.dto.AccountRequestDTO;
import com.angubaidullin.springapp.dto.AccountResponseDTO;
import com.angubaidullin.springapp.entity.Account;
import com.angubaidullin.springapp.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class AccountService {
    private final AccountRepository accountRepository;
    /*
    Принимает на вход AccountRequestDTO, преобразуем его
    в Account и с помощью AccountRepository сохраняем в базу
    и возвращаем в контроллер AccountResponseDto с сохраненным
    в базе аккаунтом.
     */
    public AccountResponseDTO save(AccountRequestDTO accountRequestDTO) {
        Account account = new Account();
        account.setName(accountRequestDTO.getName());
        account.setEmail(accountRequestDTO.getEmail());
        account.setBill(accountRequestDTO.getBill());

        Account savedAccount = accountRepository.save(account);

        return new AccountResponseDTO(savedAccount);
    }
}

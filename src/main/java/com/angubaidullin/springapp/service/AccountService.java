package com.angubaidullin.springapp.service;

import com.angubaidullin.springapp.dto.AccountRequestDTO;
import com.angubaidullin.springapp.dto.AccountResponseDTO;
import com.angubaidullin.springapp.entity.Account;
import com.angubaidullin.springapp.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


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

    public AccountResponseDTO findById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account with id:" + id + " is not found"));

        return new AccountResponseDTO(account);
    }

    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

    public List<AccountResponseDTO> findByName(String name) {
        return accountRepository.findByName(name)
                .stream()
                .map(AccountResponseDTO::new)
                .toList();
    }
}

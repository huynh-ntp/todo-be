package com.huynhntp.todobe.service.impl;

import com.huynhntp.todobe.configuration.security.UserInfoService;
import com.huynhntp.todobe.dto.AccountDTO;
import com.huynhntp.todobe.entity.Account;
import com.huynhntp.todobe.mapper.AccountMapper;
import com.huynhntp.todobe.repository.AccountRepository;
import com.huynhntp.todobe.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    //Repositories
    private AccountRepository accountRepository;

    //Mappers
    private AccountMapper accountMapper;

    private UserInfoService userInfoService;

    @Override
    public AccountDTO create(AccountDTO accountDTO) {
        Account account = accountMapper.toEntity(accountDTO);
        userInfoService.addUser(account);
        return null;
    }
}

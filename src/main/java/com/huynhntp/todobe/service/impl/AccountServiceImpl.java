package com.huynhntp.todobe.service.impl;

import com.huynhntp.todobe.configuration.security.UserInfoService;
import com.huynhntp.todobe.dto.AccountDTO;
import com.huynhntp.todobe.entity.Account;
import com.huynhntp.todobe.mapper.AccountMapper;
import com.huynhntp.todobe.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    //Mappers
    private final AccountMapper accountMapper;

    private final UserInfoService userInfoService;

    @Override
    public AccountDTO create(AccountDTO accountDTO) {
        Account account = accountMapper.toEntity(accountDTO);
        userInfoService.addUser(account);
        return null;
    }
}

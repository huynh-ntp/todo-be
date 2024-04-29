package com.huynhntp.todobe.mapper;

import com.huynhntp.todobe.dto.AccountDTO;
import com.huynhntp.todobe.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDTO toDto(Account account);

    Account toEntity(AccountDTO accountDTO);

}

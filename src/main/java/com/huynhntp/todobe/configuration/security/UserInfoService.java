package com.huynhntp.todobe.configuration.security;

import com.huynhntp.todobe.dto.AccountDTO;
import com.huynhntp.todobe.entity.Account;
import com.huynhntp.todobe.mapper.AccountMapper;
import com.huynhntp.todobe.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserInfoService implements UserDetailsService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccountMapper accountMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> userAccount = accountRepository.findByUsername(username);
        return userAccount.map(UserInfoDetails::new).orElseThrow(
                () -> new UsernameNotFoundException(String.format("Không tìm thấy tài khoản %s", username)));
    }

    public AccountDTO addUser(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        Account savedAccount = accountRepository.save(account);
        return accountMapper.toDto(savedAccount);
    }

}

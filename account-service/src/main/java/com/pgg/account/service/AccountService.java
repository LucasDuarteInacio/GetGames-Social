package com.pgg.account.service;

import com.pgg.account.domain.Account;
import com.pgg.account.dto.enums.AccountStatusEnum;
import com.pgg.account.exception.BadRequestException;
import com.pgg.account.exception.NotFoundException;
import com.pgg.account.mapper.AccountMapper;
import com.pgg.account.repository.AccountRepository;
import com.pgg.account.vo.AccountFilterRequest;
import com.pgg.account.vo.AccountRequest;
import com.pgg.account.vo.ProfileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    public Account registerAccount(AccountRequest accountRequest) {
        boolean isAccountExists = accountRepository.existsByEmailOrUsername(accountRequest.getEmail());

        if (isAccountExists) {
            throw new BadRequestException(BadRequestException.existsAccount().getIssue());
        }

        Account account = accountMapper.toDomain(accountRequest);
        return accountRepository.save(account);
    }

    public Account updateProfile(String accountId, ProfileRequest profileRequest) {
        Account accountExisted = findById(accountId);

        Account account = accountMapper.toDomain(accountExisted, profileRequest);
        return accountRepository.save(account);
    }

    public void updateStatusAccount(String accountId, AccountStatusEnum status) {
        Account account = findById(accountId);
        account.setStatus(String.valueOf(status));
        accountRepository.save(account);
    }

    public List<Account> getAccountByFilters(final AccountFilterRequest accountFilterRequest) {
        return accountRepository.findByFilters(accountFilterRequest);
    }

    public Account findById(String accountId){
      return  accountRepository.findById(accountId).orElseThrow(NotFoundException::accountNotFound);
    }

    public Account login(String email,String password){
       return accountRepository.findByEmailAndPassword(email, password).orElseThrow(NotFoundException::accountNotFound);


    }

}

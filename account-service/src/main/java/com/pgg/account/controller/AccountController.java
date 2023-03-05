package com.pgg.account.controller;

import com.pgg.account.dto.enums.AccountStatusEnum;
import com.pgg.account.mapper.AccountMapper;
import com.pgg.account.service.AccountService;
import com.pgg.account.vo.AccountFilterRequest;
import com.pgg.account.vo.AccountRequest;
import com.pgg.account.vo.AccountResponse;
import com.pgg.account.vo.ProfileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class AccountController implements IAccountController{

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @Override
    public ResponseEntity<AccountResponse> newAccount(AccountRequest accountRequest) {
        AccountResponse account = accountMapper.toResponse(accountService.registerAccount(accountRequest));
        URI uri =
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/id")
                        .buildAndExpand("id")
                        .toUri();
        return ResponseEntity.created(uri).body(account);
    }

    @Override
    public ResponseEntity<AccountResponse> updateProfile(String accountId, ProfileRequest profileRequest) {
        AccountResponse account = accountMapper.toResponse(
                accountService.updateProfile(accountId,profileRequest));
        return ResponseEntity.ok(account);
    }

    @Override
    public ResponseEntity<List<AccountResponse>> getAccountByFilters(final String accountId, final String email, final String username, final AccountStatusEnum status) {
        AccountFilterRequest accountFilterRequest =AccountFilterRequest.builder()
                .accountId(accountId)
                .username(username)
                .email(email)
                .status(status)
                .build();
        List<AccountResponse> accounts = accountMapper.toResponse(
                accountService.getAccountByFilters(accountFilterRequest));
        return ResponseEntity.ok(accounts);
    }

    @Override
    public ResponseEntity<Void> desactiveAccount(String accountId) {
        accountService.updateStatusAccount(accountId, AccountStatusEnum.DISACTIVED);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> activeAccount(String accountId) {
        accountService.updateStatusAccount(accountId, AccountStatusEnum.ACTIVE);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<AccountResponse> login(String email, String password) {
        AccountResponse accountResponse = accountMapper.toResponse(accountService.login(email, password));
        return ResponseEntity.ok(accountResponse);
    }


}

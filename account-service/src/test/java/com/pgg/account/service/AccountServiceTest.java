package com.pgg.account.service;

import com.pgg.account.config.TestUtils;
import com.pgg.account.domain.Account;
import com.pgg.account.repository.AccountRepository;
import com.pgg.account.vo.AccountFilterRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

import static org.mockito.Mockito.when;


@MockitoSettings
class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;



    @Test
    void shouldReturnAccountWhenWithEmailAndUsername() {
        // GIVEN
        Account account = TestUtils.EASY_RANDOM.nextObject(Account.class);
        AccountFilterRequest accountFilterRequest = TestUtils.EASY_RANDOM.nextObject(AccountFilterRequest.class);

        // WHEN
        when(accountRepository.findByFilters(accountFilterRequest)).thenReturn(List.of(account));
        List<Account> actualAccount = accountService.getAccountByFilters(accountFilterRequest);
        //THEN

        Assertions.assertEquals(account,actualAccount.get(0));
    }

    @Test
    void shouldReturnAccountWhenWithoutEmailAndUsername() {
        // GIVEN
        Account account = TestUtils.EASY_RANDOM.nextObject(Account.class);
        AccountFilterRequest accountFilterRequest = TestUtils.EASY_RANDOM.nextObject(AccountFilterRequest.class);
        accountFilterRequest.setEmail(null);
        accountFilterRequest.setUsername(null);

        // WHEN
        when(accountRepository.findByFilters(accountFilterRequest)).thenReturn(List.of(account));
        List<Account> actualAccount = accountService.getAccountByFilters(accountFilterRequest);

        //THEN
        Assertions.assertEquals(account,actualAccount.get(0));

    }
}
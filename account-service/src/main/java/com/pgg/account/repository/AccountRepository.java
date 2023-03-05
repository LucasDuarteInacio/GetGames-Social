package com.pgg.account.repository;

import com.pgg.account.domain.Account;
import com.pgg.account.repository.mongorepository.AccountMongoRepository;
import com.pgg.account.vo.AccountFilterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Component
@RequiredArgsConstructor
public class AccountRepository {

    private final MongoOperations mongoOperations;
    private final AccountMongoRepository accountMongoRepository;

    public Boolean existsByEmailOrUsername(String email){
        return accountMongoRepository.existsByEmail(email);
    }

    public Account save(Account account){
        return accountMongoRepository.save(account);
    }

    public Optional<Account> findById(String accountId){
        return accountMongoRepository.findById(accountId);
    }

    public Optional<Account> findByEmailAndPassword(String email, String password){
        return accountMongoRepository.findAccountByEmailAndPassword(email,password);
    }

    public List<Account> findByFilters(AccountFilterRequest accountFilter){
        Query query = new Query();
        Criteria criteria = new Criteria();
        if (nonNull(accountFilter.getEmail())) criteria.and("email").regex(accountFilter.getEmail(), "i");
        if (nonNull(accountFilter.getAccountId())) criteria.and("accountId").is(accountFilter.getAccountId());
        if (nonNull(accountFilter.getUsername())) criteria.and("username").regex(accountFilter.getUsername(),"i");
        if (nonNull(accountFilter.getStatus())) criteria.and("status").is(String.valueOf(accountFilter.getStatus()));
        query.addCriteria(criteria);
        return  mongoOperations.find(query, Account.class);
    }
}

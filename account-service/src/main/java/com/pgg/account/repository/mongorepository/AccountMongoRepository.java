package com.pgg.account.repository.mongorepository;

import com.pgg.account.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountMongoRepository extends MongoRepository<Account,String> {

    Boolean existsByEmail(String email);

    Optional<Account> findAccountByEmailAndPassword(String email, String password);

}

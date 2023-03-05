package com.pgg.account.mapper;


import com.pgg.account.domain.Account;
import com.pgg.account.domain.Profile;
import com.pgg.account.dto.enums.AccountStatusEnum;
import com.pgg.account.vo.AccountRequest;
import com.pgg.account.vo.AccountResponse;
import com.pgg.account.vo.ProfileRequest;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Mapper(
        componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        imports = {LocalDate.class, UUID.class, AccountStatusEnum.class, Profile.class}
)
public interface AccountMapper {

    AccountResponse toResponse(Account account);

    List<AccountResponse> toResponse(List<Account> accounts);

    @Mapping(target = "accountId", expression = "java(String.valueOf(UUID.randomUUID()))")
    @Mapping(target = "status",  expression = "java(String.valueOf(AccountStatusEnum.ACTIVE))")
    @Mapping(target = "registrationDate", expression = "java(LocalDate.now())")
    @Mapping(target = "registrationMethod", expression = "java(String.valueOf(accountRequest.getRegistrationMethod()))")
    @Mapping(target = "profile", expression = "java(new Profile())")
    Account toDomain(AccountRequest accountRequest);

    @Mapping(target = "profile",source = "profileRequest")
    Account toDomain(Account account, ProfileRequest profileRequest);


}

package com.pgg.account.controller;


import com.pgg.account.constants.OpenApiConstants;
import com.pgg.account.dto.enums.AccountStatusEnum;
import com.pgg.account.vo.AccountRequest;
import com.pgg.account.vo.AccountResponse;
import com.pgg.account.vo.ProfileRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RequestMapping()
@Tag(name= OpenApiConstants.ACCOUNT, description = "information about accounts")
public interface IAccountController {

    String ACCOUNT_ID = "accountId";
    String EMAIL = "email";
    String USERNAME = "username";
    String STATUS = "status";
    String PASSWORD = "password";


    @PostMapping("s")
    @Operation(summary = "Register new account")
    @ApiResponse(responseCode = "201", description = "account created successfully")
    ResponseEntity<AccountResponse> newAccount(@RequestBody @Valid AccountRequest accountRequest);

    @PutMapping("{accountId}/profile")
    @Operation(summary = "update user profile")
    @ApiResponse(responseCode = "200", description = "Profile updated successfully")
    ResponseEntity<AccountResponse> updateProfile(@PathVariable String accountId, @RequestBody @Valid ProfileRequest profileRequest);

    @GetMapping
    @Operation(summary = "Get account by filters")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Get account successfully")
            }
    )
    @Parameter(name = EMAIL, description = "User email", in = ParameterIn.QUERY)
    @Parameter(name = USERNAME, description = "User username", in = ParameterIn.QUERY)
    ResponseEntity<List<AccountResponse>> getAccountByFilters(
            @RequestParam(name = ACCOUNT_ID, required = false) final String accountId,
            @RequestParam(name = EMAIL, required = false) final String email,
            @RequestParam(name = USERNAME, required = false) final String username,
            @RequestParam(name = STATUS, required = false ) final AccountStatusEnum status
    );


    @DeleteMapping("{accountId}")
    @Operation(summary = "Desactive account")
    @ApiResponse(responseCode = "200", description = "account desactived successfully")
    ResponseEntity<Void> desactiveAccount(@PathVariable String accountId);

    @PatchMapping("{accountId}/active")
    @Operation(summary = "Active account")
    @ApiResponse(responseCode = "200", description = "account active successfully")
    ResponseEntity<Void> activeAccount(@PathVariable String accountId);

    @GetMapping("login")
    @Operation(summary = "Login account")
    @ApiResponse(responseCode = "200", description = "login successfully")
    ResponseEntity<AccountResponse> login(
            @RequestParam(name = EMAIL) final String email,
            @RequestParam(name = PASSWORD) final String password
    );

}

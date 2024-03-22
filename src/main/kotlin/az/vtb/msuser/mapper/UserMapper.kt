package az.vtb.msuser.mapper

import az.vtb.msuser.dao.UserEntity
import az.vtb.msuser.model.AccountType.CASH
import az.vtb.msuser.model.CreateAccountRequestDto
import az.vtb.msuser.model.CreateUserRequest
import java.math.BigDecimal.ZERO
import java.time.LocalDateTime

fun CreateUserRequest.toEntity(cashAccount: String) =
    UserEntity(
        username = username,
        firstName = firstName,
        lastName = lastName,
        email = email,
        cashAccount = cashAccount,
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )

fun CreateUserRequest.toCreateAccountRequestDto() =
    CreateAccountRequestDto(
        userId = username,
        accountType = CASH,
        balance = ZERO,
    )

package az.vtb.msuser.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CreateAccountResponseDto(
    val accountNumber: String,
)

data class CreateAccountRequestDto(
    @field: NotBlank
    @field: NotNull
    val userId: String,
    val cardId: String? = null,
    val accountType: AccountType,
    val balance: BigDecimal = BigDecimal.ZERO,
)

enum class AccountType {
    CASH,
}

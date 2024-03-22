package az.vtb.msuser.client

import az.vtb.msuser.model.CreateAccountRequestDto
import az.vtb.msuser.model.CreateAccountResponseDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(
    name = "account-service",
    url = "\${client.urls.ms-account}"
)
interface AccountClient {

    @PostMapping
    fun createAccount(@RequestBody createAccountRequestDto: CreateAccountRequestDto): CreateAccountResponseDto

}

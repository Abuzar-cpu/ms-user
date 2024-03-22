package az.vtb.msuser.controller

import az.vtb.msuser.model.CreateUserRequest
import az.vtb.msuser.model.DeleteUserRequest
import az.vtb.msuser.service.abstraction.UserService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/users")
class UserController(
    val userService: UserService
) {

    @DeleteMapping
    @ResponseStatus(NO_CONTENT)
    fun deleteUser(@RequestBody deleteUserRequest: DeleteUserRequest) =
        userService.deleteUser(deleteUserRequest)

    @PostMapping
    @ResponseStatus(CREATED)
    fun createUser(@RequestBody createUserRequest: CreateUserRequest) =
        userService.createUser(createUserRequest)

    @GetMapping("/username/{username}")
    fun getUserByUsername(@PathVariable username: String) = userService.getUserByUsername(username)

    @GetMapping("/email/{email}")
    fun getUserByEmail(@PathVariable email: String) = userService.getUserByEmail(email)

}

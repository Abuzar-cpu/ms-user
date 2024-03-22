package az.vtb.msuser.service.concrete

import az.vtb.msuser.annotation.Log
import az.vtb.msuser.client.AccountClient
import az.vtb.msuser.dao.UserRepository
import az.vtb.msuser.exception.ConflictException
import az.vtb.msuser.exception.ExceptionMessages.ALREADY_EXISTS_ERROR
import az.vtb.msuser.exception.ExceptionMessages.NOT_FOUND
import az.vtb.msuser.exception.NotFoundException
import az.vtb.msuser.mapper.toCreateAccountRequestDto
import az.vtb.msuser.mapper.toEntity
import az.vtb.msuser.model.CreateUserRequest
import az.vtb.msuser.model.DeleteUserRequest
import az.vtb.msuser.service.abstraction.UserService
import org.springframework.stereotype.Service

@Log
@Service
class UserServiceHandler(
    val userRepository: UserRepository,
    val accountClient: AccountClient
) : UserService {

    override fun createUser(request: CreateUserRequest) {
        userRepository.findByUsernameOrEmail(request.username, request.email)?.let {
            throw ConflictException(ALREADY_EXISTS_ERROR.message)
        } ?: run {
            val cashAccountId = accountClient.createAccount(request.toCreateAccountRequestDto())
            val user = request.toEntity(cashAccount = cashAccountId.accountNumber)
            userRepository.save(user)
        }
    }

    override fun deleteUser(deleteUserRequest: DeleteUserRequest) {
        userRepository.findByUsername(deleteUserRequest.username)?.let {
            userRepository.delete(it)
        } ?: throw NotFoundException(NOT_FOUND.message)
    }

    override fun getUserByUsername(username: String) =
        userRepository.findByUsername(username) ?: throw NotFoundException(NOT_FOUND.message)

    override fun getUserByEmail(email: String) =
        userRepository.findByEmail(email) ?: throw NotFoundException(NOT_FOUND.message)
}

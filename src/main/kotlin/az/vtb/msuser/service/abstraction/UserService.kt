package az.vtb.msuser.service.abstraction

import az.vtb.msuser.dao.UserEntity
import az.vtb.msuser.model.CreateUserRequest
import az.vtb.msuser.model.DeleteUserRequest

interface UserService {
    fun getUserByUsername(username: String): UserEntity?
    fun getUserByEmail(email: String): UserEntity?
    fun createUser(request: CreateUserRequest)
    fun deleteUser(deleteUserRequest: DeleteUserRequest)
}

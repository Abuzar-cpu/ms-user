package az.vtb.msuser.dao

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserEntity, String> {
    fun findByUsername(username: String): UserEntity?
    fun findByUsernameOrEmail(username: String, email: String): UserEntity?
    fun findByEmail(email: String): UserEntity?
}

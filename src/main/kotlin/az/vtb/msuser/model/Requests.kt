package az.vtb.msuser.model

data class CreateUserRequest(
    val username: String,
    val firstName: String,
    val lastName: String,
    val email: String
)

data class DeleteUserRequest (
    val username: String,
    val email: String,
)

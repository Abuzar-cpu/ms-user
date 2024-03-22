package az.vtb.msuser.exception

enum class ExceptionMessages(val message: String) {
    NOT_FOUND("User not found"),
    ALREADY_EXISTS_ERROR("User already exists"),
    UNEXPECTED_ERROR("Unexpected error occurred"),
    METHOD_NOT_ALLOWED_ERROR("Method not supported"),
    UNKNOWN_ERROR("Unknown error occurred"),
    BAD_REQUEST_ERROR("Request is not valid"),
}

package az.vtb.msuser.exception

class NotFoundException(message: String) : RuntimeException(message)
class ConflictException(message: String) : RuntimeException(message)
class CustomFeignException(override val message: String, val status: Int) : RuntimeException(message)

package az.vtb.msuser.exception

import az.vtb.msuser.exception.ExceptionMessages.METHOD_NOT_ALLOWED_ERROR
import az.vtb.msuser.exception.ExceptionMessages.UNEXPECTED_ERROR
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

data class ErrorResponse(var message: String)

@RestControllerAdvice
class ErrorHandler {

    companion object {
        private val log = KotlinLogging.logger("ErrorHandler")
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    fun handle(exception: Exception): ErrorResponse {
        log.error("Exception: {}", exception.stackTraceToString())
        return ErrorResponse(UNEXPECTED_ERROR.message)
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    @ResponseStatus(METHOD_NOT_ALLOWED)
    fun handle(methodNotSupportedException: HttpRequestMethodNotSupportedException): ErrorResponse {
        log.error("HttpRequestMethodNotSupportedException {}", methodNotSupportedException.stackTraceToString())
        return ErrorResponse(METHOD_NOT_ALLOWED_ERROR.message)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    @ResponseStatus(BAD_REQUEST)
    fun handle(httpMessageNotReadableException: HttpMessageNotReadableException): ErrorResponse {
        log.error("HttpMessageNotReadableException {}", httpMessageNotReadableException.stackTraceToString())
        return ErrorResponse(ExceptionMessages.BAD_REQUEST_ERROR.message)
    }

    @ExceptionHandler(IllegalStateException::class)
    @ResponseStatus(UNPROCESSABLE_ENTITY)
    fun handle(illegalStateException: IllegalStateException): ErrorResponse {
        log.error("IllegalStateException {}", illegalStateException.stackTraceToString())
        return ErrorResponse(illegalStateException.message!!)
    }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(NOT_FOUND)
    fun handle(notFoundException: NotFoundException): ErrorResponse {
        log.error("NotFoundException {}", notFoundException.stackTraceToString())
        return ErrorResponse(notFoundException.message!!)
    }

    @ExceptionHandler(ConflictException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun handle(conflictException: ConflictException): ErrorResponse {
        log.error("ConflictException {}", conflictException.stackTraceToString())
        return ErrorResponse(conflictException.message!!)
    }

}

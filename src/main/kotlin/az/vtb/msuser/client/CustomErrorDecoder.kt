package az.vtb.msuser.client

import az.vtb.msuser.exception.CustomFeignException
import az.vtb.msuser.exception.ExceptionMessages
import az.vtb.msuser.model.JSON_NODE_FIELD
import feign.Response
import feign.codec.ErrorDecoder
import io.swagger.v3.core.util.ObjectMapperFactory
import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class CustomErrorDecoder : ErrorDecoder {

    companion object {
        private val log = KotlinLogging.logger("CustomErrorDecoder")
    }

    override fun decode(methodKey: String?, response: Response?): Exception {
        val errorMessage = response?.body()?.asInputStream()?.use {
            val jsonNode = ObjectMapperFactory.createJson().readTree(it)
            jsonNode.get(JSON_NODE_FIELD).asText()
        } ?: ExceptionMessages.UNKNOWN_ERROR.message

        log.error("Error message: {} methodKey: {}", errorMessage, methodKey)
        return CustomFeignException(errorMessage, response?.status() ?: 500)
    }
}

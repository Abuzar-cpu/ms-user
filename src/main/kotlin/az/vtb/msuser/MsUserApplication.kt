package az.vtb.msuser

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class MsUserApplication

fun main(args: Array<String>) {
	runApplication<MsUserApplication>(*args)
}

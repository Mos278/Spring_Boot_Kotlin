package com.server.kotlinTest

import com.server.kotlinTest.Execption.BaseException
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@EntityScan("com.server.kotlinTest.Entity")
@SpringBootApplication
class KotlinTestApplication

fun main(args: Array<String>) {
	runApplication<KotlinTestApplication>(*args)

}

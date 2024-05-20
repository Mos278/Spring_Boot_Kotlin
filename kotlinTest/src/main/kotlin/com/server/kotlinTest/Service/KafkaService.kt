package com.server.kotlinTest.Service

import com.server.kotlinTest.Execption.BaseException
import com.server.kotlinTest.Execption.S_KafkaException
import com.server.kotlinTest.Model.EmailSender

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture
import kotlin.jvm.Throws

@Service
class KafkaService{


    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, EmailSender>


    companion object {
        private val logger: Logger = LogManager.getLogger(KafkaService::class.java)
    }

    @Throws(BaseException::class)
    fun sendMessage(content: EmailSender) {
        content.context ?: throw S_KafkaException.RequestSendMessageIsBadRequest()
        val future: CompletableFuture<SendResult<String, EmailSender>> =
            kafkaTemplate.send("Test1", content)

        future.whenComplete { result, throwable ->
            if (result != null) {
                logger.info("Message sent successfully with offset: ${result.recordMetadata.offset()}")
            } else {
                logger.error("Failed to send message: $throwable")
            }
        }
    }
}

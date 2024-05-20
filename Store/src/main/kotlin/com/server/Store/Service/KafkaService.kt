package com.server.Store.Service

import com.server.Store.Model.EmailSender
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service


@Service
class KafkaService {

    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, EmailSender>

    companion object {
        private val logger: Logger = LogManager.getLogger(KafkaService::class.java)
    }



    @KafkaListener(topics = arrayOf("Test1"), groupId = "myGroup")
    fun Receive(Content: EmailSender){
        logger.info("HI!")
        logger.info(Content.email);
        logger.info(Content.context)
    }

}
package com.server.kotlinTest.Config

import com.server.kotlinTest.Model.EmailSender
import org.apache.kafka.clients.producer.ProducerConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.support.serializer.JsonSerializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.serializer.JsonDeserializer
import java.util.*
import kotlin.collections.HashMap

@Configuration
class KafkaConfig {


    @Value("\${spring.kafka.bootstrap-servers}")
    private lateinit var server: String

    @Bean
    fun producerConfigs(): Map<String, Any> {
        val map = HashMap<String, Any>()

        map[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = server
        map[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        map[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java


        return map
    }

    @Bean
    fun kafkaEmailTemplate(): KafkaTemplate<String, EmailSender> {
        val factory = DefaultKafkaProducerFactory<String, EmailSender>(producerConfigs())
        return KafkaTemplate(factory)
    }
}
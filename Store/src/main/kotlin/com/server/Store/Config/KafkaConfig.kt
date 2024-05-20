package com.server.Store.Config

import com.server.Store.Model.EmailSender
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.serializer.JsonDeserializer



@Configuration
class KafkaConfig {


    @Value("\${spring.kafka.bootstrap-servers}")
    private lateinit var server: String

    @Bean
    fun ConsumerConfigs(): Map<String, Any> {
        val map: MutableMap<String, Any> = HashMap()

        map[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = server
        map[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] =
            StringDeserializer::class.java // Fix
        map[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] =
            JsonDeserializer::class.java // Fix
        map[ConsumerConfig.GROUP_ID_CONFIG] = "json"
        map[JsonDeserializer.TRUSTED_PACKAGES] = "*"
        map[JsonDeserializer.TYPE_MAPPINGS] = "com.server.kotlinTest.Model.EmailSender : com.server.Store.Model.EmailSender"

        return map
    }

    @Bean
    fun kafkaEmailTemplate(): KafkaTemplate<String, EmailSender> {
        val factory = DefaultKafkaProducerFactory<String, EmailSender>(ConsumerConfigs())
        return KafkaTemplate(factory)
    }

    @Bean
    fun consumerFactory(): ConsumerFactory<String, EmailSender> {
        return DefaultKafkaConsumerFactory(ConsumerConfigs(), StringDeserializer(), JsonDeserializer(EmailSender::class.java))
    }


    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, EmailSender> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, EmailSender>()
        factory.consumerFactory = consumerFactory()
        return factory
    }


}
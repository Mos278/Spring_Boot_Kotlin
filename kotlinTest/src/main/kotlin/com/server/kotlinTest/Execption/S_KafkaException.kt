package com.server.kotlinTest.Execption

class S_KafkaException(code : String) : BaseException("Kafka Exception :  $code"){

    companion object{
        fun RequestSendMessageIsBadRequest() : S_KafkaException{
            return S_KafkaException("Bad Request")
        }
    }
}
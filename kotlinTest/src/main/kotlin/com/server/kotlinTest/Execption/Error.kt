package com.oracle.server.Exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

import com.server.kotlinTest.Model.ErrorResponse

import com.server.kotlinTest.Execption.BaseException
import java.time.LocalDateTime

@ControllerAdvice
class Error {

    @ExceptionHandler(BaseException::class)
    fun handException(e: BaseException): ResponseEntity<ErrorResponse> {
        val errorResponse : ErrorResponse = ErrorResponse(e.message!!,e.status.value(), LocalDateTime.now())
        return ResponseEntity(errorResponse, e.status)
    }
}

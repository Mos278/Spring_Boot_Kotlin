package com.server.kotlinTest.Execption


import org.springframework.http.HttpStatus



open class BaseException(code: String ) : Exception(code) {

    var status : HttpStatus = HttpStatus.BAD_REQUEST//Default


    fun setStaus(status : HttpStatus): BaseException{
        this.status = status
        return this
    }




}
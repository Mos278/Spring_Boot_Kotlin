package com.server.kotlinTest.API.REST

import com.server.kotlinTest.API.Controller.TestAPIController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestAPI(private val con: TestAPIController) {

    @GetMapping("/test")
    fun test(): ResponseEntity<String> {
        return ResponseEntity.ok( con.Test());
    }
}

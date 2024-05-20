package com.server.kotlinTest.API.Controller

import org.springframework.stereotype.Controller

@Controller
class TestAPIController {

    public fun Test():String {
        return "Hello World";
    }
}
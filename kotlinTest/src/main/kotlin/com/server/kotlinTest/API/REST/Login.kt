package com.server.kotlinTest.API.REST

import com.server.kotlinTest.API.Controller.LoginController
import com.server.kotlinTest.Model.LoginUserRequest
import com.server.kotlinTest.Model.LoginUserResponse
import com.server.kotlinTest.Model.UserRequest
import com.server.kotlinTest.Model.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/Login")
class Login(private val con : LoginController) {

    @PostMapping("/User")
    fun CreateUserapi(@RequestBody request : LoginUserRequest?) : ResponseEntity<LoginUserResponse>{

        return ResponseEntity.ok().body(con.LoginUser(request))
    }
}
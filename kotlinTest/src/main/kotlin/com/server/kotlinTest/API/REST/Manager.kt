package com.server.kotlinTest.API.REST

import com.server.kotlinTest.API.Controller.ManageController
import com.server.kotlinTest.Model.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/Manage")
class Manager (private val con : ManageController ){

    @PostMapping("/DeleteUser")
    fun DeleteUser(@RequestBody request : LoginUserRequest): ResponseEntity<String>{
        return ResponseEntity.ok().body(con.DeleteUser(request))
    }

    @PostMapping("/CreateUser")
    fun CreateUserapi(@RequestBody request : UserRequest?) : ResponseEntity<UserResponse>{

        return ResponseEntity.ok().body(con.CreateUserapi(request))
    }

    @PostMapping("/UpdateStatusUser")
    fun UpdateStatusUser(@RequestBody request: UpdateStatusUserRequest) : ResponseEntity<UpdateStatusUserResponse>{
        return ResponseEntity.ok().body(con.UpdateStatus(request))
    }
}
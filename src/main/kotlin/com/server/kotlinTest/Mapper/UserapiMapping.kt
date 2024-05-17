package com.server.kotlinTest.Mapper

import com.server.kotlinTest.Entity.Userapi
import com.server.kotlinTest.Model.*
import org.mapstruct.Mapper
import org.mapstruct.Mappings

@Mapper(componentModel = "spring")
interface UserapiMapping {

    fun Userapi2Request(userapi : Userapi) : UserRequest

    fun Userapi2Response(userapi : Userapi) : UserResponse

    fun Userapi2LoginRequest(userapi: Userapi) : LoginUserRequest

    fun Userapi2LoginResponse(userapi: Userapi) : LoginUserResponse

    fun Userapi2UpdateStatusRequest(userapi: Userapi) : UpdateStatusUserRequest

    fun Userapi2UpdateStatusResponse(userapi: Userapi) : UpdateStatusUserResponse
}
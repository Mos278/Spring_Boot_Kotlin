package com.server.kotlinTest.API.Controller

import com.server.kotlinTest.Execption.BaseException
import com.server.kotlinTest.Execption.C_LoginException
import com.server.kotlinTest.Mapper.UserapiMapping
import com.server.kotlinTest.Model.LoginUserRequest
import com.server.kotlinTest.Model.LoginUserResponse
import com.server.kotlinTest.Service.UserapiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import kotlin.jvm.Throws

@Controller
class LoginController {
    @Autowired
    private lateinit var userapiService: UserapiService

    @Autowired
    private lateinit var usermapper : UserapiMapping



    @Throws(BaseException::class)
    fun LoginUser(request: LoginUserRequest?): LoginUserResponse {

        request?: throw C_LoginException.UserRequestIsNull()

        val username = request.username ?: throw C_LoginException.UsernameisNull()
        val userpassword = request.userpassword ?: throw C_LoginException.UserpasswordisNull()

        return usermapper.Userapi2LoginResponse(userapiService.Loginuser(username,userpassword))
    }
}
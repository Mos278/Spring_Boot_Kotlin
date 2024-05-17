package com.server.kotlinTest.API.Controller

import com.server.kotlinTest.Execption.BaseException
import com.server.kotlinTest.Execption.C_ManageException
import com.server.kotlinTest.Mapper.UserapiMapping
import com.server.kotlinTest.Model.*
import com.server.kotlinTest.Service.UserapiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.jvm.Throws

@Service
class ManageController {
    @Autowired
    private lateinit var userapiService : UserapiService

    @Autowired
    private lateinit var usermapper : UserapiMapping


    fun DeleteUser(request : LoginUserRequest?):String{
        request?: throw  C_ManageException.UserRequestIsNull()

        val username = request.username ?: throw C_ManageException.UsernameisNull()
        val userpassword = request.userpassword ?: throw C_ManageException.UserpasswordisNull()

        userapiService.DeleteUserapi(username,userpassword)
        return "Delete success"
    }


    @Throws(BaseException::class)
    fun CreateUserapi(request: UserRequest?): UserResponse {

        request?: throw  C_ManageException.UserRequestIsNull()

        val usercode = request.usercode ?: throw C_ManageException.UsercodeisNull()
        val username = request.username ?: throw C_ManageException.UsernameisNull()
        val userpassword = request.userpassword ?: throw C_ManageException.UserpasswordisNull()

        return usermapper.Userapi2Response(userapiService.CreateUserapi(usercode, username, userpassword))
    }


    @Throws(BaseException::class)
    fun  UpdateStatus(request : UpdateStatusUserRequest?) : UpdateStatusUserResponse{
        request?: throw C_ManageException.UserRequestIsNull()

        val username : String = request.username ?: throw C_ManageException.UsernameisNull()
        val userpassword : String= request.userpassword ?: throw C_ManageException.UserpasswordisNull()
        val usetatus : Boolean = request.usestatus ?: throw  C_ManageException.UserstatusIsNull()
        
        return usermapper.Userapi2UpdateStatusResponse(userapiService.UpdateUser_usestatus(username,userpassword,usetatus))

    }
}
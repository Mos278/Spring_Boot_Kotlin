package com.server.kotlinTest.Service

import com.server.kotlinTest.Entity.Userapi
import com.server.kotlinTest.Execption.BaseException
import com.server.kotlinTest.Execption.S_UserapiException
import com.server.kotlinTest.Repository.UserapiRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.jvm.Throws
import org.springframework.security.crypto.password.PasswordEncoder



@Service

class UserapiService{


    @Autowired
    private lateinit var repository: UserapiRepository


    @Autowired
    private  lateinit var passwordEncoder: PasswordEncoder



    private fun PasswordMatching( RawPassword : String , EncodePassword: String) :Boolean{
        return  passwordEncoder.matches(RawPassword,EncodePassword)
    }

    @Throws(BaseException::class)
    fun CreateUserapi(_usercode:String , _username : String , _userpassword : String ,_email : String) : Userapi {

        // Validate
        if (repository.getUserapiByusercode(_usercode) != null) {
            throw S_UserapiException.CreateUserDuplicate()
        }

        if (repository.getUserapiByusername(_username) != null) {
            throw S_UserapiException.CreateUserDuplicate()
        }


        //Create-Save
        var User : Userapi = Userapi()
        User.usercode = _usercode
        User.username = _username
        User.usestatus = true
        User.userpassword = passwordEncoder.encode(_userpassword)
        User.email = _email

        repository.save(User)

        return  User
    }

    @Throws(BaseException::class)
    fun DeleteUserapi(_username: String , _userpassword: String){
        repository.DeleteUserapiBycode( Loginuser(_username,_userpassword).code!!)
    }

    @Throws(BaseException::class)
        fun Loginuser(_username: String , _userpassword: String):Userapi {
        // Validate
        var userapi: Userapi? = repository.getUserapiByusername(_username)

        userapi ?: throw S_UserapiException.UserNotFound()

        if(PasswordMatching(_userpassword,userapi.userpassword!!)){
            throw S_UserapiException.PasswordInvaild()
        }

        return userapi
    }


    @Throws(BaseException::class)
    fun  UpdateUser_usestatus(_username: String , _userpassword: String , _newStatus : Boolean): Userapi {
        var user : Userapi = Loginuser(_username,_userpassword)
        user.usestatus = _newStatus
        repository.save(user)
        return user
    }

}
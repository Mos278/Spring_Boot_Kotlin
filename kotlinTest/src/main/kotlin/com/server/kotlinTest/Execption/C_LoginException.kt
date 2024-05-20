package com.server.kotlinTest.Execption


class C_LoginException(code : String) : BaseException("Create Controller Exception : $code") {
    companion object{



        fun UsernameisNull() : C_LoginException{
            return C_LoginException("Username is Null")
        }

        fun UserpasswordisNull() : C_LoginException{
            return C_LoginException("Userpassword is Null")
        }

        fun UsercodeisNull() : C_LoginException{
            return C_LoginException("Usercode is Null")
        }


        fun UserRequestIsNull() : C_LoginException{
            return C_LoginException("request is Null")
        }


    }
}
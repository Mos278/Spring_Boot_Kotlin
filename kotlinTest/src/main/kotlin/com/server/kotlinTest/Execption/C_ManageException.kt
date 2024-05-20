package com.server.kotlinTest.Execption

class C_ManageException(code : String) :BaseException("Manage Controller Exception : $code"){

    companion object{
        fun UsernameisNull() : C_ManageException{
            return C_ManageException("Username is Null")
        }

        fun UserpasswordisNull() : C_ManageException{
            return C_ManageException("Userpassword is Null")
        }


        fun UserRequestIsNull() : C_ManageException{
            return C_ManageException("request is Null")
        }

        fun UserstatusIsNull() : C_ManageException{
            return C_ManageException("Userstatus is null")
        }

        fun UsercodeisNull() : C_ManageException{
            return C_ManageException("Usercode is null")
        }

        fun UseremailisNull() : C_ManageException{
            return C_ManageException("Useremail is null")
        }
    }
}
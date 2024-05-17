package com.server.kotlinTest.Execption

class S_UserapiException(code : String): BaseException("Userapi Service exception : $code") {
    //TODO : where detail
    companion object{
        fun SourceisNull() : S_UserapiException{
            return S_UserapiException("Bad")
        }

        fun UserNotFound() : S_UserapiException{
            return S_UserapiException("User Not Found")
        }

        fun CreateUserDuplicate() : S_UserapiException{
            return S_UserapiException("Create User Duplicate")
        }

        fun PasswordInvaild() : S_UserapiException{
            return S_UserapiException("Password invaild")
        }







    }
}
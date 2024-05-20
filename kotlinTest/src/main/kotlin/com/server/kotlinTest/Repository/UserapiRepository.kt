package com.server.kotlinTest.Repository

import com.server.kotlinTest.Entity.Userapi
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Repository
interface UserapiRepository : JpaRepository<Userapi,Long> {

    @Query(nativeQuery = true , value = "SELECT * FROM userapi WHERE usercode = :usercode ")
    fun getUserapiByusercode(@Param("usercode") usercode : String):Userapi?

    @Query(nativeQuery = true , value = "SELECT * FROM userapi WHERE username = :username ")
    fun getUserapiByusername(@Param("username") username : String):Userapi?

    @Modifying
    @Transactional
    @Query(nativeQuery = true , value = "DELETE  FROM userapi WHERE code = :code")
    fun DeleteUserapiBycode(@Param("code") code : Long)
}
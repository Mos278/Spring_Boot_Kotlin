
package com.server.kotlinTest.Entity

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity(name = "userapi")

open class Userapi :BaseEntity(){

    @Column(name = "usercode" , nullable =  false , unique = true)
    open var usercode : String? = null

    @Column(name = "username" , nullable =  false , unique = true)
    open  var username : String? = null

    @Column(name = "userpassword" , nullable =  false , unique = false)
    open var userpassword : String? = null

    @Column(name = "UseStatus" , nullable =  false )
    open  var usestatus : Boolean? = null

}
//TODO : use liquesBase
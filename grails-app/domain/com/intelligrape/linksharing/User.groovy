package com.intelligrape.linksharing

class User {
    String email
    static constraints = {
        email(unique:true)

    }
}

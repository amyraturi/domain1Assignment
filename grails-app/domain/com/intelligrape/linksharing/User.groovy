package com.intelligrape.linksharing

import java.sql.Blob


class User {
    String email
    String password
    String firstName
    String lastName
    Blob photo
    Boolean admin
    Boolean active
    Date dateCreated
    Date lastUpdated
    static transients=['userName']
  String  getUserName(){

     return  [this.firstName,this.lastName].findAll{it}.join('')
    }
    static hasMany =[topics:Topics,subscriptions:Subscription,readingItems:ReadingItem,resources:Resource]


    static constraints = {
        email(unique:true,null:false,blank: false,email: true)
        password(blank: false,size: 5..15)
        firstName(blank: false)
        lastName(blank: false)
        photo(nullable: true)
        admin(nullable: true)
        active(nullable: true)
    }



}

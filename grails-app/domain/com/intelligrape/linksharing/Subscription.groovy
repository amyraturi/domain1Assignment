package com.intelligrape.linksharing

class Subscription {
    Topics topics
    static belongsTo=[user:User]
    Date dateCreated
  //  static belongsTo = [user:User]

    static constraints = {
        topics(unique: true)

    }

}

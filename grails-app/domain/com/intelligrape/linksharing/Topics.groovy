package com.intelligrape.linksharing
class Topics {
    String topicName
    User createdBy
    Visibility visibility
    static hasMany =[subscriptions:Subscription,resources:Resource]
    static constraints = {

        createdBy(unique: true)

    }
}

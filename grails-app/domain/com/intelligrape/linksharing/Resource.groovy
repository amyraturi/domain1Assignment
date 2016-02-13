package com.intelligrape.linksharing

abstract class Resource {
    User createdBy
    String description
    Topics topic
    Date dateCreated
    Date lastUpdated
    static hasMany =[ratings:ResourceRating,readingItems:ReadingItem]

    static constraints = {
        description(type: 'text')
    }
}

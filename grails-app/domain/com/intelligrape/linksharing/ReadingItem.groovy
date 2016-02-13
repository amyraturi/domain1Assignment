package com.intelligrape.linksharing

class ReadingItem {
    Resource resource
    User user
    Boolean isRead

    static constraints = {
        user(null:false)
        resource(null:false)
        isRead(null:false)
    }
}

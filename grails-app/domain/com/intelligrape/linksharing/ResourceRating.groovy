package com.intelligrape.linksharing

class ResourceRating {
    Resource resource
    User user
    Integer score

    static constraints = {
        score min: 1, max: 5
        user(unique: true)
    }


}

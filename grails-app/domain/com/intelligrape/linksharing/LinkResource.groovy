package com.intelligrape.linksharing

/**
 * Created by amit on 12/2/16.
 */
class LinkResource extends Resource {
    String url
    static belongsTo=[resource:Resource]
    LinkResource()
    {

    }
}

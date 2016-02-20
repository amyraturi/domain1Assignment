import com.intelligrape.linksharing.DocumentResource
import com.intelligrape.linksharing.LinkResource
import com.intelligrape.linksharing.ReadingItem
import com.intelligrape.linksharing.Resource
import com.intelligrape.linksharing.ResourceRating
import com.intelligrape.linksharing.Seriousness
import com.intelligrape.linksharing.Subscription
import com.intelligrape.linksharing.Topic
import com.intelligrape.linksharing.User
import com.intelligrape.linksharing.Visibility

class BootStrap {
    def grailsApplication
    def init = {

        User user = new User()
        user.createUser()
        createTopics()
        createResources()
        subscribeTopics()
        createReadingItems()
        createResourceRatings()
    }



    void createTopics() {

        User creater
        Topic topic
        if (!Topic.count) {
        User.getAll().each {
            creater=it
            5.times {
                topic=new Topic(topicName: "Topic ${it+1}", createdBy: creater, visibility: Visibility.PRIVIATE)
                      if( ! topic.save()) {
                          log.error(topic.errors)
                      }

            }
        }


        }

    }

    void createResources()
    {
        Resource linkResource
        Resource documentResource
      Topic topic
        if(!Resource.getAll()) {
            Topic.getAll().each
                    {
                        topic=it
                        2.times {
                            linkResource = new LinkResource(topic: topic, createdBy: topic.createdBy, description: "description ${topic.topicName} LinkResource${it}", url: "www.url.com")
                            documentResource = new DocumentResource(topic: topic, createdBy: topic.createdBy, description: "description ${topic.topicName} documentResource ${it}", filePaths: "c:/filepath/abc${it}.txt")
                         if(!linkResource.save())
                         {
                             log.error(linkResource.errors)
                         }
                         if (!documentResource.save())
                         {
                             documentResource.errors
                         }
                        }
                    }
            }
        }

    void subscribeTopics()
    {
        Subscription subscription
        Topic topic
            Topic.getAll().each {
                topic=it
                User.getAll().each {
                    if (topic.createdBy != it) {
                       if( !Subscription.findAllByTopicAndUser(topic,it)) {
                           subscription = new Subscription(topic: topic, user: it, seriousness: Seriousness.CASUAL)
                           if (!subscription.save()) {
                               log.info(subscription.errors)
                           }
                       }
                    }
                }
            }




    }

    void  createReadingItems(){
        ReadingItem readingItem
        //
        Resource resource
        Subscription.getAll().each{
           resource= Resource.findByTopic(it.topic)
                if((resource.createdBy!=it.user)&&(!ReadingItem.findByUserAndResource(it.user,resource))){
                    readingItem = new ReadingItem(user: it.user, resource: resource, isRead:false)
                    if(!readingItem.save())
                    {
                        log.error(readingItem.errors)
                    }


                }

        }


    }

    void createResourceRatings()
    {
        ResourceRating rating


        ReadingItem.getAll().each{
            if(!it.isRead)
            {

           rating= new ResourceRating(createdBy:it.user,resource:it.resource,score:1  )
                if(!rating.save())
                {
                    log.error(rating.errors)
                }
            }

        }

    }

        def destroy = {
        }
    }

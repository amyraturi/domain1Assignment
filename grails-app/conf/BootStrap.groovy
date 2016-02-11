class BootStrap {
def grailsApplication
    def init = {
//please include LinkSharing-config.groovy file in .grails directory so that you will able to see the changes
        println "Myname is="+grailsApplication.config.myname


    }
    def destroy = {
    }
}

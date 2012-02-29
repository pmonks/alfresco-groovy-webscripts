package org.alfresco.example.groovy;

import org.alfresco.extension.webscripts.groovy.GroovyDeclarativeWebScript;
import org.alfresco.web.scripts.Cache;
import org.alfresco.web.scripts.Status;
import org.alfresco.web.scripts.WebScriptRequest;


class HelloWorldGroovyWebScript
    implements GroovyDeclarativeWebScript
{
    def serviceRegistry = null;


    Map<String, Object> execute(WebScriptRequest request, Status status, Cache cache)
    {
        def result = [greeting:"Hello Groovy world!"]

        return(result);
    }

}

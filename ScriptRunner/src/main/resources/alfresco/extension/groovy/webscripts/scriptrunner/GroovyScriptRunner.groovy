package alfresco.extension.groovy.scriptrunner

import groovy.lang.Binding
import groovy.lang.GroovyShell

import net.sf.json.*

import org.springframework.extensions.webscripts.WebScriptRequest
import org.springframework.extensions.webscripts.Status
import org.springframework.extensions.webscripts.Cache

import org.alfresco.extension.webscripts.groovy.GroovyDeclarativeWebScript


public class GroovyScriptRunner
    implements GroovyDeclarativeWebScript
{
    def serviceRegistry


    public Map<String, Object> execute(WebScriptRequest request, Status status, Cache cache)
    {
        def script = request.getParameter("script")
        def result

        if (script)
        {
            def binding      = new Binding([serviceRegistry:serviceRegistry])
            def scriptOutput = new GroovyShell(this.getClass().getClassLoader(), binding).evaluate(script)

            if (request.getFormat() == "json")
            {
                def json = JSONSerializer.toJSON(scriptOutput).toString()
                result = [json:json]
            }
            else
            {
                result = [scriptOutput:scriptOutput]
            }
        }

        return(result)
    }

}

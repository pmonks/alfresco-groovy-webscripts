/*
 * Copyright (C) 2007-2013 Peter Monks.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * This file is part of an unsupported extension to Alfresco.
 *
 */

package alfresco.extension.groovy.scriptrunner

import groovy.lang.Binding
import groovy.lang.GroovyShell

import net.sf.json.*

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.extensions.webscripts.WebScriptRequest
import org.springframework.extensions.webscripts.Status
import org.springframework.extensions.webscripts.Cache

import org.alfresco.extension.webscripts.groovy.GroovyDeclarativeWebScript


public class GroovyScriptRunner
    implements GroovyDeclarativeWebScript,
               ApplicationContextAware
{
    private def applicationContext
    private def serviceRegistry

    public void setApplicationContext(ApplicationContext applicationContext)
    {
        this.applicationContext = applicationContext
        this.serviceRegistry    = applicationContext.getBean("ServiceRegistry")
    }

    public Map<String, Object> execute(WebScriptRequest request, Status status, Cache cache)
    {
        def script = request.getParameter("script")
        def result

        if (script)
        {
            def binding      = new Binding([serviceRegistry:serviceRegistry,
                                            applicationContext:applicationContext])
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

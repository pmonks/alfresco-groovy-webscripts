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

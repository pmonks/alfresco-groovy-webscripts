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

package alfresco.extension.groovy.cmisquery

import org.springframework.extensions.webscripts.WebScriptRequest
import org.springframework.extensions.webscripts.Status
import org.springframework.extensions.webscripts.Cache

import org.alfresco.service.*
import org.alfresco.service.cmr.repository.*
import org.alfresco.service.cmr.search.*
import org.alfresco.cmis.*

import org.alfresco.extension.webscripts.groovy.GroovyDeclarativeWebScript


public class CMISQuery
    implements GroovyDeclarativeWebScript
{
    private def serviceRegistry
    private def cmisQueryService

    public void setServiceRegistry(final ServiceRegistry serviceRegistry)
    {
        this.serviceRegistry  = serviceRegistry
        this.cmisQueryService = serviceRegistry.getCMISQueryService()
    }

    public Map<String, Object> execute(final WebScriptRequest request, final Status status, final Cache cache)
    {
        def result
        def cmisQuery        = request.getParameter("cmisQuery")
        def cmisQueryOptions = new CMISQueryOptions(cmisQuery, StoreRef.STORE_REF_WORKSPACE_SPACESSTORE)

        cmisQueryOptions.setQueryMode(CMISQueryOptions.CMISQueryMode.CMS_WITH_ALFRESCO_EXTENSIONS) // WTF isn't this in the constructor??

        def cmisResults = cmisQueryService.query(cmisQueryOptions)
        def rowCount    = cmisResults.getLength()
        def columns     = cmisResults.getMetaData().getColumnNames()

        result = [ rowCount : rowCount,
                   columns  : columns,
                   rows     : cmisResults.iterator() ]
        return(result);
    }
}

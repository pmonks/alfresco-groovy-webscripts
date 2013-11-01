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
    private def searchService

    public void setServiceRegistry(final ServiceRegistry serviceRegistry)
    {
        this.serviceRegistry = serviceRegistry
        this.searchService   = serviceRegistry.getSearchService()
    }

    public Map<String, Object> execute(final WebScriptRequest request, final Status status, final Cache cache)
    {
        def result
        def cmisQuery   = request.getParameter("cmisQuery")
        def cmisResults = (CMISResultSet)searchService.query(StoreRef.STORE_REF_WORKSPACE_SPACESSTORE , SearchService.LANGUAGE_CMIS_ALFRESCO, cmisQuery)
        def numResults  = cmisResults.getLength()
        def columnNames = cmisResults.getMetaData().getColumnNames()

        result = [ numResults  : numResults,
                   columnNames : columnNames,
                   cmisResults : cmisResults ]
        return(result);
    }

}

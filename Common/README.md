## Description
This module provides some simple "glue" code that simplifies the development of Groovy backed Web Scripts.

## Author
Peter Monks (pmonks@alfresco.com)

## Pre-requisites
* Alfresco (Labs or Enterprise) v3.3 or greater.

## Installation
1. Compile and package an AMP file for this project using the provided Maven2 build script. ```mvn clean package```
2. Install the AMP using the Module Management Tool.

## Usage
To develop a Groovy backed Web Script, develop a Groovy class that implements the ```org.alfresco.extension.webscripts.groovy.GroovyDeclarativeWebScript``` Java interface, store it somewhere in the Alfresco classpath (suggested location is ```${TOMCAT_HOME}/shared/classes/alfresco/extension/groovy/webscripts``) then wire it up in a custom Spring application context file as follows:

```xml
  <?xml version='1.0' encoding='UTF-8'?>
  <beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns:lang="http://www.springframework.org/schema/lang"
         xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd http://www.springframework.org/schema/lang http://www.springframework.org/schema/lang/spring-lang-2.0.xsd">

    <lang:groovy id="groovy.webscript.myGroovyWebScript"
                 refresh-check-delay="5000"
                 script-source="classpath:alfresco/extension/groovy/webscripts/MyGroovyWebScript.groovy">   <!-- Location of the Groovy script in the classpath -->
<!-- Inject any other services required by your Groovy code; for example to inject the Alfresco ServiceRegistry:
      <lang:property name="serviceRegistry" ref="ServiceRegistry" />
-->
    </lang:groovy>

    <!-- See http://wiki.alfresco.com/wiki/Web_Scripts#Spring_Bean_Declaration -->
    <bean id="webscript.<packageId>.<serviceId>.<httpMethod>"   
          class="org.alfresco.extension.webscripts.groovy.GroovyDelegatingWebScript"
          parent="webscript">
      <constructor-arg index="0" ref="groovy.webscript.myGroovyWebScript" />
    </bean>

  </beans>
```

Implement a Web Script descriptor and response template(s) just as you would for a Java backed Web Script (see http://wiki.alfresco.com/wiki/Web_Scripts#Java-Backed_Implementations for details).

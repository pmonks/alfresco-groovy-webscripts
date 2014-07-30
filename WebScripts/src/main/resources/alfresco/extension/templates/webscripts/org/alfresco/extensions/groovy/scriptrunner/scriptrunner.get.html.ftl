[#ftl]
<html>
<head>
<title>Alfresco Groovy Shell</title>
<link rel="stylesheet" href="/alfresco/css/main.css" type="text/css"/>
</head>
<body>
<div style="display:block;width:100%">
  <div style="float:left;width:60%;height:50%">
    <h2>Groovy script:</h2>
    <form method="POST" action="${url.service}.json" target="results">
      <textarea style="width: 70%; height: 70%;" name="script"></textarea>
      <br/>
      <button type="submit"><span style="font-size:150%;font-weight:bold">&nbsp;&nbsp;&nbsp;&nbsp;Go!&nbsp;&nbsp;&nbsp;&nbsp;</button>
    </form>
  </div>
  <div style="float:right;width:40%;height:50%">
    <h2>Notes:</h2>
    <ul>
      <li>The Alfresco <a target="_blank" href="http://dev.alfresco.com/resource/docs/java/repository/org/alfresco/service/ServiceRegistry.html">ServiceRegistry</a> is available via a variable called "serviceRegistry".</li>
      <li>Alfresco's <a target="_blank" href="http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/beans.html">Spring application context</a> is available via a variable called "applicationContext".  <span style="color:red">Be very careful using this object, as incorrect use can damage your Alfresco installation or repository!</span></li>
      <li>A new interpreter is used for each submission - state is <strong>not</strong> retained across multiple submissions.</li>
      <li>The script will run in a single Alfresco transaction, so care must be taken if lengthy processing is undertaken by the Groovy script.</li>
    </ul>
  </div>
</div>
<div style="display:block;width:100%;height:60%">
  <h2>Results:</h2>
  <iframe style="width:99%;height:55%" name="results" src=""></iframe>
</div>
</body>
</html>

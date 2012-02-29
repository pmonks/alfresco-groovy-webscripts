[#ftl]
<html>
<head>
<title>Alfresco Groovy Shell</title>
<link rel="stylesheet" href="/alfresco/css/main.css" type="text/css"/>
</head>
<body>
<div style="float:left;width:60%;height:50%">
  Type your Groovy script here:<br/>
  <form method="POST" action="${url.service}.json" target="results">
    <textarea cols="160" rows="25" name="script"></textarea>
    <br/>
    <input type="submit" value="Go!"/>
  </form>
</div>
<div style="float:right;width:40%;height:50%">
  <br/>
  Notes:
  <ul>
    <li>The Alfresco <a target="_blank" href="http://dev.alfresco.com/resource/docs/java/repository/org/alfresco/service/ServiceRegistry.html">ServiceRegistry</a> is available via a variable called "serviceRegistry".</li>
    <li>A new interpreter is used for each submission - state is <strong>not</strong> retained across multiple submissions.</li>
    <li>The script will run in a single Alfresco transaction, so care must be taken if lengthy processing is undertaken by the Groovy script.</li>
  </ul>
</div>
<div style="width:100%;height:300px">
  Results:</br/>
  <iframe style="width:80%;height:300px" name="results" src=""></iframe>
</div>
</body>
</html>

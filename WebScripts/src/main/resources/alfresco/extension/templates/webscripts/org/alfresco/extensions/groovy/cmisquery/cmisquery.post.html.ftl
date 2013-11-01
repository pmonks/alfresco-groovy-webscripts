[#ftl]
<!doctype html>
<html>
<head>
<title>Alfresco CMIS Query Tool</title>
<link rel="stylesheet" href="/alfresco/css/main.css" type="text/css"/>
</head>
<body>
[#if numResults?? && columnNames?? && cmisResults??]
<p>Query returned ${numResults} rows.</p>
<table>
  <tr>
  [#list columnsNames as columnName]
    <th>${columnName}</th>
  [/#list]
  </tr>
  [#list cmisResults as result]
  <tr>
    [#list result as columnValue]
    <td>${columnValue}</td>
    [/#list]
  </tr>
  [/#list]
</table>
[#else]
  <p>No results.</p>
[/#if]
</body>
</html>

[#ftl]
<!doctype html>
<html>
<head>
<title>Alfresco CMIS Query Tool</title>
<link rel="stylesheet" href="/alfresco/css/main.css" type="text/css"/>
</head>
<body>
[#if rowCount?? && columns?? && rows??]
<p>Query returned ${rowCount} rows.</p>
<table border="1" cellspacing="0">
  <tr>
  [#list columns as column]
    <th>${column!"<i>(null)</i>"}</th>
  [/#list]
  </tr>
  [#list rows as row]
  <tr>
    [#list columns as column]
      [#if row.getValue(column)??]
        [#assign columnValue = row.getValue(column)]
        [#if columnValue?is_date]
    <td>${columnValue?datetime?string}</td>
        [#elseif columnValue?is_number]
    <td>${columnValue?c}</td>
        [#else]
    <td>${columnValue?string}</td>
        [/#if]
      [#else]
    <td><i>(null)</i></td>
      [/#if]
    [/#list]
  </tr>
  [/#list]
</table>
[#else]
  <p>No results.</p>
[/#if]
</body>
</html>

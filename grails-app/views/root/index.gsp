<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta content="main" name="layout"/>
  <title>${title}</title>
</head>
<body>
           <h1>${title}</h1>
<blockquote>${text}</blockquote>

<g:if test="${canMove}">
<h2>
    <g:link controller="root" action="next">
        <g:message code="chapter.moveNext"/>
    </g:link>
</h2>
</g:if>

</body>
</html>
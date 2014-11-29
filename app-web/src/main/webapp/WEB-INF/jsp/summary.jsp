<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Tell the JSP Page that please do not ignore Expression Language -->
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<body>

<style type="text/css">
    TABLE {

        border-collapse: collapse;
    }
    TD, TH {
        padding: 3px;
        border: 1px solid black;
    }
    TH {
        background: #b0e0e6;
    }
</style>

<form action="/filterSummary" method="post">

    <label path="date_from:">journey date: [yyyy-MM-dd]</label>
    <input type="date" required name="dateFrom"
    pattern = "(19|20)\d\d-((0[1-9]|1[012])-(0[1-9]|[12]\d)|(0[13-9]|1[012])-30|(0[13578]|1[02])-31)">

    <label path="date_to:">journey date: [yyyy-MM-dd]</label>
    <input type="date" required name="dateTo"
     pattern = "(19|20)\d\d-((0[1-9]|1[012])-(0[1-9]|[12]\d)|(0[13-9]|1[012])-30|(0[13578]|1[02])-31)">

    <input type="submit" name="filter">
</form>

<p>
    <form action="/AllSummaries" method="post">
    <label path="show_all_summaries">show all summaries</label><input type="submit" name="Summit"></form>
</p>

<form:form method="get" modelAttribute="summaries">
<h1><spring:message code="summary.list" /> ${summaryDateRangeMessage} </h1>
<ul>
    <table width=600px>
        <th>
            <td>automobileId</td>
            <td>make</td>
            <td>number</td>
            <td>fuelRate</td>
            <td>sum distance</td>
            <td>sum fuel</td>
        </th>
    <c:forEach items="${summaries}" var="summary">
        <tr>
            <td/>
            <td>${summary.automobile.id}</td>
            <td>${summary.automobile.make}</td>
            <td>${summary.automobile.number}</td>
            <td>${summary.automobile.fuelRate}</td>
            <td>${summary.sumDistance}</td>
            <td>${summary.sumFuel}</td>
        </tr>
    </c:forEach>
    </table>
</ul>
</form:form>
<a href='<spring:url value="/dataList" />'> <spring:message code="data.list" /></a>

</body>
</html>
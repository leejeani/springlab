<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>

</style>

<script>


</script>
<!-- Begin Page Content -->
<div class="col-sm-8  text-left ">
        <div class="container">
                <div class="row content">
                        <div class="col-sm-8  text-left ">
                             <h1>Test</h1>
                                <c:set value="0" var="cnt"></c:set>
                                <c:forEach var="mm" begin="${start}" end="${end}">
                                        <c:set var="num" value="${cnt = cnt+1}"/>
                                        <c:set var="fname" value="data${num}" />

                                        <c:forEach var="c" items="${requestScope[fname]}">
                                                <span>${c.id}</span> <span>${c.name}</span>
                                        </c:forEach>
                                        <br>

                                </c:forEach>
<%--                                <c:set value="0" var="cnt"></c:set>--%>
<%--                                <c:forEach var="mm" begin="${start}" end="${end}">--%>
<%--                                  <p><c:out value="${mm}"/></p>--%>
<%--                                        <c:set var="num" value="${cnt = cnt+1}"/>--%>
<%--                                        <c:set var="d" value="data${cnt}"/>--%>
<%--                                        <c:out value="${num}"/>--%>
<%--                                        <c:out value="${d}"/>--%>
<%--                                        <c:forEach var="c" items="${d+''}">--%>
<%--                                                <h4>${c.name}</h4>--%>
<%--                                        </c:forEach>--%>
<%--                                </c:forEach>--%>
                        </div>

                </div>
        </div>
</div>
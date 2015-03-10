<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:choose>
	<c:when test="${account eq null}">
		<p>
			You Don't have an Account yet -> <a
				href='<spring:url value="/account/create.html"></spring:url>'>create
				one</a>
		</p>
	</c:when>

	<c:otherwise>
		<p>Account Details for ->
			${pageContext.request.userPrincipal.name}</p>
		<p>Account Number : ${account.accountNumber}</p>
	</c:otherwise>
</c:choose>

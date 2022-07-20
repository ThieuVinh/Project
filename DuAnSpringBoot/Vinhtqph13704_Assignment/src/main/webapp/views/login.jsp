<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container mt-3">
	<c:if test="${ !empty sessionScope.error }">
		<div class="alert alert-danger">${ sessionScope.error }</div>
		<c:remove var="error" scope="session" />
	</c:if>

	<form:form method="POST" action="/Vinhtqph13704_Assignment/login/loginHome" modelAttribute="login">
		<div class="container">
			<div class="md-form md-outline">
				<i class="fas fa-user prefix deep-orange-text"></i> <label
					class="bg-white deep-purple-text rounded px-2 ml-5"><b>Username</b></label>
				<form:input class="form-control border-dark" path="username" />
				<span class="badge bg-danger"><form:errors path="username"></form:errors></span>
			</div>
			<div class="md-form md-outline mt-3">
				<i class="fas fa-lock prefix deep-orange-text"></i> <label
					class="bg-white deep-purple-text rounded px-2 ml-5"><b>Password</b></label>
				<form:input class="form-control border-dark" type="password" path="password" />
				<span class="badge bg-danger"><form:errors path="password"></form:errors></span>
			</div>
			<div class="text-center mt-4 mb-5">
					<button class="btn btn-rounded text-white"
					style="background-color: rgb(51, 95, 93);">Login</button>
			</div>
		</div>
	</form:form>
</div>
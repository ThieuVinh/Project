<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="container">
	<div>
		<h1 class="text-center mt-2" style="font-family: Courier New">
			<b>Điền thông tin đơn hàng</b>
		</h1>
	</div>
	<form:form method="POST"
		action="/Vinhtqph13704_Assignment/order/create/${ product.id }"
		modelAttribute="order">
		<div class="row">
			<div class="offset-2 col-6"> 
				<div class="md-form md-outline mt-3 col-5">
					<label class="bg-white deep-purple-text rounded px-2 ml-5"><b>Quatity</b></label>
					<form:input class="form-control border-dark" path="quatity" />
					<span class="badge bg-danger"><form:errors path="quatity"></form:errors></span>
				</div>
	
				<div class="md-form md-outline mt-3 col-5">
					<label class="bg-white deep-purple-text rounded px-2 ml-5"><b>Address</b></label>
					<form:input class="form-control border-dark" path="address" />
					<span class="badge bg-danger"><form:errors path="address"></form:errors></span>
				</div>
			</div>
			
			<div class="col-4">
				<img src="/Vinhtqph13704_Assignment/imageProduct/${product.image}" width="300">
			</div>
		</div>

		<div>
			<button class="btn btn-success mt-2"
				style="margin-left: 500px">Xác nhận</button>
		</div>
	</form:form>
</div>
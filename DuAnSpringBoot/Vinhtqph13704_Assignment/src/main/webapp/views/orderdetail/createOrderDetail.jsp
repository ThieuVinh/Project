<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="container mt-3">
	<div>
		<c:if test="${ !empty message }">
			<div class="alert alert-success" role="alert">${ message }</div>
			<c:remove var="message" scope="session" />
		</c:if>
	</div>
	<div>
		<c:if test="${ !empty error }">
			<div class="alert alert-danger" role="alert">${ error }</div>
			<c:remove var="error" scope="session" />
		</c:if>
	</div>

	<div class="container">
		<h1 class="text-center mt-2" style="font-family: Courier New">
			<b>Đơn hàng</b>
		</h1>
		<table class="table table-bordered">
			<thead class="table-dark">
				<tr class="align-middle text-center">
					<th>STT</th>
					<th>Name</th>
					<th>Image</th>
					<th>Quatity</th>
					<th>Address</th>
					<th>Create date</th>
					<th>Price</th>
					<th>Sum</th>
					<th colspan="2">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${listOderDe}">
					<c:set var="stt" value="${ stt + 1 }"></c:set>
					<tr class="align-middle text-center">
						<td>${ stt }</td>
						<td>${item.product.name}</td>
						<td><img
							src="/Vinhtqph13704_Assignment/imageProduct/${item.product.image}"
							width="100px"></td>
						<td>
							<form:form action="/Vinhtqph13704_Assignment/order/update/${ item.id }" method="POST" modelAttribute="order">
								<form:input path="quatity" value="${ item.quatity }" />
								<form:errors path="quatity" class="badge text-bg-danger"></form:errors>
								<button class="btn btn-success">Cập nhật</button>
							</form:form>
						</td>
						<td>${ item.order.address }</td>
						<td>${ item.order.createdDate }</td>
						<td>${ item.product.price } VNĐ</td>
						<td>${ item.quatity * item.product.price } VNĐ</td>
						
						<td>
							<button type="button" class="btn btn-danger"
								data-bs-toggle="modal"
								data-bs-target="#exampleModal${ item.id }">Xóa</button>
							<div class="modal fade" id="exampleModal${ item.id }"
								tabindex="-1" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">Bạn có muốn xóa không ?</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-bs-dismiss="modal">Close</button>
											<a class="btn btn-danger"
												href="/Vinhtqph13704_Assignment/order/delete/${ item.id }">Delete</a>
										</div>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>Total:</th>
					<th colspan="4">${ tongTien } VNĐ</th>
				</tr>
			</tfoot>
		</table>
	</div>

</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

	<div class="container">
		<c:if test="${ !empty sessionScope.message }">
			<div class="alert alert-success">
				${ sessionScope.message }
			</div>
			<c:remove var="message" scope="session"/>
		</c:if>
		<c:if test="${ !empty sessionScope.error }">
			<div class="alert alert-danger">
				${ sessionScope.error }
			</div>
			<c:remove var="error" scope="session"/>
		</c:if>
	</div>

	<form:form method="post" action="/Vinhtqph13704_Assignment/category/index" modelAttribute="category">
		<div class="container">
			<div>
				<h1 class="text-center mt-2" style="font-family: Courier New">
					<b>Quản lý danh mục</b>
				</h1>
			</div>

			<div class="md-form md-outline">
				<label class="bg-white deep-purple-text rounded px-2 ml-5"><b>Name</b></label>
				<form:input class="form-control border-dark" path="name" />
				<span class="badge bg-danger"><form:errors path="name"></form:errors></span>
			</div>

			<div>
				<button class="btn btn-success mt-2" formaction="/Vinhtqph13704_Assignment/category/create">Submit</button>
				<button class="btn btn-primary mt-2" formaction="/Vinhtqph13704_Assignment/category/update/${ category.id }">Update</button>
				<button class="btn btn-secondary mt-2" type="reset">Clear</button>
			</div>
		</div>
	</form:form>
	<hr class="container">
	<div class="container">
		<table class="table table-bordered">
		<thead class="table-dark">
			<tr class="align-middle text-center">
				<th>STT</th>
				<th>Name</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${data.content}">
			<c:set var="stt" value="${ stt + 1 }"></c:set>
				<tr class="align-middle text-center">
					<td>${ stt }</td>
					<td>${item.name}</td>
					<td>
						<a class="btn btn-success" href="/Vinhtqph13704_Assignment/category/edit/${ item.id }">Edit</a>
					</td>
					<td>
						<button type="button" class="btn btn-danger" data-bs-toggle="modal" 
							data-bs-target="#exampleModal${ item.id }">
							Xóa
						</button>
						<div class="modal fade" id="exampleModal${ item.id }" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
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
										<a class="btn btn-danger" href="/Vinhtqph13704_Assignment/category/delete/${ item.id }">Delete</a>
									</div>
								</div>
							</div>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div style="margin-left: 550px">
		<ul class="pagination">
			<li class="page-item">
				<a class="page-link" href="/Vinhtqph13704_Assignment/category/index?page=0&sort=${ sort }">
					<i class="fas fa-angle-double-left" style="color: black;"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="/Vinhtqph13704_Assignment/category/index?page=${ data.number - 1 }&sort=${ sort }">
					<i class="fad fa-angle-double-left" style="color: black;"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="/Vinhtqph13704_Assignment/category/index?page=${ data.number + 1 }&sort=${ sort }">
					<i class="fad fa-angle-double-right" style="color: black;"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="/Vinhtqph13704_Assignment/category/index?page=${ data.totalPages - 1 }&sort=${ sort }">
					<i class="fas fa-angle-double-right" style="color: black;"></i>
				</a>
			</li>
		</ul>
	</div>
	
	</div>
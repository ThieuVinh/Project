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

	<form:form method="post" action="/Vinhtqph13704_Assignment/account/index" modelAttribute="account" enctype="multipart/form-data">
		<div class="container">
			<div>
				<h1 class="text-center mt-2" style="font-family: Courier New">
					<b>Quản lý người dùng</b>
				</h1>
			</div>

			<div class="md-form md-outline">
				<label class="bg-white deep-purple-text rounded px-2 ml-5"><b>Username</b></label>
				<form:input class="form-control border-dark" name="username" path="username" />
				<span class="badge bg-danger"><form:errors path="username"></form:errors></span>
			</div>

			<div class="md-form md-outline mt-3">
				<label class="bg-white deep-purple-text rounded px-2 ml-5"><b>Password</b></label>
				<form:input class="form-control border-dark" type="password" name="password" path="password" />
				<span class="badge bg-danger"><form:errors path="password"></form:errors></span>
			</div>
			
			<div class="md-form md-outline mt-3">
				<label class="bg-white deep-purple-text rounded px-2 ml-5"><b>Fullname</b></label>
				<form:input class="form-control border-dark" name="fullname" path="fullname" />
				<span class="badge bg-danger"><form:errors path="fullname"></form:errors></span>
			</div>
			
			<div class="md-form md-outline mt-3">
				<label class="bg-white deep-purple-text rounded px-2 ml-5"><b>Email</b></label>
				<form:input class="form-control border-dark" name="email" type="email" path="email" />
				<span class="badge bg-danger"><form:errors path="email"></form:errors></span>
			</div>
			
			<div class="md-form md-outline mt-3">
				<label class="bg-white deep-purple-text rounded px-2 ml-5"><b>Avatar</b></label>
				<input class="form-control border-dark" type="file" name="photoName" />
				<span class="badge bg-danger"><form:errors path="photo"></form:errors></span>
			</div>
			
			<div class="row">
				<div class="md-form md-outline mt-3 col-4">
				<label class="bg-white deep-purple-text rounded px-2 ml-5"><b>Activated</b></label>
				<form:select class="form-select border-dark" aria-label="Default select example" name="activated" path="activated">
					<form:option value="0">Not active</form:option>
					<form:option value="1">Active</form:option>
				</form:select>
				<span class="badge bg-danger"><form:errors path="activated"></form:errors></span>
				</div>
				
				<div class="md-form md-outline mt-3 col-4">
					<label class="bg-white deep-purple-text rounded px-2 ml-5"><b>Role</b></label>
					<form:select class="form-select border-dark" aria-label="Default select example" name="admin" path="admin">
						<form:option value="0">User</form:option>
						<form:option value="1">Admin</form:option>
					</form:select>
					<span class="badge bg-danger"><form:errors path="admin"></form:errors></span>
				</div>
			</div>

			<div>
				<button formaction="/Vinhtqph13704_Assignment/account/create" class="btn btn-success mt-2">Submit</button>
				<button formaction="/Vinhtqph13704_Assignment/account/update/${ account.id }" class="btn btn-primary mt-2">Update</button>
				<button formaction="/Vinhtqph13704_Assignment/account/index" type="reset" class="btn btn-secondary mt-2">Clear</button>
			</div>
		</div>
	</form:form>
	<hr class="container">
	<div class="container">
		<table class="table table-bordered">
		<thead class="table-dark">
			<tr class="align-middle text-center">
				<th>STT</th>
				<th><a class="nav-link text-white" href="/Vinhtqph13704_Assignment/account/index?sort=username">Username</a></th>
				<th>Password</th>
				<th><a class="nav-link text-white" href="/Vinhtqph13704_Assignment/account/index?sort=fullname">Fullname</a></th>
				<th>Email</th>
				<th>Photo</th>
				<th>Activated</th>
				<th>Role</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${data.content}">
			<c:set var="stt" value="${ stt + 1 }"></c:set>
				<tr class="align-middle text-center">
					<td>${ stt }</td>
					<td>${item.username}</td>
					<td>${item.password}</td>
					<td>${item.fullname}</td>
					<td>${item.email}</td>
					<td>
						<img src="/Vinhtqph13704_Assignment/images/${item.photo}" width="100px">
					</td>
					<td>${item.activated == 0 ? "Not active" : "active"}</td>
					<td>${item.admin == 0 ? "User" : "Admin"}</td>
					<td>
						<a class="btn btn-success" href="/Vinhtqph13704_Assignment/account/edit/${ item.id }">Edit</a>
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
										<a class="btn btn-danger" href="/Vinhtqph13704_Assignment/account/delete/${ item.id }">Delete</a>
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
				<a class="page-link" href="/Vinhtqph13704_Assignment/account/index?page=0&sort=${ sort }">
					<i class="fas fa-angle-double-left" style="color: black;"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="/Vinhtqph13704_Assignment/account/index?page=${ data.number - 1 }&sort=${ sort }">
					<i class="fad fa-angle-double-left" style="color: black;"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="/Vinhtqph13704_Assignment/account/index?page=${ data.number + 1 }&sort=${ sort }">
					<i class="fad fa-angle-double-right" style="color: black;"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="/Vinhtqph13704_Assignment/account/index?page=${ data.totalPages - 1 }&sort=${ sort }">
					<i class="fas fa-angle-double-right" style="color: black;"></i>
				</a>
			</li>
		</ul>
	</div>
	</div>
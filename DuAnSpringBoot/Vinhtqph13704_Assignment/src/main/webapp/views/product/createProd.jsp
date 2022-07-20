<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

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

	<form:form method="post" action="/Vinhtqph13704_Assignment/product/index" modelAttribute="product" enctype="multipart/form-data">
		<div class="container">
			<div>
				<h1 class="text-center mt-2" style="font-family: Courier New">
					<b>Quản lý sản phẩm</b>
				</h1>
			</div>

			<div class="md-form md-outline">
				<label class="bg-white deep-purple-text rounded px-2 ml-5"><b>Name</b></label>
				<form:input class="form-control border-dark" path="name" />
				<span class="badge bg-danger"><form:errors path="name"></form:errors></span>
			</div>

			<div class="md-form md-outline mt-3">
				<label class="bg-white deep-purple-text rounded px-2 ml-5"><b>Avatar</b></label>
				<input class="form-control border-dark" type="file" name="imageName" />
				<span class="badge bg-danger"><form:errors path="image"></form:errors></span>
			</div>
			
			<div class="md-form md-outline mt-3">
				<label class="bg-white deep-purple-text rounded px-2 ml-5"><b>Price</b></label>
				<form:input class="form-control border-dark" path="price" />
				<span class="badge bg-danger"><form:errors path="price"></form:errors></span>
			</div>
			
			<div class="md-form md-outline mt-3">
				<label class="bg-white deep-purple-text rounded px-2 ml-5"><b>Available</b></label>
				<form:radiobuttons items="${ status }" path="available"/>
				<span class="badge bg-danger"><form:errors path="available"></form:errors></span>
			</div>
			
			<div class="md-form md-outline mt-3">
				<label class="bg-white deep-purple-text rounded px-2 ml-5"><b>Category</b></label>
				<form:select class="form-select border-dark" items="${ listCate }" path="categoryId" />
				<span class="badge bg-danger"><form:errors path="categoryId"></form:errors></span>
			</div>

			<div>
				<button formaction="/Vinhtqph13704_Assignment/product/create" class="btn btn-success mt-2">Submit</button>
				<button formaction="/Vinhtqph13704_Assignment/product/update/${ product.id }" class="btn btn-primary mt-2">Update</button>
				<button formaction="/Vinhtqph13704_Assignment/product/index" class="btn btn-secondary mt-2" type="reset">Clear</button>
			</div>
		</div>
	</form:form>
	<hr class="container">
	<div class="container">
		<table class="table table-bordered">
		<thead class="table-dark">
			<tr class="align-middle text-center">
				<th>STT</th>
				<th><a class="nav-link text-white" href="/Vinhtqph13704_Assignment/product/index?sort=name">Name</a></th>
				<th>Image</th>
				<th><a class="nav-link text-white" href="/Vinhtqph13704_Assignment/product/index?sort=price">Price</a></th>
				<th>Create Date</th>
				<th>Available</th>
				<th>Category</th>
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
						<img src="/Vinhtqph13704_Assignment/imageProduct/${item.image}" width="100px">
					</td>
					<td>${item.price}</td>
					<td>${item.createdDate}</td>
					<td>${item.available == 0 ? 'Còn hàng' : 'Hết hàng'}</td>
					<td>${item.category.name}</td>
					<td>
						<a class="btn btn-success" href="/Vinhtqph13704_Assignment/product/edit/${ item.id }">Edit</a>
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
										<a class="btn btn-danger" href="/Vinhtqph13704_Assignment/product/delete/${ item.id }">Delete</a>
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
				<a class="page-link" href="/Vinhtqph13704_Assignment/product/index?page=0&sort=${ sort }">
					<i class="fas fa-angle-double-left" style="color: black;"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="/Vinhtqph13704_Assignment/product/index?page=${ data.number - 1 }&sort=${ sort }">
					<i class="fad fa-angle-double-left" style="color: black;"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="/Vinhtqph13704_Assignment/product/index?page=${ data.number + 1 }&sort=${ sort }">
					<i class="fad fa-angle-double-right" style="color: black;"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="/Vinhtqph13704_Assignment/product/index?page=${ data.totalPages - 1 }&sort=${ sort }">
					<i class="fas fa-angle-double-right" style="color: black;"></i>
				</a>
			</li>
		</ul>
	</div>
</div>
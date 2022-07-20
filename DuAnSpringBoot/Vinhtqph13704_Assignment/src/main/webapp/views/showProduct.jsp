<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="row mt-4">
	<c:forEach items="${ showP }" var="show">
		<div class="col-3 border border-3 rounded mt-3"
			style="margin-left: 10px; width: 300px" >
			<img src="/Vinhtqph13704_Assignment/imageProduct/${show.image}"
				width="270">
			<div class="row mt-3">
				<div class="col-7">
					<h4>${ show.name }</h4>
					<h4>${ show.price }VNĐ</h4>
				</div>
				<div class="col-5" style="margin-right: 0px">
					<button type="button" class="btn btn-success" data-bs-toggle="modal" 
							data-bs-target="#exampleModal${ show.id }">
							Add
						</button>
						<div class="modal fade" id="exampleModal${ show.id }" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">Bạn có muốn thêm không ?</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Close</button>
										<a href="/Vinhtqph13704_Assignment/order/index/${ show.id }"
										class="btn text-white" style="background-color: rgb(51, 95, 93);">Add</a>
									</div>
								</div>
							</div>
						</div>
				
					<%-- <a href="/Vinhtqph13704_Assignment/order/index/${ show.id }"
						class="btn text-white" style="background-color: rgb(51, 95, 93);">BUY</a> --%>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
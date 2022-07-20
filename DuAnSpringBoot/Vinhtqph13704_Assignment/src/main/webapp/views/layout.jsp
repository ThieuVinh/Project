<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>V - Shop</title>
<link rel="stylesheet" href="/Vinhtqph13704_Assignment/css/bootstrap.min.css" />
</head>
<body>
	<div class="container-fluid">
		<header class="row bg-white" style="height: 100px;">
			<img class="img-fluid p-0 col-3 mt-4"
				src="/Vinhtqph13704_Assignment/img/v-shop-black-removebg-preview.png"
				style="height: 100px; width: 300px">
			<div class="input-group col-3 offset-1"
				style="width: 700px; margin-top: 30px;margin-left: 180px ; height: 30px">
				<input type="text" class="form-control"
					placeholder="Search products here...."
					aria-describedby="button-addon2">
				<button class="btn btn-outline-secondary" type="button"
					id="button-addon2">
					<i class="fas fa-search"></i>
				</button>
			</div>
			<div class="col-3">
				<div class="row p-3 mt-4 offset-4">
					<div class="col-3">
						<a href="/Vinhtqph13704_Assignment/order/orderdetail"><i class="fas fa-shopping-cart"
							style="height: 20px; width: 20px; color: black;"></i></a>
					</div>
					<div class="dropdown col-3">
						<a class="dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
							<i class="fas fa-user"
							style="height: 20px; width: 20px; color: black;"></i>
						</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<c:if test="${ empty sessionScope.user }">
								<li><a class="dropdown-item" href="/Vinhtqph13704_Assignment/login/index">Đăng nhập</a></li>
								<li><a class="dropdown-item" href="#">Đăng ký</a></li>
							</c:if>
							<c:if test="${ !empty sessionScope.user }">
								<li><a class="dropdown-item" href="/Vinhtqph13704_Assignment/login/logout">Đăng xuất</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</header>

		<nav class="navbar navbar-expand-lg navbar-white row p-0">
			<div class="container" style="margin-left: 600px">
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link text-black" href="/Vinhtqph13704_Assignment/showProd/index"><b>Trang chủ</b></a></li>
						<li class="nav-item"><a class="nav-link text-black" href="#"><b>Giới thiệu</b></a></li>
						<li class="nav-item"><a class="nav-link text-black" href="#"><b>Liên hệ</b></a></li>
						<c:if test="${ !empty sessionScope.user }">
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle text-black" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
								<b>Quản lý</b> 
							</a>
								<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="/Vinhtqph13704_Assignment/account/index">Quản lý người dùng</a></li>
								<li><a class="dropdown-item" href="/Vinhtqph13704_Assignment/category/index">Quản lý danh mục</a></li>
								<li><a class="dropdown-item" href="/Vinhtqph13704_Assignment/product/index">Quản lý sản phẩm</a></li>	
							</ul>
						</li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>

		<div class="row">
				<div class="bg-light">
					<jsp:include page="${ view }"></jsp:include>
				</div>
		</div>

		<footer class="mt-4">
			<div class="row bg-black"
				style="height: 400px; font-family: Comic Sans MS">
				<div class="row mt-5">
					<div class="col-3 offset-1 text-white ">
						<h4>Hỗ trợ</h4>
						<p>Theo dõi đơn hàng</p>
						<p>Liên hệ với chúng tôi</p>
						<p>Dịch vụ khách hàng</p>
					</div>
					<div class="col-3 offset-1 text-white ">
						<h4>Các chương trình</h4>
						<p>Chương trình sinh viên</p>
						<p>Săn sale thả ga</p>
						<p>Phần thưởng cho bạn bè</p>
					</div>
					<div class="col-3 offset-1 text-white ">
						<h4>Đối tác</h4>
						<p>Có</p>
						<p>Chương trình liên kết</p>
						<p>Tổ chức trường học</p>
					</div>
					<div class="text-center">
						<p class="text-white"
							style="font-size: 18px; font-family: Comic Sans MS">
							<b>Theo dõi chúng tôi</b> <i class="fab fa-facebook"
								style="color: white;"></i> <i class="fab fa-youtube"
								style="color: white;"></i> <i class="fab fa-instagram"
								style="color: white;"></i> <i class="fab fa-twitter"
								style="color: white;"></i> <i class="fab fa-pinterest-p"
								style="color: white;"></i>
						</p>
						<p class="text-white"
							style="font-size: 18px; font-family: Comic Sans MS">
							<b>FPT Polytechnic &copy; 2022. All rights reserved.</b>
						</p>
					</div>
				</div>
			</div>
		</footer>
	</div>

	<script src="/Vinhtqph13704_Assignment/js/jquery.min.js"></script>
	<script src="/Vinhtqph13704_Assignment/js/popper.min.js"></script>
	<script src="/Vinhtqph13704_Assignment/js/bootstrap.min.js"></script>
	<script defer src="https://pro.fontawesome.com/releases/v5.10.0/js/all.js"></script>
</body>
</html>
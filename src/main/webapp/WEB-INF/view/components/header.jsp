<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
<div class="header">
	<div class="header__logo">
		<img
			src="https://blueskytechco.com/rubix/wp-content/uploads/2021/05/logo_x2.png"
			alt="" />
	</div>
	<div class="header__navigation">
		<ul class="nav__level1">

			<li class="item_level1"><a href="">Home</a></li>
			<li class="item_level1"><a href="">Shop</a></li>
			<li class="item_level1"><a href="">Page</a></li>
			<li class="item_level1"><a href="">Blog</a></li>
			<li class="item_level1"><a href="">Contact</a></li>
		</ul>
	</div>
	<div class="header__action">
		<div class="header__action_left">
			<div class="login">
				<a href=""> <i class="fa fa-user" aria-hidden="true"></i>Login
				</a>
			</div>
			<span></span>
			<div class="register">
				<a href="" data-toggle="modal" data-target="#RegisterModal"
					aria-hidden="true">Register</a>
			</div>
		</div>
		<span>|</span>
		<div class="header__action_right">
			<i class="fa fa-heart-o" aria-hidden="true"></i> <i
				class="fa fa-cart-arrow-down" data-toggle="modal"
				data-target="#exampleModal" aria-hidden="true"></i> <i
				class="fa fa-search" aria-hidden="true"></i>

			<!-- Modal card -->
			<div class="modal fade model_card" id="exampleModal" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<input type="checkbox" class="check_all">
							<h5 class="modal-title" id="exampleModalLabel">Giỏ hàng</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body modal_body_card">
							<div class="card_product">
								<div class="check_item">
									<input type="checkbox">
								</div>
								<div class="card_item_img">
									<img
										src="https://blueskytechco.com/rubix/wp-content/uploads/2020/12/23-600x745.jpg"
										alt="">
								</div>
								<div class="card_item_info">
									<div class="card_item_info_name">Áo thể thao</div>
									<!-- <div class="card_item_info_quatity">1</div> -->
									<div class="quantity">

										<button class="btn mr-2">
											<i class="fa fa-plus" aria-hidden="true"></i>
										</button>
										<span class="item_quantity">1</span>
										<button class="btn ml-2">
											<i class="fa fa-minus" aria-hidden="true"></i>
										</button>
									</div>
									<div class="card_item_info_price_item">
										<div class="card_item_info_price">$39.00</div>
										<div class="card_item_info_total-price">$39.00</div>
									</div>
								</div>
								<button type="button" class="close delete_item"
									data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>

							<div class="card_product">
								<div class="check_item">
									<input type="checkbox">
								</div>
								<div class="card_item_img">
									<img
										src="https://blueskytechco.com/rubix/wp-content/uploads/2020/12/23-600x745.jpg"
										alt="">
								</div>
								<div class="card_item_info">
									<div class="card_item_info_name">Áo thể thao</div>
									<!-- <div class="card_item_info_quatity">1</div> -->
									<div class="quantity">

										<button class="btn mr-2">
											<i class="fa fa-plus" aria-hidden="true"></i>
										</button>
										<span class="item_quantity">1</span>
										<button class="btn ml-2">
											<i class="fa fa-minus" aria-hidden="true"></i>
										</button>
									</div>
									<div class="card_item_info_price_item">
										<div class="card_item_info_price">$39.00</div>
										<div class="card_item_info_total-price">$39.00</div>
									</div>
								</div>
								<button type="button" class="close delete_item"
									data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>

							<div class="card_product">
								<div class="check_item">
									<input type="checkbox">
								</div>
								<div class="card_item_img">
									<img
										src="https://blueskytechco.com/rubix/wp-content/uploads/2020/12/23-600x745.jpg"
										alt="">
								</div>
								<div class="card_item_info">
									<div class="card_item_info_name">Áo thể thao</div>
									<!-- <div class="card_item_info_quatity">1</div> -->
									<div class="quantity">

										<button class="btn mr-2">
											<i class="fa fa-plus" aria-hidden="true"></i>
										</button>
										<span class="item_quantity">1</span>
										<button class="btn ml-2">
											<i class="fa fa-minus" aria-hidden="true"></i>
										</button>
									</div>
									<div class="card_item_info_price_item">
										<div class="card_item_info_price">$39.00</div>
										<div class="card_item_info_total-price">$39.00</div>
									</div>
								</div>
								<button type="button" class="close delete_item"
									data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>

							<div class="card_product">
								<div class="check_item">
									<input type="checkbox">
								</div>
								<div class="card_item_img">
									<img
										src="https://blueskytechco.com/rubix/wp-content/uploads/2020/12/23-600x745.jpg"
										alt="">
								</div>
								<div class="card_item_info">
									<div class="card_item_info_name">Áo thể thao</div>
									<!-- <div class="card_item_info_quatity">1</div> -->
									<div class="quantity">

										<button class="btn mr-2">
											<i class="fa fa-plus" aria-hidden="true"></i>
										</button>
										<span class="item_quantity">1</span>
										<button class="btn ml-2">
											<i class="fa fa-minus" aria-hidden="true"></i>
										</button>
									</div>
									<div class="card_item_info_price_item">
										<div class="card_item_info_price">$39.00</div>
										<div class="card_item_info_total-price">$39.00</div>
									</div>
								</div>
								<button type="button" class="close delete_item"
									data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
						</div>
						<div class="modal-footer">
							<div class="Subtotal">
								<div class="Subtotal_title">Tổng tiền</div>
								<div class="Subtotal_price">$71.00</div>
							</div>
							<div class="block_checkout">

								<button type="button" class="btn_checkout" data-dismiss="modal">Thanh
									Toán</button>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Modal Register -->

			<div class="modal fade model_card" id="RegisterModal" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<div class="register_header_logo">
								<img
									src="https://blueskytechco.com/rubix/wp-content/uploads/2021/05/logo_x2.png"
									alt="">
								<h5 class="modal-title" id="exampleModalLabel">ĐĂNG KÝ TÀI
									KHOẢN</h5>
							</div>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body modal_body_register">

							<form>

								<div class="form-outline mb-4">
									<label class="form-label" for="form3Example1cg">Your
										Name: </label> <input type="text" id="form3Example1cg"
										class="form-control form-control" />
								</div>

								<div class="form-outline mb-4">
									<label class="form-label" for="form3Example3cg">Your
										Email:</label> <input type="email" id="form3Example3cg"
										class="form-control form-control" />
								</div>

								<div class="form-outline mb-4">
									<label class="form-label" for="form3Example4cg">Password:</label>
									<input type="password" id="form3Example4cg"
										class="form-control form-control" />
								</div>

								<div class="form-outline mb-4">
									<label class="form-label" for="form3Example4cdg">Repeat
										your password:</label> <input type="password" id="form3Example4cdg"
										class="form-control form-control" />
								</div>

								<div
									class="form-check-inline d-flex justify-content-center mb-5">
									<input class="form-check-input me-2" type="checkbox" value=""
										id="form2Example3cg" /> <label
										class="form-check-label" for="form2Example3g"> I agree
										all statements in <a href="#!" class="text-body"><u>Terms
												of service</u></a>
									</label>
								</div>

								<div class="d-flex justify-content-center">
									<button type="button"
										class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Register</button>
								</div>

								<p class="text-center text-muted mt-5 mb-0 register_login_here">
									Have already an account? <a href="#!" class="fw-bold text-body"><u>Login
											here</u></a>
								</p>

							</form>


						</div>
					</div>
				</div>
			</div>

			<!-- end -->

		</div>
	</div>
</div>
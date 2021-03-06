<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<script type="text/javascript">
				var productId = `<%=request.getParameter("maSanPham")%>
	`
			</script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/item-product.css">
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.27.2/axios.min.js"
	integrity="sha512-odNmoc1XJy5x1TMVMdC7EMs3IVdItLPlCeL5vSUPN2llYKMJ2eByTTAIiiuqLg+GdNr9hF6z81p27DArRFKT7A=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />



<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />

<!-- owlcarousel2 -->

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/qunit/2.18.1/qunit.css"
	integrity="sha512-ZCCKiB7dW1caC4UXu/J3xiZVV+nf4KEBFhp1AAc2q9S30+Di9o9hnXHdGuJaMc1pD/Fv2tc8e3PneXR1M/mJ4w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<link rel="stylesheet"
	href="<c:url value='/resources/css/lib/owl.theme.default.min.css' />">
<link rel="stylesheet"
	href="<c:url value='/resources/css/lib/owl.carousel.min.css' />">




<!-- Custom css -->
<link rel="stylesheet" href="<c:url value='/resources/css/home.css' />">
<link rel="stylesheet"
	href="<c:url value='/resources/css/productDetail.css' />">
<link rel="stylesheet"
	href="<c:url value='/resources/css/layout.css' />">


</head>

<body>
	<div class="container--fluid ">

		<div id='header'>
			<jsp:include page="components/header.jsp"></jsp:include>
		</div>



		<!-- Body -->
		<div class="components">

			<!-- breadcrumb -->

			<div class="breadcrumb-components">
				<jsp:include page="components/breadcrumb.jsp"></jsp:include>
			</div>
			<!-- /breadcrumb -->


			<div class="component container">
				<div class="product-detail row">
					<div class="images-detail col-lg-6 pr-3 mb-5">
						<div class="img-main">
							<div class="img-contain">
								<img
									src="<c:url value='/resources/images/${sanPham.danhSachHinhAnhSanPham[0].hinhAnh}' />"
									alt="">
							</div>
							<div class="icon-search ">
								<i class="fa fa-search" aria-hidden="true"></i>
							</div>
						</div>
						<div class="imgs-sub owl-carousel">


							<c:forEach var="item" items="${sanPham.danhSachHinhAnhSanPham }">
								<div class="img-sub ">
									<img src="<c:url value='/resources/images/${item.hinhAnh}' />"
										alt="">
								</div>

							</c:forEach>
						</div>
					</div>
					<form:form modelAttribute="donHang" id="submit-buy-now"
						class="info-detail  pr-6 col-lg-6 "
						action='${pageContext.request.contextPath}/don-hang/tao-don-hang'
						method="GET">
						<div class="title  pb-3 pr-4">
							<h4>${sanPham.tenSanPham }</h4>
						</div>
						<div class="ratings pb-4">
							<u class="number-start">4.9</u> <span class="mr-2"> <i
								class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star"
								aria-hidden="true"></i> <i class="fa fa-star" aria-hidden="true"></i>
								<i class="fa fa-star" aria-hidden="true"></i> <i
								class="fa fa-star" aria-hidden="true"></i>
							</span> <span class="info-rating"> (2 customer reviews)</span>
						</div>
						<div class="price-line">
							<span class="price-old price">${sanPham.giaTien} </span> <span
								class="price-current price">${sanPham.giaTien-item.giaTien*sanPham.chietKhau/100}</span>
							<div class="price-saving-percent percent">
								${sanPham.chietKhau}</div>
						</div>

						<div class="pt-4">
							<div class="option mb-2">
								<div class="title left mr-2">
									<b> Lo???i: </b>
								</div>
								<div class="title rioght mr-2">
									<span>${sanPham.loaiSanPham.tenLoaiSanPham}</span>
								</div>
							</div>
							<div class="option">
								<div class="title left mr-2">
									<b> K??ch th?????c: </b>
								</div>
								<div class="sizes">
								
									<c:forEach var="item" items="${dsKichThuoc}">

										<button class="btn mr-2 size" type="button"
											onclick='getQuantityProductBySizeName("${item}")'>${item}</button>
										

									</c:forEach>

									<!-- <button class="btn mr-2 size "> M </button>
                                                <button class="btn mr-2 size "> L </button>
                                                <button class="btn mr-2 size false " disabled> M </button> -->
								</div>
							</div>
							<div class="option mb-3">
								<div class="title left mr-2">
									<b>H??ng t???n </b>
								</div>
								<div class="title rioght mr-2 ">
									<span>
										<div id="soLuongTon">5</div>
									</span>
								</div>
							</div>
							<div class="option ">
								<div class=" left title mr-2">
									<b> s??? l?????ng: </b>
								</div>
								<div class="quantity ">
									<button class="btn ml-2" type="button" id="btnQuantityPrvate"
										onclick='quantityPrivate(this)'>
										<i class="fa fa-minus" aria-hidden="true"></i>
									</button>

									<span class="btn quantity-number" id="quantity">1</span>
									<button class="btn mr-2" type="button" id="btnQuantityPluss"
										onclick="quantityPluss(this)">
										<i class="fa fa-plus" aria-hidden="true"></i>
									</button>

								</div>
							</div>

							<div class="option pb-3 mt-4">
								<div class="btn-option" id="buy-now">
									<button class="btn" type="submit">
										<i class="fa fa-shopping-cart" aria-hidden="true"></i> Mua
										ngay
									</button>
								</div>
								<div class="btn-option" id="add-to-cart">
									<button onclick="addToCard()" type="button" class="btn">
										<i class="fa fa-money" aria-hidden="true"></i> Th??m v??o gi???
									</button>
								</div>
							</div>
						</div>
						<!--  form hiden submit to controller -->
						<form:hidden id="hidden-maSanPham"
							path="danhSachChiTietDonHang[0].chiTietSanPham.sanPham.maSanPham"
							value="${sanPham.maSanPham}" readonly="true" />
						<form:hidden id="hidden-tenKichThuoc"
							path="danhSachChiTietDonHang[0].chiTietSanPham.kichThuoc.tenKichThuoc"
							readonly="true" />
						<form:hidden id="hidden-soLuong"
							path="danhSachChiTietDonHang[0].soLuongMua" readonly="true" />
						<!--  /form hiden submit to controller -->
					</form:form>
				</div>
			</div>
			<div class="component container pt-0">
				<div class="tab p-4">
					<section class="container-tab pb-3">
						<nav class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
							<a class="nav-item nav-link active " id="#nav-description"
								data-toggle="tab" href="#nav-description" role="tab"
								aria-controls="nav-general">Chi ti???t</a> <a
								class="nav-item nav-link " id="#nav-comment" id='clock'
								data-toggle="tab" href="#nav-comment" role="tab"
								aria-controls="nav-profile">????nh gi??(1)</a>
						</nav>
					</section>

					<div class="tab-content py-3 px-sm-0" id="nav-tabContent">

						<div class="tab-pane fSade show active" id="nav-description"
							role="tabpanel" aria-labelledby="nav-description">
							<div class="description-detail color-gray pb-3 pt-3">
								<p>${sanPham.mieuTa}</p>
							</div>

						</div>
						<div class="tab-pane fSade show " id="nav-comment" role="tabpanel"
							aria-labelledby="nav-comment">
							<div class="title pb-3 ">
								<h4>5 ????nh gi?? cho s???n ph???m n??y</h4>
							</div>
							<div class="comments pb-3" id="comments"
								style="max-height: 500px; overflow: scroll; overflow-x: hidden;">
								<!-- <div class="comment">
													<div class="avatar">
														<img src="https://secure.gravatar.com/avatar/bb90dcb0ceabfc8bf10c550f1ee95ee7?s=60&d=mm&r=g"
															alt="">
													</div>
													<div class="info-comment">
														<div class="d-flex align-items-center">
															<div class="name  pb-1">Nguy???n Thanh s??n </div>
															<div class="date ml-2">
																<small> June 11, 2021</small>
															</div>
														</div>
														<div class="ratings pb-1">
															<i class="fa fa-star" aria-hidden="true"></i> <i
																class="fa fa-star" aria-hidden="true"></i> <i
																class="fa fa-star" aria-hidden="true"></i> <i
																class="fa fa-star" aria-hidden="true"></i> <i
																class="fa fa-star" aria-hidden="true"></i>
														</div>
														<div class="content">It has survived not only</div>
														<div class="image pt-2">
															<img height="60"
																src="https://secure.gravatar.com/avatar/bb90dcb0ceabfc8bf10c550f1ee95ee7?s=60&d=mm&r=g"
																class="rounded float-left">
														</div>
													</div>

												</div> -->
							</div>
							<nav class="mt-4">
								<ul class="pagination mb-0" style="justify-content: flex-end;"
									id="pagination-comment">
									<!-- <li class="page-item"><a class="page-link" href="#"
															aria-label="Previous"> <span
																aria-hidden="true">&laquo;</span>
															<span class="sr-only">Previous</span>
														</a></li>
													<li class="page-item"><a class="page-link" href="#">1</a></li>
													<li class="page-item"><a class="page-link" href="#">2</a></li>
													<li class="page-item"><a class="page-link" href="#">3</a></li>
													<li class="page-item"><a class="page-link" href="#"
															aria-label="Next"> <span aria-hidden="true">&raquo;</span>
															<span class="sr-only">Next</span>
														</a></li> -->
								</ul>
							</nav>

						</div>
					</div>
				</div>
			</div>
			<div class="component container list-product-suggest">
				<div class="components-title">
					<div class='title'>
						<span>S???n ph???m t????ng t???</span>
					</div>
				</div>

				<div class="items-product-suggest owl-carousel ">
					<c:forEach var="item" items="${listsp}" varStatus="status">
						<c:set var="item" value="${item}" scope="request" />
						<c:set var="col" value="${false}" scope="request" />
						<jsp:include page="components/item-product.jsp">
							<jsp:param value="${col}" name="col" />
							<jsp:param value="${item }" name="item" />
						</jsp:include>
					</c:forEach>

					

				</div>
			</div>
		</div>

		<div id='footer'>
			<jsp:include page="components/footer.jsp"></jsp:include>
		</div>
	</div>
	<!-- Modal success -->
	<!-- <div class="modal fade add_to_card_modal_container" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="exampleModalLongTitle" aria-hidden="true">
						<div class="modal-dialog modal-dialog_card_status" role="document">
							<div class="modal-content modal-content_card_status">

								<div class="modal-body">
									<div class="status_block">
										<div class="dialog_content dialog_content_card_status ">
											<div class="content_stutus_add">
												<img
													src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/MW-Icon-CheckMark.svg/1200px-MW-Icon-CheckMark.svg.png">
												<div class="content_stutus">Th??m th??nh c??ng</div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div> -->

	<div class="modal fade add_to_card_modal_container"
		id="myModalDialogSuccess" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLongTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog_card_status" role="document">
			<div class="modal-content modal-content_card_status">
				<div class="modal-body">
					<div class="status_block">
						<div class="dialog_content dialog_content_card_status ">
							<div class="content_stutus_add">
								<img
									src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/MW-Icon-CheckMark.svg/1200px-MW-Icon-CheckMark.svg.png">
								<div class="content_stutus">Th??m th??nh c??ng</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script src="<c:url value='/resources/js/layout.js'/>"></script>
	<script src="<c:url value='/resources/js/productDetail.js'/>"></script>
	<script src="<c:url value='/resources/js/home.js'/>"></script>


	<!-- owlcarousel2 -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/qunit/2.18.1/qunit.min.js"
		integrity="sha512-ioX9yMm2dVWL5HF8AVsxIMNNs5SEQa0Pr73G3fQflXtZ/5O8zwqJGkyP9A9jFtOMms8IykDBLxfnSpJWqkEKmg=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<script src="<c:url value='/resources/js/lib/owl.carousel.js'/>"
		data-cover></script>
	<script src="<c:url value='/resources/js/lib/owl.support.js'/>"
		data-cover></script>
	<script src="<c:url value='/resources/js/lib/owl.autoplay.js'/>"
		data-cover></script>
	<script>
		
		var percent = document.getElementsByClassName("percent");
    for (var i = 0; i < percent.length; i++) {
        console.log(percent[i].innerText);
        if (percent[i].innerText === "0%") {
            console.log(percent[i].parentElement);
            var priceOld =
                percent[
                    i
                ].parentElement.parentElement.parentElement.getElementsByClassName(
                    "price_old"
                )[0];
            priceOld.style.visibility = "hidden";
            priceOld.style.width = "0px";
            percent[i].parentElement.style.visibility = "hidden";
            // percent[i].parentElement.style.display = "none !important";
        }
    }
	</script>


	<script>

					</script>

</body>

</html>
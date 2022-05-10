<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
<link rel="stylesheet" href="<c:url value='/resources/css/shop.css' />">
<link rel="stylesheet" href="<c:url value='/resources/css/filter.css' />">
<link rel="stylesheet" href="<c:url value='/resources/css/jquery-ui.css' />">
<link rel="stylesheet" href="<c:url value='/resources/css/categories_styles.css' />">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/item-product.css">

</head>
<body>
	<div class="">
        <jsp:include page="components/header.jsp"></jsp:include>
        <section>
    </div>
    <div class= "display__item row">
        <div class="pl-5 display__item__filter col-3">  
          <!-- <div class="">
                  <div class="">
                    <div class="">
                        <hr>
                      <h4>Giá:</h4>
                      <div class="card-body">
                        <form id="price-range-form">
                          <label for="min-price" class="form-label">Min price: </label>
                          <span id="min-price-txt">$0</span>
                          <input type="range" class="form-range" min="0" max="99" id="min-price" step="1" value="0"><br>
                          <label for="max-price" class="form-label">Max price: </label>
                          <span id="max-price-txt">$1</span>
                          <input type="range" class="form-range " min="1" max="100" id="max-price" step="1" value="1">
                        </form>
                      </div>
                    </div>
                  </div>
                  <div class="btn__filter">
                      <button>Lọc <i class="fa fa-angle-right" aria-hidden="true"></i></button>
                  </div>
                </div> -->
                <div class="sidebar_section">
                    <div class="sidebar_title">
                        <h5>Filter by Price</h5>
                    </div>
                    <p>
                        <input
                            type="text"
                            id="amount"
                            readonly
                            style="border: 0; color: #f6931f; font-weight: bold"
                        />
                    </p>
                    <div id="slider-range"></div>
                    <div onclick="searchbyPriceFilter()" class="filter_button">
                        <span>filter</span>
                    </div>
                </div>
					
        
        <hr>
        
            <div class="display__item__filter__title">Danh mục</div>
            <ul class="categories__nav__level1">
                <li class="categories__nav__item__level1" id="football">Loại sản phẩm <i class="fa fa-angle-down"
                        aria-hidden="true"></i></li>
                <ul class="categories__nav__level2" id="football_items">
                   <!--  <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for=""> Thiết bị
                        </label> </li>
                    <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for=""> Dụng cụ
                        </label></li>
                    <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for=""> Quần áo
                        </label></li>
                        <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for=""> Giày 
                        </label></li> -->
                        <c:forEach var="item" items="${dsLoaiSanPham}">
                        	<li class="categories__nav__item__level2 categories__nav__item__level2_loaiSanPham">
                        		<input onchange="searchFilterCheckbox()" type="checkbox" name="loaiSanPham" id="${item.maLoaiSanPham}">
                        		<label for="${item.maLoaiSanPham }">${item.tenLoaiSanPham }</label></li>
                        </c:forEach>
                        
                </ul>
                <li class="categories__nav__item__level1" id="volleyball">Môn thể thao <i class="fa fa-angle-down"
                        aria-hidden="true"></i></li>
                <ul class="categories__nav__level2" id="volleyball_items">
                   <!--  <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for=""> Bóng đá
                        </label></li>
                    <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for=""> Bóng chuyền
                        </label></li>
                    <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for=""> Bóng rổ
                        </label></li>
                        <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for=""> Bơi lội
                        </label></li> -->
                        <c:forEach var="item" items="${dsMonTheThao}">
                        	<li class="categories__nav__item__level2 categories__nav__item__level2_monTheThao">
                        		<input onchange="searchFilterCheckbox()" type="checkbox" name="monTheThao" id="${item.maMonTheThao}">
                        		<label for="${item.maMonTheThao }">${item.tenMonTheThao }</label></li>
                        </c:forEach>
                </ul>
                <li class="categories__nav__item__level1" id="sportType">Thương hiệu<i class="fa fa-angle-down"
                    aria-hidden="true"></i></li>
                      <ul class="categories__nav__level2" id="sportType_items">
                   <!--  <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for=""> Adidas
                    </label></li>
                <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for="">Nike
                    </label></li>
                <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for="">Bitis
                    </label></li> -->
                    <c:forEach var="item" items="${dsNhanHieu}">
                        	<li class="categories__nav__item__level2 categories__nav__item__level2_nhanHieu">
                        		<input onchange="searchFilterCheckbox()" type="checkbox" name="nhanHieu" id="${item.maNhanHieu}">
                        		<label for="${item.maNhanHieu}">${item.tenNhanHieu}</label></li>
                        </c:forEach>
            </ul>
                
            </ul>

            <div class="">
              </div>
            
            <hr>

            <div class="products_featured">
                <div class="products_featured__title">Featured Products</div>
                <ul class="products_featured_nav" id="products_featured_nav_container">
                    <!-- <li class="products_featured_item">
                        <div class="rank"># 1</div>
                        <div class="products_featured_item_img">
                            <img src="https://blueskytechco.com/rubix/wp-content/uploads/2022/02/12_Cornstalk-Dracaena_1-600x720.jpg" alt="">
                        </div>
                        <div class="products_featured_item-info">
                            <div class="name">Flower</div>
                            <div class="price">$11,000</div>
                            <div class="price price_old">$11,000</div>
                            
                        </div>
                        
                    </li>

                    <li class="products_featured_item">
                        <div class="rank"># 1</div>
                        <div class="products_featured_item_img">
                            <img src="https://blueskytechco.com/rubix/wp-content/uploads/2022/02/12_Cornstalk-Dracaena_1-600x720.jpg" alt="">
                        </div>
                        <div class="products_featured_item-info">
                            <div class="name">Flower</div>
                            <div class="price">$11,000</div>
                            
                        </div>
                        
                    </li>

                    <li class="products_featured_item">
                        <div class="rank"># 1</div>
                        <div class="products_featured_item_img">
                            <img src="https://blueskytechco.com/rubix/wp-content/uploads/2022/02/12_Cornstalk-Dracaena_1-600x720.jpg" alt="">
                        </div>
                        <div class="products_featured_item-info">
                            <div class="name">Flower</div>
                            <div class="price">$11,000</div>
                            
                        </div>
                        
                    </li> -->
                </ul>
            
            </div>

        </div>
        <div class="display__item__itemList col-8">
            <div class="display__item__itemList__header">
                <div class="product_sorting_container product_sorting_container_top">
									<ul class="product_sorting">
										<!-- <li>
											<span class="type_sorting_text">Default Sorting</span>
											<i class="fa fa-angle-down"></i>
											<ul class="sorting_type">
												<li class="type_sorting_btn" data-isotope-option='{ "sortBy": "original-order" }'><span>Default Sorting</span></li>
												<li class="type_sorting_btn" data-isotope-option='{ "sortBy": "price" }'><span>Price</span></li>
												<li class="type_sorting_btn" data-isotope-option='{ "sortBy": "name" }'><span>Product Name</span></li>
											</ul>
										</li> -->
                                        <span>Show</span>
										<li>
											<!-- <span class="num_sorting_text">6</span> -->
											<!-- <i class="fa fa-angle-down"></i> -->
											<select onchange="searchbyPriceFilter()"  class="sorting_num_re">
												<option value="6" class="num_sorting_btn_re">6</option>
												<option value="12" class="num_sorting_btn_re">12</option>
												<option value="24" class="num_sorting_btn_re">24</option>
											</select>
										</li>
									</ul>
									<div class="pages d-flex flex-row align-items-center pagination">
										<div id="next_page" class="page_next page_next_left"><a href="#"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a></div>
										<div class="page_current">
											<span>1</span>
											<ul class="page_selection">
												<li><a href="#">1</a></li>
												<li><a href="#">2</a></li>
												<li><a href="#">3</a></li>
											</ul>
										</div>
	
										<div class="page_total"><span>of</span> 3</div>
										<div id="next_page" class="page_next"><a href="#"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a></div>
									</div>

								</div>
            </div>

            <div class="display__item__itemList__item_result">
                <div class="row" id="container_item_product">
                <!-- <c:forEach var="item" items="${listSanPham }"  varStatus="status">
                	 <c:set var="item" value="${item}" scope="request" />
	                <jsp:include page="components/item-product.jsp">
	               		<jsp:param value="${item }" name="item"/>
                	</jsp:include>
                </c:forEach> -->
                </div>
            </div>
            <nav class="pagination_block" aria-label="...">
                <ul class="pagination" id="pagination_id">
                    <!-- <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1"><i class="fa fa-angle-left"
                                aria-hidden="true"></i></a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item active">
                        <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
                    </li> -->
                </ul>
            </nav>
        </div>

    </div>
    <div class="trending__products"></div>
    <div class="best__seller"></div>
    <div class="contact"></div>
    <div class="brand"></div>
    </section>
    
    <jsp:include page="components/footer.jsp"></jsp:include>
    
 
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"
        ></script>
        <script src="<c:url value='/resources/js/home.js'/>"></script>
        
        <script src="<c:url value='/resources/js/layout.js'/>"></script>
        <script src="<c:url value='/resources/js/filter.js'/>"></script>
        <script src="<c:url value='/resources/js/jquery-ui.js'/>"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-twinkle/0.8.0/jquery.twinkle.min.js"></script>
        <script src="<c:url value='/resources/js/shop.js'/>"></script>
        <%-- <script src="<c:url value='/resources/js/categories_custom.js'/>"></script> --%>
  
</body>
</html>
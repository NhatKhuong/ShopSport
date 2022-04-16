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
<link rel="stylesheet" href="<c:url value='/resources/css/home.css' />">
<link rel="stylesheet" href="<c:url value='/resources/css/filter.css' />">

</head>
<body>
	<div class="">
        <jsp:include page="components/header.jsp"></jsp:include>
        <section>
           <%--  <div class="slider">
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="img__block carousel-item active">
                            <img class="d-block w-100"
                                src="<c:url value='/resources/imgSlider/slider1_pic.jpg' />"
                                alt="First slide">
                        </div>
                        <div class="img__block carousel-item">
                            <img class="d-block w-100"
                                src="<c:url value='/resources/imgSlider/slider1_pic.jpg' />"
                                alt="Second slide">
                        </div>
                        <div class="img__block carousel-item">
                            <img class="d-block w-100"
                                src="http://intero.vn/wp-content/uploads/Quang-cao-quan-ao-the-thao-tren-Facebook1.jpg"
                                alt="Third slide">
                        </div>
                    </div>
                </div>

            </div> --%>

    </div>
    <div class= "display__item row">
        <div class="pl-5 display__item__filter col-3">
        
          <div class="">
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
                </div>
					
        
        <hr>
        
            <div class="display__item__filter__title">Danh mục</div>
            <ul class="categories__nav__level1">
                <li class="categories__nav__item__level1" id="football">Loại sản phẩm <i class="fa fa-angle-down"
                        aria-hidden="true"></i></li>
                <ul class="categories__nav__level2" id="football_items">
                    <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for=""> Thiết bị
                        </label> </li>
                    <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for=""> Dụng cụ
                        </label></li>
                    <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for=""> Quần áo
                        </label></li>
                        <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for=""> Giày 
                        </label></li>
                </ul>
                <li class="categories__nav__item__level1" id="volleyball">Môn thể thao <i class="fa fa-angle-down"
                        aria-hidden="true"></i></li>
                <ul class="categories__nav__level2" id="volleyball_items">
                    <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for=""> Bóng đá
                        </label></li>
                    <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for=""> Bóng chuyền
                        </label></li>
                    <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for=""> Bóng rổ
                        </label></li>
                        <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for=""> Bơi lội
                        </label></li>
                </ul>
                <li class="categories__nav__item__level1" id="sportType">Thương hiệu<i class="fa fa-angle-down"
                    aria-hidden="true"></i></li>
                      <ul class="categories__nav__level2" id="sportType_items">
                    <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for=""> Adidas
                    </label></li>
                <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for="">Nike
                    </label></li>
                <li class="categories__nav__item__level2"> <input type="checkbox" name=""> <label for="">Bitis
                    </label></li>
            </ul>
                
            </ul>

            <div class="">
                <%-- <div class="">
                  <div class="">
                    <div class="">
                        <hr>
                      <h4>Giá:</h4>
                      <div class="card-body">
                        <form id="price-range-form">
                          <label for="min-price" class="form-label">Min price: </label>
                          <span id="min-price-txt">$0</span>
                          <input type="range" class="form-range" min="0" max="99" id="min-price" step="1" value="0">
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
                </div> --%>
              </div>
            
            <hr>

            <div class="products_featured">
                <div class="products_featured__title">Featured Products</div>
                <ul class="products_featured_nav">
                    <li class="products_featured_item">
                        <div class="products_featured_item_img">
                            <img src="https://blueskytechco.com/rubix/wp-content/uploads/2022/02/12_Cornstalk-Dracaena_1-600x720.jpg" alt="">
                        </div>
                        <div class="products_featured_item-info">
                            <div class="name">Flower</div>
                            <div class="price">$11,000</div>
                            <div class="rating"></div>
                        </div>
                        
                    </li>
                    <li class="products_featured_item">
                        <div class="products_featured_item_img">
                            <img src="https://blueskytechco.com/rubix/wp-content/uploads/2022/02/12_Cornstalk-Dracaena_1-600x720.jpg" alt="">
                        </div>
                        <div class="products_featured_item-info">
                            <div class="name">Flower</div>
                            <div class="price">$11,000</div>
                            <div class="rating"></div>
                        </div>
                    </li>
                    <li class="products_featured_item">
                        <div class="products_featured_item_img">
                            <img src="https://blueskytechco.com/rubix/wp-content/uploads/2022/02/12_Cornstalk-Dracaena_1-600x720.jpg" alt="">
                        </div>
                        <div class="products_featured_item-info">
                            <div class="name">Flower</div>
                            <div class="price">$11,000</div>
                            <div class="rating"></div>
                        </div>
                    </li>
                    <li class="products_featured_item"></li>
                </ul>
            
            </div>

        </div>
        <div class="display__item__itemList col-9">
            <div class="display__item__itemList__header">
                <div class="display__item__itemList__header__title">Showing all 2 results</div>
                <div class="type__sorting_block">
                    <select name="" id="" class="type__sorting">
                        <option value="">Default Sorting</option>
                        <option value="">Sorting by Popularity</option>
                        <option value="">Sorting by last</option>
                        <option value="">Sorting by price: Low to Height</option>
                        <option value="">Sorting by price: Hieght to Low</option>
                    </select>
                </div>
            </div>

            <div class="display__item__itemList__item_result">
                <div class="row">
                <c:forEach var="item" items="${listSanPham }"  varStatus="status">
                	 <c:set var="item" value="${item}" scope="request" />
	                <jsp:include page="components/item-product.jsp">
	               		<jsp:param value="${item }" name="item"/>
                	</jsp:include>
                </c:forEach>
                	
                	<%-- <c:forEach var="item" items="${listSanPham }">
                		<div class="col-3" onclick="window.location.href='san-pham/chi-tiet-san-pham?maSanPham=${item.maSanPham}'">
                        <div class="card_item">
                            <div class="item_img">
                                <img src="<c:url value='/resources/images/${item.danhSachHinhAnhSanPham[0].hinhAnh}' />"
                                    alt="">
                                <div class="btn_add-to-card">
                                    <i class="fa fa-shopping-cart" aria-hidden="true"></i> Add to card
                                </div>
                            </div>
                            <div class="item_info">
                                <div class="item_title">${item.tenSanPham }</div>
                                <div class="item_info_price">

                                    <div class="item_price">${item.giaTien-item.giaTien*item.chietKhau/100 }</div>
                                    <div class="item_price_discount">${item.giaTien }</div>
                                </div>
                            </div>

                            <div class="card_item_action">
                                <a href=""><i class="card_icon fa fa-heart-o" aria-hidden="true"></i></a>
                                <a href=""><i class="card_icon fa fa-sliders" aria-hidden="true"></i></a>
                                <a href=""><i class="card_icon fa fa-eye" aria-hidden="true"></i></a>
                            </div>
                            <div class="sale">
                                Sale
                            </div>
                        </div>
                    </div>
                	</c:forEach> --%>
                    
                </div>
            </div>
            <nav class="pagination_block" aria-label="...">
                <ul class="pagination">
                    <li class="page-item disabled">
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
                    </li>
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
        <script src="<c:url value='/resources/js/filter.js'/>"></script>
  
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
    <%-- <link href="<c:url value='/resources/css/login.css' />" /> --%>
<link rel="stylesheet" href="<c:url value='/resources/css/login.css' />">
<%-- <link rel="stylesheet" href="<c:url value='/resources/css/login.css' />"> --%>
</head>
<body>
	<section class="login-block">
    <div class="container">
        <div class="row">
            <div class="col-md-4 login-sec">
                <h2 class="text-center">Quên mật khẩu</h2>
                 <div class="alert alert-${error != null ? 'danger' : (message != null ? 'primary' : ' d-none' ) }"
                    role="alert">
                    ${error == null ? message : error}
                </div>
                 <form:form cssClass="login-form" action="${pageContext.request.contextPath}/quen-mat-khau" method="POST">
    			<c:if test="${param.error != null}">
    				<i class="failed">Sorry!You entered invalid username/password</i>
    			</c:if>
                <%-- <form class="login-form"> --%>
                    <div class="form-group">
                        <label for="exampleInputEmail1" class="text-uppercase">Email</label>
                        <input type="email" class="form-control" placeholder="" name="mail"  value='${mail}'>
                    </div>
                    <div class="form-check">
                        <button type="submit" class="btn btn-login float-right">Submit</button>
                    </div>
                <%-- </form> --%>
                </form:form>
                <div class="copy-text">Created with <i class="fa fa-heart"></i> by Grafreez</div>
            </div>
            <div class="col-md-8 banner-sec">
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    
                    </ol>
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item active">
                            <img class="img_silder"
                                src="https://www.citrixguru.com/wp-content/uploads/2018/12/PasswordResetShareFile.jpg"
                                alt="First slide">
                            <div class="carousel-caption d-none d-md-block">
                                <div class="banner-text">
                                    <h2>Quên mật khẩu</h2>
                                    <p>Sau khi nhập email và nhấn submit bạn sẽ được nhận một đường link để thiết lập lại mật khẩu của bạn trong hộp thư email</p>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
</section>

</body>
</html>
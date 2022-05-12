<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="ISO-8859-1">
                <title> --- </title>
                <link rel="stylesheet"
                    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                    crossorigin="anonymous" />
                <link rel="stylesheet" href="<c:url value='/resources/css/updateUser.css' />">
                <link rel="stylesheet" href="<c:url value='/resources/css/home.css' />">
            </head>


            <body>
                <div class="container--fluid">

                    <div id='header'>
                        <jsp:include page="components/header.jsp"></jsp:include>
                    </div>


                    <div class="components">
                        <!-- Body -->
                        <div class="container">
                            <!-- breadcrumb -->

                            <%-- <div class="breadcrumb-components">
                                <jsp:include page="components/breadcrumb.jsp"></jsp:include>
                        </div> --%>
                        <!-- /breadcrumb -->

                        <div class="component" style="display: flex; justify-content: space-around;">

                            <div class="box  col-8">
                                <div class="header-title">
                                    <span>Thông tin người dùng</span>
                                </div>
                                <div class="component pt-3 mb-4 pb-2">
                                    <form:form modelAttribute="nguoiDung"
                                        action='${pageContext.request.contextPath}/nguoi-dung/update' method="GET">

                                        <div class="row">

                                            <div class="col-6">
                                                <div class="form-group">

                                                    <label for="tinhThanhPho">Tỉnh/Thành phố</label>
                                                    <form:select path="diaChi.tinhThanhPho" class="form-control"
                                                        id="tinhThanhPho">

                                                    </form:select>
                                                    <small class="text-danger d-none" id='helpTinhThanhPho'>Bạn chưa
                                                        chọn thành
                                                        phố</small>
                                                </div>
                                                <div class="form-group">
                                                    <label for="quanHuyen">Quận/Huyện</label>
                                                    <form:select path="diaChi.quanHuyen" class="form-control"
                                                        id="quanHuyen">
                                                        <option selected></option>
                                                    </form:select>
                                                    <small class="text-danger d-none " id='helpQuanHuyen'>Bạn chưa
                                                        chọn quận
                                                        huyện</small>
                                                </div>

                                                <div class="form-group">
                                                    <label for="quanHuyen">Xã/Phường</label>
                                                    <form:select path="diaChi.phuongXa" class="form-control"
                                                        id="phuongXa">
                                                        <option selected disabled></option>
                                                    </form:select>
                                                    <small class="text-danger d-none " id='helpQuanHuyen'>Bạn chưa
                                                        chọn quận
                                                        huyện</small>
                                                </div>
                                            </div>
                                            <div class="col-6">
                                                <div class="form-group">
                                                    <label for="diaChi">Địa chỉ</label>
                                                    <form:input path="diaChiChiTiet" type="text" name="diaChiChiTiet"       required="required"
                                                        id="diaChiCuThe" class="form-control" placeholder="Nhập địa chỉ"
                                                        value="${diaChiChiTiet}" aria-describedby="helpId"></form:input>
                                                    <small id="helpDiaChiCuThe" class="text-danger d-none">Bạn chưa nhập
                                                        địa
                                                        chỉ</small>
                                                </div>

                                                <div class="form-group">
                                                    <label for="hoTen">Họ tên người nhận</label>
                                                    <form:input path="hoTen" type="text" name="hoTen" id="hoTen"
                                                        class="form-control" placeholder="Nhập họ và tên"       required="required"
                                                        aria-describedby="helpId" value="${hoTen}"></form:input>
                                                    <small id="helpHoTen" class="text-muted"></small>

                                                </div>

                                                <div class="form-group">
                                                    <label for="soDienThoai">Số điện thoại</label>
                                                    <form:input path="soDienThoai" type="text" name="soDienThoai"
                                                        id="soDienThoai" class="form-control"       required="required"
                                                        placeholder="Nhập số điện thoại" value="${soDienThoai }"
                                                        aria-describedby="helpId"></form:input>
                                                    <small id="helpSoDienThoai" class="text-danger d-none">Vui lòng nhập
                                                        số điện thoại đúng định dạng </small>
                                                </div>

                                                <!--    <button>Khôi phục</button> -->
                                                <button onclick="notifySuccess()" type="submit">Lưu</button>

                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                        <!-- /Body -->
                    </div>
                </div>
                <div id='footer'>
                    <jsp:include page="components/footer.jsp"></jsp:include>
                </div>


                </div>
                <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
                    crossorigin="anonymous"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                    crossorigin="anonymous"></script>

                <script src="<c:url value='/resources/js/createOrder.js'/>"></script>
                <script type="text/javascript">
                    (async () => {
                        var tinhThanhPho = '${ nguoiDung.diaChi.tinhThanhPho }'
                        var quanHuyen = '${ nguoiDung.diaChi.quanHuyen }'
                        var phuongXa = '${ nguoiDung.diaChi.phuongXa }'
                        await loadDataTinh();
                        document.getElementById('tinhThanhPho').value = tinhThanhPho
                        await loadDataQuanHuyen();
                        document.getElementById('quanHuyen').value = quanHuyen
                        await loadDataPhuongXa();
                        document.getElementById('phuongXa').value = phuongXa
                    })();
                </script>
            </body>

            </html>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<script>var contextPath = "${pageContext.request.contextPath}"</script>
  <aside class="app-sidebar">
  
    <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="/images/admin.jpg" width="50px"
        alt="User Image">
      <div>
        <p class="app-sidebar__user-name"><b>ADMIN</b></p>
        <p class="app-sidebar__user-designation">Chào mừng bạn trở lại</p>
      </div>
    </div>
    <hr>
    <ul class="app-menu">
      <li><a class="app-menu__item haha" href="${pageContext.request.contextPath}/quan-ly"><i class='app-menu__icon bx bx-cart-alt'></i>
          <span class="app-menu__label">POS Bán Hàng</span></a></li>
      <li><a  class="app-menu__item active" href="${pageContext.request.contextPath}/quan-ly"><i class='app-menu__icon bx bx-tachometer'></i><span
            class="app-menu__label">Bảng điều khiển</span></a></li>
      <li><a class="app-menu__item" href="${pageContext.request.contextPath}/quan-ly/quan-ly-san-pham"><i
            class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Quản lý sản phẩm</span></a>
      </li>
      <li><a class="app-menu__item" href="${pageContext.request.contextPath}/quan-ly/quan-ly-don-hang"><i class='app-menu__icon bx bx-task'></i><span
            class="app-menu__label">Quản lý đơn hàng</span></a></li>
      <li><a class="app-menu__item" href="${pageContext.request.contextPath}/quan-ly/quan-ly-nguoi-dung"><i class='app-menu__icon bx bx-run'></i><span
            class="app-menu__label">Quản lý người dùng
          </span></a></li>
      <li><a class="app-menu__item" href="${pageContext.request.contextPath}/quan-ly/bao-cao-doanh-thu"><i
            class='app-menu__icon bx bx-pie-chart-alt-2'></i><span class="app-menu__label">Báo cáo doanh thu</span></a>
      </li>

    </ul>
  </aside>
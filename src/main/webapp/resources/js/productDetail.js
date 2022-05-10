const formHiddenTenKichThuoc = document.getElementById("hidden-tenKichThuoc");
const formHiddenSoLuong = document.getElementById("hidden-soLuong");
const soLuongMua = document.getElementById("quantity");
const submitFormBuy = document.getElementById("submit-buy-now");
const maSanPham = new URL(window.location.href).searchParams.get("maSanPham");
var totalReview = 0,
	totalPage,
	limit = 5,
	pageNow = 1;
// Vote rating
// $("#myModal").modal();
// $("#myModalDialogSuccess").modal();

// vote rating

(function activeImage() {
	var imageSub = document.querySelectorAll(".img-sub");
	var imageMain = document.querySelector(".img-main img");
	var eOld;
	imageSub.forEach((el) =>
		el.addEventListener("click", (event) => {
			if (!event.target.src) {
				return;
			}
			imageMain.src = event.target.src;
			if (eOld) eOld.classList.remove("active");
			event.target.parentElement.classList.add("active");
			eOld = event.target.parentElement;
		})
	);
})();

(function activeSize() {
	var sizes = document.querySelectorAll(".size");
	var eOld;
	console.log(sizes);
	sizes.forEach((el) =>
		el.addEventListener("click", (event) => {
			if (eOld) eOld.classList.remove("active");
			event.target.classList.add("active");
			eOld = event.target;

		})
	);
})();

// owl-carousel // slider
$(document).ready(function() {
	$(".imgs-sub.owl-carousel").owlCarousel({
		items: 5,
		animateOut: "fadeOut",
		nav: true,
		responsiveClass: true,
		responsive: {
			300: {
				items: 3,
				nav: false,
			},

			600: {
				items: 5,
				nav: true,
				loop: false,
			},
		},
	});
});

// slider
$(document).ready(function() {
	$(".items-product-suggest.owl-carousel").owlCarousel({
		items: 5,
		animateOut: "fadeOut",
		nav: true,
		responsiveClass: true,
		loop: true,
		margin: 10,
		autoplay: true,
		autoplayTimeout: 3000,
		autoplayHoverPause: true,
		responsive: {
			300: {
				items: 3,
				nav: false,
			},

			600: {
				items: 4,
				nav: true,
			},
		},
	});
});

function showDialogSuccessStatus() {
	$("#myModalDialogSuccess").addClass("show");
	setTimeout(function() {
		$("#myModalDialogSuccess").removeClass("show");
	}, 1000);
}

function addToCard() {

	if (!authenticated) {
		if (confirm("Bạn chưa đăng nhập ! Bạn có muốn đăng nhập không ?") == true) {
			window.location.href = `${contextPath}/dang-nhap`
		}
		return;
	}

	var url = new URL(window.location.href);
	var productId = url.searchParams.get("maSanPham");
	var tenKichThuoc = document.querySelector(".sizes .active").innerText;
	var soLuong = document.getElementById("quantity").innerText;
	// $("#myModalDialogSuccess").modal();

	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: `${contextPath}/gio-hang/them`,
		dataType: "json",
		data: {
			productId,
			tenKichThuoc,
			soLuong,
		},
		timeout: 100000,

		success: function(data) {
			console.log("sucess" + data);
		},
		error: function(e) {
			console.log("----------" + 1);
			showDialogSuccessStatus();
			// $("#myModalDialogSuccess").addClass("show");
			// alert("ssss");
			console.log("--------" + 2);
		},
	});
}

(() => { })();

function getQuantityProductBySizeName(tenKichThuoc) {
	var url = new URL(window.location.href);
	var maSanPham = url.searchParams.get("maSanPham");

	$.ajax({
		type: "GET",
		contentType: "application/json",
		// contextPath declared in header
		url: contextPath + `/san-pham/so-luong-ton`,
		data: {
			maSanPham,
			tenKichThuoc,
		},
		dataType: "json",
		timeout: 100000,
		success: function(data) {
			console.log("SUCCESS: ", data);
			document.getElementById("soLuongTon").innerText = data;
		},
		error: function(e) {
			console.log("ERROR: ", e);
		},
	});
}

//  buy now
submitFormBuy.addEventListener("submit", (e) => {
	const tenKichThuoc = document.querySelector(".sizes .size.active");
	if (!tenKichThuoc) {
		alert("Vui lòng chọn kích thước");
		e.preventDefault();
	}

	formHiddenSoLuong.value = +soLuongMua.innerText;
	formHiddenTenKichThuoc.value = tenKichThuoc.innerText;
});

/* input */

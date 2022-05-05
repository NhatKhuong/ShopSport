function createUser() {
	jQuery(function() {
		jQuery(".createUser").click(function() {
			
		});
	})
};


function createUserDB() {
	jQuery.ajax({
		type: "GET",
		contentType: 'application/json',
		url: contextPath + `/quan-ly/quan-ly-san-pham-load-lsp`,
		dataType: 'json',
		timeout: 100000,
		success: function(data) {
			let temp = "<option value='Tất cả'>--Tất cả--</option>";
			data.forEach((v) => {
				temp += `<option value='${v.tenLoaiSanPham}'>${v.tenLoaiSanPham}</option>`;
			});
			document.getElementById("selectLoaiSanPham").innerHTML = temp;
		},
		error: function(e) {
			console.log("ERROR: ", e);
		},
	});
}
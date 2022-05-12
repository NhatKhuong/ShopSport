function createUser() {
	jQuery(function() {
		jQuery(".createUser").click(function() {
			var status = 0;
			if (formValidata() == true) {
				var tenNguoiDung = document.getElementById('yourName').value;
				var emailNguoiDung = document.getElementById('yourEmail').value;
				var passWord = document.getElementById('passWord').value;
				createUserDB(tenNguoiDung, emailNguoiDung, passWord);
				status = 1;
			} else {
				status = 0;
			}
			if (status == 1) {
				Swal.fire({
					title: "Đăng kí thành công!",
					text: "Cảm ơn bạn",
					icon: "success",
					confirmButtonText: "Đồng ý",
				});
			} else {
				Swal.fire({
					title: "Đăng kí không thành công!",
					text: "Bạn đã đánh giá rồi",
					icon: "error",
					confirmButtonText: "Đồng ý",
				});
			}


		});
	})
};
createUser();
function formValidata() {
	var ten = changeRegexInputTen();
	var email = changeRegexInputEmail();
	var passWord = changeRegexInputPassWord();
	var repeatPassWord = changeRegexInputRepeatPassWord();
	if (ten && email && passWord == repeatPassWord) {
		return true;
	}
	return false;


}

function changeRegexInputTen() {
	var tenNguoiDung = document.getElementById('yourName').value;
	//Regex
	var regexname = /^[^\d+]*[\d+]{0}[^\d+]*$/;
	//Thông Báo
	var tbTenNguoiDung = document.getElementById('tbYouName');

	if (tenNguoiDung == '' || tenNguoiDung == null) {
		tbTenNguoiDung.innerHTML = "Tên người dùng không được để trống";
	} else {
		if (!regexname.test(tenNguoiDung)) {
			tbTenNguoiDung.innerHTML = "Tên người dùng không đúng cú pháp.";
		} else {
			tbTenNguoiDung.innerHTML = "";
			return tenNguoiDung;
		}
	}

}




function changeRegexInputEmail() {
	var emailNguoiDung = document.getElementById('yourEmail').value;
	//Regex
	var regexemail = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
	//Thông Báo
	var tbEmailNguoiDung = document.getElementById('tbEmail');

	if (emailNguoiDung == '' || emailNguoiDung == null) {
		tbEmailNguoiDung.innerHTML = "Email không được để trống";
	} else {
		if (!regexemail.test(emailNguoiDung)) {
			tbEmailNguoiDung.innerHTML = "Email không đúng cú pháp. Ví dụ: abc@abc.com";
		} else {
			tbEmailNguoiDung.innerHTML = "";
			return emailNguoiDung;
		}
	}
}


function changeRegexInputPassWord() {
	var passWord = document.getElementById('passWord').value;
	//Thông Báo
	var tbPassWordNguoiDung = document.getElementById('tbPassWord');
	if (passWord == '' || passWord == null) {
		tbPassWordNguoiDung.innerHTML = "Mật khẩu không được để trống";
	} else {
		tbPassWordNguoiDung.innerHTML = ' ';
		return passWord;
	}
}

function changeRegexInputRepeatPassWord() {
	var passWord = document.getElementById('passWord').value;
	var repeatPassword = document.getElementById('repeatPassword').value;
	//Thông Báo
	var tbRepeatPassword = document.getElementById('tbRepeatPassword');

	if (repeatPassword == '' || repeatPassword == null || repeatPassword != passWord) {
		tbRepeatPassword.innerHTML = "Mật khẩu nhập lại không trùng khớp";
	} else {
		tbRepeatPassword.innerHTML = ' ';
		return repeatPassword;
	}

}



function createUserDB(tenNguoiDung, emailNguoiDung, passWord) {
	jQuery.ajax({
		type: "GET",
		contentType: 'application/json',
		data: {
			tenNguoiDung,
			emailNguoiDung,
			passWord,
		},
		url: contextPath + `/dang-ky-user`,
		dataType: 'json',
		timeout: 100000,
		success: function(data) {
			console.log(data);
		},
		error: function(e) {
			console.log("ERROR: ", e);
		},
	});
}
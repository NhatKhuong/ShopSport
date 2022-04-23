function deleteUser() {
  // set variables into javascript object which you need to send to spring controller
  // the variable name here should be same as it is in your java class UserDetails.java

  $.ajax({
    type: "GET",
    url: contextPath + "/gio-hang/san-pham",
    dataType: "json",
    contentType: "application/json",
    success: function (data) {
      console.log(data);
    },
    error: function (e) {
      console.log(e);
      alert("error");
    },
  });
}
deleteUser();
function loadDataTinhThanhPho() {}

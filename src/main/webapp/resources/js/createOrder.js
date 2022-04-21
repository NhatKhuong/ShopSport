function deleteUser() {
  // set variables into javascript object which you need to send to spring controller
  // the variable name here should be same as it is in your java class UserDetails.java

  var user = new Object();
  user.userId = 120; // id of user to be deleted

  $.ajax({
    type: "GET",
    url: contextPath + "/dia-chi/danh-sach-dia-chi",
    dataType: "json",
    contentType: "application/json",
    success: function (data) {
      console.log(data);
    },
    error: function () {
      alert("error");
    },
  });
  // fetch(contextPath + "/dia-chi/danh-sach-dia-chi")
  //   .then((response) => response.json())
  //   .then((data) => {
  //     // code
  //     console.log(data);
  //   })
  //   .catch((e) => {
  //     console.log(e);
  //   });
}
deleteUser();

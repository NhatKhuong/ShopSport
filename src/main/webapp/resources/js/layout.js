function quantityPluss() {
  var quantityTotal = document.getElementById("soLuongTon").textContent;
  var quantityCurrent = document.getElementById("quantity").textContent;

  $.ajax({
    type: "GET",
    contentType: "application/json",
    url: contextPath + "/san-pham/so-luong-ton/tang",
    data: {
      quantityCurrent,
      quantityTotal,
    },
    dataType: "json",
    timeout: 100000,
    success: function (data) {
      console.log("SUCCESS: ", data);
      document.getElementById("quantity").innerText = data;
    },
    error: function (e) {
      console.log("ERROR: ", e);
    },
  });
}

function quantityPrivate() {
  var quantityTotal = document.getElementById("soLuongTon").textContent;
  var quantityCurrent = document.getElementById("quantity").textContent;

  $.ajax({
    type: "GET",
    contentType: "application/json",
    url: contextPath + "/san-pham/so-luong-ton/giam",
    data: {
      quantityCurrent,
      quantityTotal,
    },
    dataType: "json",
    timeout: 100000,
    success: function (data) {
      console.log("SUCCESS: ", data);
      document.getElementById("quantity").innerText = data;
    },
    error: function (e) {
      console.log("ERROR: ", e);
    },
  });
}

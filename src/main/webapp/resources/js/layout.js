<<<<<<< HEAD
function quantityPluss(e, quantityTotal) {
    var quantityCurrent = e.parentElement.querySelector(".quantity-number");

    if (!quantityTotal) {
        quantityTotal = document.getElementById("soLuongTon").innerText;
        console.log(document.getElementById("soLuongTon").innerText);
    }
    console.log({ quantityTotal });
    if (+quantityCurrent.innerText < +quantityTotal) {
        quantityCurrent.innerText = +quantityCurrent.innerText + 1;
    }
}

function quantityPrivate(e) {
    var quantityCurrent = e.parentElement.querySelector(".quantity-number");

    if (quantityCurrent.innerText > 0) {
        quantityCurrent.innerText = +quantityCurrent.innerText - 1;
    }
=======
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
>>>>>>> acf5b98e271a444cbc8ed7fcd1409e7e2ecf62aa
}







// Vote rating

(function voteRating() {
    var ratings = document.querySelectorAll(".rating-start");
    var ratingsInput = document.querySelectorAll(".rating-start");
    var indexRatingInput = document.querySelector(
        'input[name="rating-input"]:checked'
    ).value;
    var ratingsInput = document.querySelectorAll(".rating-input");
    //   set rating default
    vote(indexRatingInput);

    ratings.forEach((el) =>
        el.addEventListener("click", (event) => {
            var index = event.target.id[7];
            vote(index);
        })
    );
    function vote(index) {
        ratingsInput[index - 1].checked = true;
        for (let i = 0; i < index; i++) {
            ratings[i].className = "fa fa-star rating-start";
        }
        for (let i = index; i < 5; i++) {
            ratings[i].className = "fa fa-star-o rating-start";
        }
    }
})();
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
$(document).ready(function () {
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
$(document).ready(function () {
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

(() => {})();

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
        success: function (data) {
            console.log("SUCCESS: ", data);
            // var result =
            //   "<h3> You just add new Person </h3>" +
            //   "<strong>Name:</strong> " +
            //   data.name +
            //   "<br>" +
            //   "<strong>Age:</strong> " +
            //   data.age;
            // $("#ajax-response").html(result);

            document.getElementById("soLuongTon").innerText = data;
        },
        error: function (e) {
            console.log("ERROR: ", e);
        },
    });
}

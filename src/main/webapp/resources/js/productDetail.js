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

// owl-carousel
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

// 
$(document).ready(function () {
  $(".items-product-suggest.owl-carousel").owlCarousel({
    items: 5,
    animateOut: "fadeOut",
    nav: true,
    responsiveClass: true,
      loop:true,
    margin:10,
    autoplay:true,
    autoplayTimeout:3000,
    autoplayHoverPause:true,
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

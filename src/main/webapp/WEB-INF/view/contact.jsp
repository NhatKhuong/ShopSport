<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="ISO-8859-1">
                <title> --- </title>
                <link rel="stylesheet"
                    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                    crossorigin="anonymous" />

                <link rel="stylesheet" href="<c:url value='/resources/css/home.css' />">
                 <link rel="stylesheet" href="<c:url value='/resources/css/contact_styles.css' />">
            </head>


            <body>
                <div class="container--fluid">

                    <div id='header'>
                        <jsp:include page="components/header.jsp"></jsp:include>
                    </div>


                    <div class="components">
                        <!-- Body -->
                        <div class="container">
                            <!-- breadcrumb -->

                            <div class="breadcrumb-components">
                                <jsp:include page="components/breadcrumb.jsp"></jsp:include>
                            </div>
                            <!-- /breadcrumb -->

							
							
                <div class="row">
                    <div class="col">
                        <div id="google_map">
                            <div class="map_container">
                                <div id="map"></div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Contact Us -->

                <div class="row">
                    <div class="col-lg-6 contact_col">
                        <div class="contact_contents">
                            <h1>Contact Us</h1>
                            <p>
                                There are many ways to contact us. You may drop
                                us a line, give us a call or send an email,
                                choose what suits you the most.
                            </p>
                            <div>
                                <p>(800) 686-6688</p>
                                <p>info.deercreative@gmail.com</p>
                            </div>
                            <div>
                                <p>mm</p>
                            </div>
                            <div>
                                <p>Open hours: 8.00-18.00 Mon-Fri</p>
                                <p>Sunday: Closed</p>
                            </div>
                        </div>

                        <!-- Follow Us -->

                        <div class="follow_us_contents">
                            <h1>Follow Us</h1>
                            <ul class="social d-flex flex-row">
                                <li>
                                    <a
                                        href="#"
                                        style="background-color: #3a61c9"
                                        ><i
                                            class="fa fa-facebook"
                                            aria-hidden="true"
                                        ></i
                                    ></a>
                                </li>
                                <li>
                                    <a
                                        href="#"
                                        style="background-color: #41a1f6"
                                        ><i
                                            class="fa fa-twitter"
                                            aria-hidden="true"
                                        ></i
                                    ></a>
                                </li>
                                <li>
                                    <a
                                        href="#"
                                        style="background-color: #fb4343"
                                        ><i
                                            class="fa fa-google-plus"
                                            aria-hidden="true"
                                        ></i
                                    ></a>
                                </li>
                                <li>
                                    <a
                                        href="#"
                                        style="background-color: #8f6247"
                                        ><i
                                            class="fa fa-instagram"
                                            aria-hidden="true"
                                        ></i
                                    ></a>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-lg-6 get_in_touch_col">
                        <div class="get_in_touch_contents">
                            <h1>Get In Touch With Us!</h1>
                            <p>
                                Fill out the form below to recieve a free and
                                confidential.
                            </p>
                            <form action="post">
                                <div>
                                    <input
                                        id="input_name"
                                        class="form_input input_name input_ph"
                                        type="text"
                                        name="name"
                                        placeholder="Name"
                                        required="required"
                                        data-error="Name is required."
                                    />
                                    <input
                                        id="input_email"
                                        class="form_input input_email input_ph"
                                        type="email"
                                        name="email"
                                        placeholder="Email"
                                        required="required"
                                        data-error="Valid email is required."
                                    />
                                    <input
                                        id="input_website"
                                        class="form_input input_website input_ph"
                                        type="url"
                                        name="name"
                                        placeholder="Website"
                                        required="required"
                                        data-error="Name is required."
                                    />
                                    <textarea
                                        id="input_message"
                                        class="input_ph input_message"
                                        name="message"
                                        placeholder="Message"
                                        rows="3"
                                        required
                                        data-error="Please, write us a message."
                                    ></textarea>
                                </div>
                                <div>
                                    <button
                                        id="review_submit"
                                        type="submit"
                                        class="red_button message_submit_btn trans_300"
                                        value="Submit"
                                    >
                                        send message
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Newsletter -->

            <div class="newsletter">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6">
                            <div
                                class="newsletter_text d-flex flex-column justify-content-center align-items-lg-start align-items-md-center text-center"
                            >
                                <h4>Newsletter</h4>
                                <p>
                                    Subscribe to our newsletter and get 20% off
                                    your first purchase
                                </p>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <form action="post">
                                <div
                                    class="newsletter_form d-flex flex-md-row flex-column flex-xs-column align-items-center justify-content-lg-end justify-content-center"
                                >
                                    <input
                                        id="newsletter_email"
                                        type="email"
                                        placeholder="Your email"
                                        required="required"
                                        data-error="Valid email is required."
                                    />
                                    <button
                                        id="newsletter_submit"
                                        type="submit"
                                        class="newsletter_submit_btn trans_300"
                                        value="Submit"
                                    >
                                        subscribe
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
							


                            <!-- /Body -->
                        </div>
                    </div>
                    <div id='footer'>
                        <jsp:include page="components/footer.jsp"></jsp:include>
                    </div>


                </div>
                <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
                    crossorigin="anonymous"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                    crossorigin="anonymous"></script>
                    <script src="<c:url value='/resources/js/contact_custom.js'/>" data-cover></script>
                   <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyCIwF204lFZg1y4kPSIhKaHEXMLYxxuMhA"></script>
            </body>

            </html>
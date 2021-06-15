<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Bootstrap Testimonial Carousel</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700|Open+Sans">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style>
      body {
        font-family: "Open Sans", sans-serif;
      }
      h2 {
        color: #333;
        text-align: center;
        text-transform: uppercase;
        font-family: "Roboto", sans-serif;
        font-weight: bold;
        position: relative;
        margin: 30px 0 60px;
      }
      h2::after {
        content: "";
        width: 100px;
        position: absolute;
        margin: 0 auto;
        height: 3px;
        background: #8fbc54;
        left: 0;
        right: 0;
        bottom: -10px;
      }
      .col-center {
        margin: 0 auto;
        float: none !important;
      }
      .carousel {
        padding: 0 70px;
      }
      .carousel .carousel-item {
        color: #999;
        font-size: 14px;
        text-align: center;
        overflow: hidden;
        min-height: 290px;
      }
      .carousel .carousel-item .img-box {
        width: 135px;
        height: 135px;
        margin: 0 auto;
        padding: 5px;
        border: 1px solid #ddd;
        border-radius: 50%;
      }
      .carousel .img-box img {
        width: 100%;
        height: 100%;
        display: block;
        border-radius: 50%;
      }
      .carousel .testimonial {
        padding: 30px 0 10px;
      }
      .carousel .overview {
        font-style: italic;
      }
      .carousel .overview b {
        text-transform: uppercase;
        color: #7AA641;
      }
      .carousel-control-prev, .carousel-control-next {
        width: 40px;
        height: 40px;
        margin-top: -20px;
        top: 50%;
        background: none;
      }
      .carousel-control-prev i, .carousel-control-next i {
        font-size: 68px;
        line-height: 42px;
        position: absolute;
        display: inline-block;
        color: rgba(0, 0, 0, 0.8);
        text-shadow: 0 3px 3px #e6e6e6, 0 0 0 #000;
      }
      .carousel-indicators {
        bottom: -40px;
      }
      .carousel-indicators li, .carousel-indicators li.active {
        width: 12px;
        height: 12px;
        margin: 1px 3px;
        border-radius: 50%;
        border: none;
      }
      .carousel-indicators li {
        background: #999;
        border-color: transparent;
        box-shadow: inset 0 2px 1px rgba(0,0,0,0.2);
      }
      .carousel-indicators li.active {
        background: #555;
        box-shadow: inset 0 2px 1px rgba(0,0,0,0.2);
      }
    </style>
  </head>
  <body>
  <jsp:include page="navbar.jsp"></jsp:include>
  <div class="container-xl">
    <div class="row">
      <div class="col-lg-8 mx-auto">
        <h2>Testimonials</h2>
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
          <!-- Carousel indicators -->
          <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
          </ol>
          <!-- Wrapper for carousel items -->
          <div class="carousel-inner">
            <div class="carousel-item active">
              <div class="img-box"><img src="img/n.jpg" alt=""></div>
              <p class="testimonial">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam eu sem tempor, varius quam at, luctus dui. Mauris magna metus, dapibus nec turpis vel, semper malesuada ante. Idac bibendum scelerisque non non purus. Suspendisse varius nibh non aliquet.</p>
              <p class="overview"><b>Paula Wilson</b>, Media Analyst</p>
            </div>
            <div class="carousel-item">
              <div class="img-box"><img src="img/nn.jpg" alt=""></div>
              <p class="testimonial">Vestibulum quis quam ut magna consequat faucibus. Pellentesque eget nisi a mi suscipit tincidunt. Utmtc tempus dictum risus. Pellentesque viverra sagittis quam at mattis. Suspendisse potenti. Aliquam sit amet gravida nibh, facilisis gravida odio.</p>
              <p class="overview"><b>Antonio Moreno</b>, Web Developer</p>
            </div>
            <div class="carousel-item">
              <div class="img-box"><img src="img/nnn.jpg" alt=""></div>
              <p class="testimonial">Phasellus vitae suscipit justo. Mauris pharetra feugiat ante id lacinia. Etiam faucibus mauris id tempor egestas. Duis luctus turpis at accumsan tincidunt. Phasellus risus risus, volutpat vel tellus ac, tincidunt fringilla massa. Etiam hendrerit dolor eget rutrum.</p>
              <p class="overview"><b>Michael Holz</b>, Seo Analyst</p>
            </div>
          </div>
          <!-- Carousel controls -->
          <a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
            <i class="fa fa-angle-left"></i>
          </a>
          <a class="carousel-control-next" href="#myCarousel" data-slide="next">
            <i class="fa fa-angle-right"></i>
          </a>
        </div>
      </div>
    </div>
  </div>
  <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>

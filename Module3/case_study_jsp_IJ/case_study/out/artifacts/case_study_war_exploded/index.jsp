
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
  </head>
  <body>
  <header>
    <div class="container-fluid bg-info ">
      <div class="row d-flex">
        <div class="col-lg-8 ">
          <div>
            <img src="view/img/logo.jpg" style="height: 100px;width: 100px">
          </div>
        </div>
        <div class="col-lg-4">
          <div class="m-3">
            <h1>Hoàng Phạm Đông</h1>
          </div>
        </div>
      </div>
    </div>
  </header>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item">
          <a class="nav-link disabled mx-5" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link mx-5" href="#">Employee</a>
        </li>
        <li class="nav-item">
          <a class="nav-link mx-5" href="/customer?action">Customer</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled mx-5" href="#">Service</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled mx-5" href="#">Contract</a>
        </li>
      </ul>
    </div>
    <form class="form-inline my-2 my-lg-0 mr-5">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </nav>
  <main>
    <div class="container">
      <div class="row">
        <div class="col-4">
          <div class="row my-5">
            <div class="col-12">
              <p>item One</p>
            </div>
          </div>
          <div class="row my-5">
            <div class="col-12">
              <p>item Two</p>
            </div>
          </div>
          <div class="row my-5">
            <div class="col-12">
              <p>item Three</p>
            </div>
          </div>
        </div>
        <div class="col-8">
          <h1>Body</h1>
        </div>
      </div>
    </div>
  </main>
  <fooder>
    <div class="row bg-dark mt-3">
      <div class="col-12">
        <div class="pl-5">
          <h1>Footer</h1>
        </div>
      </div>

    </div>
  </fooder>
  </body>
</html>

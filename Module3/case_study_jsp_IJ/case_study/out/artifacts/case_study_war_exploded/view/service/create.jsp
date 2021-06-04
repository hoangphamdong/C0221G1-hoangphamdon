<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="web/bootstrap/css/bootstrap.min.css"/>
    <style>
        html, body {
            min-height: 100%;
        }

        body, div, form, input, select, textarea, label {
            padding: 0;
            margin: 0;
            outline: none;
            font-family: Roboto, Arial, sans-serif;
            font-size: 14px;
            color: #666;
            line-height: 22px;
        }

        h1 {
            position: absolute;
            margin: 0;
            font-size: 50px;
            color: #fff;
            z-index: 2;
            line-height: 83px;
        }

        legend {
            padding: 10px;
            font-family: Roboto, Arial, sans-serif;
            font-size: 18px;
            color: #fff;
            background-color: #006622;
        }

        textarea {
            width: calc(100% - 12px);
            padding: 5px;
        }

        .testbox {
            display: flex;
            justify-content: center;
            align-items: center;
            height: inherit;
            padding: 20px;
        }

        form {
            width: 100%;
            padding: 20px;
            border-radius: 6px;
            background: #fff;
            box-shadow: 0 0 8px #006622;
        }

        .banner {
            position: relative;
            height: 250px;
            /*background-image: url("/uploads/media/default/0001/02/b23a2c8c49b8e43249487140e4c2e22a63bd7cb8.jpeg");*/
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
        }

        .banner::after {
            content: "";
            background-color: rgba(0, 0, 0, 0.4);
            position: absolute;
            width: 100%;
            height: 100%;
        }

        input, select, textarea {
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input {
            width: calc(100% - 10px);
            padding: 5px;
        }

        input[type="date"] {
            padding: 4px 5px;
        }

        textarea {
            width: calc(100% - 12px);
            padding: 5px;
        }

        .item:hover p, .item:hover i, .question:hover p, .question label:hover, input:hover::placeholder {
            color: #006622;
        }

        .item input:hover, .item select:hover, .item textarea:hover {
            border: 1px solid transparent;
            box-shadow: 0 0 3px 0 #006622;
            color: #006622;
        }

        .item {
            position: relative;
            margin: 10px 0;
        }

        .item span {
            color: red;
        }

        input[type="date"]::-webkit-inner-spin-button {
            display: none;
        }

        .item i, input[type="date"]::-webkit-calendar-picker-indicator {
            position: absolute;
            font-size: 20px;
            color: #00b33c;
        }

        .item i {
            right: 1%;
            top: 30px;
            z-index: 1;
        }

        .week {
            display: flex;
            justify-content: space-between;
        }

        .columns {
            display: flex;
            justify-content: space-between;
            flex-direction: row;
            flex-wrap: wrap;
        }

        .columns div {
            width: 48%;
        }

        [type="date"]::-webkit-calendar-picker-indicator {
            right: 1%;
            z-index: 2;
            opacity: 0;
            cursor: pointer;
        }

        input[type=radio], input[type=checkbox] {
            display: none;
        }

        label.radio {
            position: relative;
            display: inline-block;
            margin: 5px 20px 15px 0;
            cursor: pointer;
        }

        .question span {
            margin-left: 30px;
        }

        .question-answer label {
            display: block;
        }

        label.radio:before {
            content: "";
            position: absolute;
            left: 0;
            width: 17px;
            height: 17px;
            border-radius: 50%;
            border: 2px solid #ccc;
        }

        input[type=radio]:checked + label:before, label.radio:hover:before {
            border: 2px solid #006622;
        }

        label.radio:after {
            content: "";
            position: absolute;
            top: 6px;
            left: 5px;
            width: 8px;
            height: 4px;
            border: 3px solid #006622;
            border-top: none;
            border-right: none;
            transform: rotate(-45deg);
            opacity: 0;
        }

        input[type=radio]:checked + label:after {
            opacity: 1;
        }

        .flax {
            display: flex;
            justify-content: space-around;
        }

        .btn-block {
            margin-top: 10px;
            text-align: center;
        }

        button {
            width: 150px;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background: #006622;
            font-size: 16px;
            color: #fff;
            cursor: pointer;
        }

        button:hover {
            background: #00b33c;
        }

        @media (min-width: 568px) {
            .name-item, .city-item {
                display: flex;
                flex-wrap: wrap;
                justify-content: space-between;
            }

            .name-item input, .name-item div {
                width: calc(50% - 20px);
            }

            .name-item div input {
                width: 97%;
            }

            .name-item div label {
                display: block;
                padding-bottom: 5px;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark my-3">
        <div class="collapse navbar-collapse justify-content-center" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customer">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/service">Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contract</a>
                </li>
            </ul>
            <form class="d-flex " style="margin-left: 400px">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success ml-3" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>
<div class="my-3"style="width: 300px;margin-left: 85px">
    <form action="/service">
        <input class="btn btn-outline-success ml-3" type="submit" value="Back To List Service"/>
    </form>
</div>
<div class="testbox container">
    <form action="/service?action=create" method="post">
        <div class="banner">
            <h1>ADD New Service Form</h1>
        </div>
        <br/>
        <fieldset>
            <legend>Reservation Details</legend>
            <div class="columns">
                <div class="item">
                    <label for="fname">Service Name<span>*</span></label>
                    <input id="fname" type="text" name="serviceName"/>
                </div>
                <div class="item">
                    <label for="lname">Service Area<span>*</span></label>
                    <input id="lname" type="text" name="serviceArea"/>
                </div>
                <div class="item">
                    <label for="address">Service Cost<span>*</span></label>
                    <input id="address" type="text" name="serviceCost"/>
                </div>
                <div class="item">
                    <label for="zip">Service Max people<span>*</span></label>
                    <input id="zip" type="text" name="serviceMaxPeople" required/>
                </div>
                <div class="item">
                    <label for="city">Rent Type ID<span>*</span></label>
                    <input id="city" type="text" name="rentTypeID"/>
                </div>
                <div class="item">
                    <label for="state">Service Type ID<span>*</span></label>
                    <input id="state" type="text" name="serviceTypeId"/>
                </div>
                <div class="item">
                    <label for="eaddress">Standard Room<span>*</span></label>
                    <input id="eaddress" type="text" name="standardRoom"/>
                </div>
                <div class="item">
                    <label for="phone">Description Other Convenience<span>*</span></label>
                    <input id="phone" type="tel" name="description"/>
                </div>
                <div class="item">
                    <label for="eaddress">Pool Area<span>*</span></label>
                    <input id="1" type="text" name="poolArea"/>
                </div>
                <div class="item">
                    <label for="phone">Number Of Floors<span>*</span></label>
                    <input id="2" type="tel" name="floors"/>
                </div>
            </div>
        </fieldset>
        <br/>

        <div class="btn-block">
            <button type="submit" href="/">Submit</button>
        </div>
    </form>
</div>
</body>
</html>

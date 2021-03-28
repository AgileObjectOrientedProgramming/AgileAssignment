<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <title>Hello, world!</title>
  </head>

  <body>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm"
      style="justify-content: space-between;">
      <h5 class="my-0 mr-md-auto font-weight-normal">ForYouShipment</h5>
      <div class="d-flex flex-column flex-md-row align-items-center">
        <nav class="my-2 my-md-0 mr-md-3">
          <c:if test="${param.TopBarUsername != null}">
            <a class="p-2 text-dark" href="#">Orders</a>
            <a class="p-2 text-dark" href="#">${param.TopBarUsername}</a>
          </c:if>
          <!-- <a class="p-2 text-dark" href="/Users/Index">Users</a>
          <a class="p-2 text-dark" href="/Users/New">New User</a> -->
        </nav>
        <c:if test="${param.TopBarUsername != null}">
          <a class="btn btn-outline-primary" href="/Login/Logout">Log out</a>
        </c:if>
        <c:if test="${param.TopBarUsername == null}">
          <a class="btn btn-outline-primary" href="/Signup">Sign up</a>
          <a class="btn btn-outline-primary" href="/Login">Log in</a>
        </c:if>
      </div>
    </div>
    <div>
      <main style="padding-left: 10%;">
<!-- <html>
<head>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
  <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</head>

<body>
  <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
    <header class="mdl-layout__header">
      <div class="mdl-layout__header-row">
        Title -->
        <!-- <span class="mdl-layout-title">Title</span>
         Add spacer, to align navigation to the right -->
        <!-- <div class="mdl-layout-spacer"></div>
        Navigation. We hide it in small screens. -->
        <!-- <nav class="mdl-navigation mdl-layout--large-screen-only">
          <a class="mdl-navigation__link" href="/Home/Index">Index</a>
          <a class="mdl-navigation__link" href="/Users/Index">Users</a>
          <a class="mdl-navigation__link" href="/Users/New">New User</a>
          <a class="mdl-navigation__link" href="">Link</a>
        </nav>
      </div>
    </header>
    <div class="mdl-layout__drawer">
      <span class="mdl-layout-title">Title</span>
      <nav class="mdl-navigation">
        <a class="mdl-navigation__link" href="">Link</a>
        <a class="mdl-navigation__link" href="">Link</a>
        <a class="mdl-navigation__link" href="">Link</a>
        <a class="mdl-navigation__link" href="">Link</a>
      </nav>
    </div>
    <main class="mdl-layout__content" style="padding-left: 5%;"> -->

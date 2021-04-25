<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>



<h2>Your Journey information</h2> 

<button onclick="myFunction()">Get ID</button>
<style>
  .tooltip {
  position: relative;
  display: inline-block;
}

.tooltip .tooltiptext {
  visibility: hidden;
  width: 140px;
  background-color: #555;
  color: #fff;
  text-align: center;
  border-radius: 6px;
  padding: 5px;
  position: absolute;
  z-index: 1;
  bottom: 150%;
  left: 50%;
  margin-left: -75px;
  opacity: 0;
  transition: opacity 0.3s;
}

.tooltip .tooltiptext::after {
  content: "";
  position: absolute;
  top: 100%;
  left: 50%;
  margin-left: -5px;
  border-width: 5px;
  border-style: solid;
  border-color: #555 transparent transparent transparent;
}

.tooltip:hover .tooltiptext {
  visibility: visible;
  opacity: 1;
}
</style>

  <c:if test="${SignedUser.IsLogisticUser()}">
  <a class="btn btn-warning btn-lg" submit="${Journey.setStatus('Active')}" onclick="window.confirm('Are you sure you want to confirm the journey');">
      Confirm Shipment
  </a>
  <a class="btn btn-warning btn-lg" href="/Journey/Measurements?ID=${ContainerID}" >
      Set Measurements
  </a>
  </c:if>

  <c:if test="${warning != null}">
    <div class="alert alert-danger" role="alert">
        ${warning}
    </div>
  </c:if>
  
    <style type="text/css">
      /* Set the size of the div element that contains the map */
      #map {
        height: 400px;
        /* The height is 400 pixels */
        width: 80%;
        /* The width is the width of the web page */
      }
    </style>
    <script>
      var current_lat = "${Latitude}"
      var current_lng = "${Longitude}"
      var markers = [
        <c:forEach var="marker" items="${ports}">
            ['<c:out value="${marker.toString()}" />',
              <c:out value="${marker.getLatitude()}" />,
              <c:out value="${marker.getLongitude()}" />,
            ],
        </c:forEach>   ]; 
      // Initialize and add the map
      function initMap() {
        // Initialize the map and center it in the container location
        const map = new google.maps.Map(document.getElementById("map"), {
          zoom: 2,
          center: new google.maps.LatLng(current_lat,current_lng),
        });
        // The marker, positioned at the shipment location
        const marker =  new google.maps.Marker({
          opacity: 1,
          label: "Your shipment is here",
          animation: google.maps.Animation.DROP,
          dragable: true,
          position: new google.maps.LatLng(current_lat,current_lng),
          zIndex: 2,
          map: map,
          icon: {
            url: "http://maps.google.com/mapfiles/ms/icons/blue-dot.png"
          }
        })
        marker.addListener("click", toggleBounce);
        // Markers for all the ports
        for (i = 0; i < markers.length; i++){
          const marker = new google.maps.Marker({
            icon: "/anchor-32.png",
            label: markers[i][0],
            position: new google.maps.LatLng(markers[i][1],markers[i][2]),
            zIndex: 1,
            map: map,
          });
        }

      }
      function toggleBounce() {
        if (marker.getAnimation() !== null) {
         marker.setAnimation(null);
        } 
        else {
          marker.setAnimation(google.maps.Animation.BOUNCE);
        }
      }
      function myFunction() {
        var url = window.location.href;
        var copyText1 = url.substring(url.lastIndexOf('=') + 1);
        var copyText = new DOMParser().parseFromString(copyText1, "text/xml");
        //var copyText = url.substring(url.lastIndexOf('=') + 1);
        //var copyText = "document.URL";
        console.log(copyText);
        copyText.select();
        copyText.setSelectionRange(0, 99999);
        document.execCommand("copy");
        
        var tooltip = document.getElementById("myTooltip");
        tooltip.innerHTML = "Copied: " + copyText.value;
      }
    </script>
  </head>
  <body>
    <h3>Journey Map</h3>
    <!--The div element for the map -->
    <div id="map"></div>

    <!-- Async script executes immediately and must be after any DOM elements used in callback. -->
    <script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAPxzk8oahETNTmTJPn39scuPoHIj_yZSY&callback=initMap&libraries=&v=weekly"
      async
    ></script>

<jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Shared/MainLayoutTop.jsp"> 
    <jsp:param name="SignedUser" value="${SignedUser}"/>
</jsp:include>

<h2> All Journeys</h2>

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
        var containers = [
          <c:forEach var="container" items="${Containers}">
              ['<c:out value="Journey" />',
                <c:out value="${Double.parseDouble(container.getParameter('Latitude'))}" />,
                <c:out value="${Double.parseDouble(container.getParameter('Longitude'))}" />,
              ],
          </c:forEach>   ]; 

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
            zoom: 1,
            center: new google.maps.LatLng(10,10),
          });
          
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
          
          for (i = 0; i < containers.length; i++){
            console.log("im here");
            console.log(containers[i][1])
            const marker = new google.maps.Marker({
              icon: "/packageicon.png",
              label: containers[i][0],
              position: new google.maps.LatLng(containers[i][1],containers[i][2]),
              zIndex: 2,
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
          var dummy = document.createElement('input'),
          text = window.location.href;
  
          document.body.appendChild(dummy);
          dummy.value = text;
          dummy.select();
          document.execCommand('copy');
          document.body.removeChild(dummy);
        }
  
        
      </script>
     </head>
     <body>
  
      <button type="button" class="btn btn-secondary" id="liveToastBtn" data-toggle="tooltip" data-placement="top" title="Tooltip on top" onclick="myFunction()">Get ID</button>
      <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 5">
        <div id="liveToast" class="toast hide" role="alert" aria-live="assertive" aria-atomic="true">
          <div class="toast-header">
            <img src="..." class="rounded me-2" alt="...">
            <strong class="me-auto">Bootstrap</strong>
            <small>11 mins ago</small>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
          </div>
          <div class="toast-body">
            Hello, world! This is a toast message.
          </div>
        </div>
      </div>
      <br>
      <h3>Journey Map</h3>
      <!--The div element for the map -->
      <div id="map"></div>
      
    
      <!-- Async script executes immediately and must be after any DOM elements used in callback. -->
      <script
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAPxzk8oahETNTmTJPn39scuPoHIj_yZSY&callback=initMap&libraries=&v=weekly"
        async
      ></script>

      <jsp:include page="../Shared/MainLayoutBottom.jsp"></jsp:include>

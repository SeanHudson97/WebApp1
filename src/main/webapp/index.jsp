<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  </script>
          <!--Import JQuery API from Google-->
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  
  
  <!-- Setting up menu bar -->
  <div id ="SideMenuBar" class="sidemenu">
    <a href="javascript:void(0)" class="close" onclick="closeMenu()">&times;</a> 
    <a href="index.html">Home</a>
    <a href="trend.html">Latest Trends</a>
    <a href="register.html">Register</a>
    <a href="shop.html">Shop</a>
    <a href="library.html">Library</a>
    <a href="contact.html">Contact</a>
  </div>
    <!-- Open Menu on mouse hover -->
    <span style = "font-size:50px; cursor:pointer" onmouseover="openMenu()">&#9776;</span>

    <!--Javascript to open and close side menu-->
    <script>
      function openMenu() {
        document.getElementById("SideMenuBar").style.width = "300px";
        document.getElementById("mainPage").style.marginLeft = "300px";
      }
      
      function closeMenu() {
        document.getElementById("SideMenuBar").style.width = "0";
        document.getElementById("mainPage").style.marginLeft = "0";   
      }
      </script>
 
  <!--Putting page content in one class so menu can push this to the side when opened-->
  <div id="mainPage">
    <head>
        <link rel="stylesheet" href="cssfiles/indexstylesheet.css">
        <div class="header">
        <h1> <img src="images/record.jpg" width="200" height="80">The Record Vault </h1>
        <p class ="p1">Welcome to the Record Vault!</p>
        <p class ="p1">Log in to get started and buy your favorite records!</p>
        </div>
    </head>
    <body style="background-color: antiquewhite;">

        <ul>
          <li><a href="index.html">Home</a></li>
          <li><a href="trend.html">What's Trending</a></li>
          <li class="dd">
            <a href="javascript:void(0)" class="dropbtn">Account</a>
            <div class="dd-content">
              <a href="login.html">Log In</a>
              <a href="register.html">Register</a>
              <a href="logout.html">Log Out</a>
            </div>
          </li>
          <li><a href="shop.html">Shop</a></li>
          <li><a href="library.html">Library</a></li>
          <li><a href="contact.html">Contact Us</a></li>
          </ul>

          <div class="intro">
            <article>
              <h2>About Us</h2>
              <!--Changing this text on clicking -->
              <p onclick="changeText(this)">The Record Vault is a brand new music platform allowing you to browse<br> 
                and listen to all your favourite songs! Click this paragraph for more!</p>
                <script>
                  //This will reveal a new paragraph in place of the old
                  function changeText(id) {
                  id.innerHTML = "Browse whats trending below then checkout our shop where you can add your favorite hits to your own library!";
                  }
                </script>
            </article>
          </div>

          <h2 class="h2">Check out the newly released singles below!</h2>

          <div class="vid1">
            <iframe width="420" height="315"
            src="https://www.youtube.com/embed/3AoOfJP3r40?controls=1">
            </iframe> 
            <p class="p2">Fontaines DC's new single for their upcoming album!</p>
          </div>

          <div class="vid1">
            <iframe width="420" height="315"
            src="https://www.youtube.com/embed/SXZ_2MnnrQQ?controls=1">
            </iframe> 
            <p class="p2">Gemma Dunleavy's new single!</p>
          </div>
          
    </body>
  </div>
</html>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Monster Contacts</title>

  <!-- Bootstrap core CSS -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="assets/css/heroic-features.css" rel="stylesheet">
  
	<link href="https://fonts.googleapis.com/css2?family=Bigelow+Rules&display=swap" rel="stylesheet">

</head>

<body>

  <!-- Page Content -->
  <div class="container">

    <!-- Jumbotron Header -->
    <header id="jumbotron" class="jumbotron my-4">
      <h1 id="heroicHeader" class="display-3">Monster Contacts</h1>
    </header>

    <!-- Page Features -->
    <div id="userList" class="row text-center">

      

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
    </div>
    <!-- /.container -->
  </footer>
  
  <div id="detailsModal" class="modal fade" tabindex="-1">
       <div class="modal-dialog">
           <div class="modal-content">
               <div class="modal-header">
                   <h5 id='userName' class="modal-title"></h5>
                   <button type="button" class="close" data-dismiss="modal">&times;</button>
               </div>
               <div class="modal-body">
               	<label>Email</label>
               	<p id='userEmail' class="text-secondary"></p>
               	<label>Phone</label>
               	<p id='userPhone' class="text-secondary"></p>
               	<label>Website</label>
               	<p id='userWebsite' class="text-secondary"></p>
               	<label>City</label>
               	<p id='userCity' class="text-secondary"></p>
               </div>
               <div class="modal-footer">
                   <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
               </div>
           </div>
       </div>
  	</div>

  <!-- Bootstrap core JavaScript -->
  <script src="assets/vendor/jquery/jquery.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/js/scripts.js"></script>

</body>

</html>

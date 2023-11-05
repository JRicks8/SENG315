$(document).ready(function() {
	getItems();
});

//Client side API call using AJAX
function getItems(){
	
	$.ajax({
		url: "./webapi/items",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	$.each(response, function(key, value) {
    		
    		var lstResults = "<div class='col mb-5'>" +
        "    <div class='card h-100'>" +
        "        <!-- Product image-->" +
        "        <img class='card-img-top' src='https://dummyimage.com/450x300/dee2e6/6c757d.jpg' alt='...' />" +
        "        <!-- Product details-->" +
        "        <div class='card-body p-4'>" +
        "            <div class='text-center'>" +
        "                <!-- Product name-->" +
        "                <h5 class='fw-bolder'>" + value.name + "</h5>" +
        "                <!-- Product price-->" +
        "                $" + value.price + "<br>" +
        "                " + value.description + "\n" +
        "            </div>" +
        "        </div>" +
        "        <!-- Product actions-->" +
        "        <div class='card-footer p-4 pt-0 border-top-0 bg-transparent'>" +
        "            <div class='text-center'><a class='btn btn-outline-dark mt-auto' href='#' onclick=editItem('"+value.id+"')>Edit Item</a></div>" +
        "            <div class='text-center'><a class='btn btn-outline-dark mt-auto' href='#' onclick=deleteItem('"+value.id+"')>Delete Item</a></div>" +
        "        </div>" +
        "    </div>" +
        "</div>"
       	
       	if ($("#itemsContainer").text()) {
					 document.getElementById('itemsContainer').innerHTML += lstResults;
			 	}
    	});
	});
}

function addItem() {
	var itemName = $("#itemName").val();
	var itemDescription = $("#itemDescription").val();
	var itemPrice = $("#itemPrice").val();
	
	if (itemName == "") {
		alert("Item Name cannot be blank");
		$("#itemName").focus();
		return;
	}
	
	if (itemDescription == "") {
		alert("Item Description cannot be blank");
		$("#itemDescription").focus();
		return;
	}
	
	if (itemPrice == "") {
		alert("item Price cannot be blank");
		$("#itemPrice").focus();
		return;
	}
	
	var parms = { name:itemName, description:itemDescription, price:itemPrice };
	
	$.ajax({
		url: "./webapi/items",
		type: 'POST',
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify)
	}).done(function(response){
		window.location="./index.html";
	});
}

function deleteItem(id) {
	$.ajax({
		url: "./webapi/items/"+id,
		type: 'DELETE',
	}).fail(function(response) {
		console.log(JSON.stringify(response));
  }).done(function(response){
		window.location="./index.html";
	});
}

function editItem(id) {
	
	$("#editModal").modal('show');
	
	$.ajax({
		url: "./webapi/items/"+id,
		type: 'GET',
		contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));
		console.log("Get Error");
  }).done(function(response){
		console.log(response);
		$("#itemID").val(response.id);
		$("#itemName").val(response.name);
		$("#itemDescription").val(response.description);
		$("#itemPrice").val(response.price);
	});
}

function updateItem() {
	var itemID = $("#itemID").val();
	var itemName = $("#itemName").val();
	var itemDescription = $("#itemDescription").val();
	var itemPrice = $("#itemPrice").val();
	
	var parms = { id:itemID, name:itemName, description:itemDescription, price:itemPrice };
	
	$.ajax({
		url: "./webapi/items/"+itemID,
		type: 'PUT',
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));
  }).done(function(response){
		window.location="./index.html";
	});
}
var xhttp = new XMLHttpRequest();
function addCart(arg1, arg2) {
	console.log("title is " + arg1);
	console.log("id is " + arg2);
	xhttp.open("GET", "cart?title="+arg1+"&id="+arg2, true);
	xhttp.send();
	console.log(xhttp.statusText);

	var tdd = document.getElementById(arg1);
	var texttd = "title " + arg1 + " added to favourites ";
	var text = document.createTextNode(texttd);
	tdd.appendChild(text);

}
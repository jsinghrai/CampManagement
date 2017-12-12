<?php


if($_SERVER['REQUEST_METHOD']=='POST'){
	//connect to db
  	$oLink = mysqli_connect('localhost','root','') or die("Can't connect to MySQL server!");
	mysqli_select_db($oLink,'hospitalApp') or die("Can't select database!");

	// Search the rows in the markers table
	//change 3959 to 6371 for distance in KM
	$sql = "SELECT * FROM appointments WHERE  date='" . $_POST["date"] . "'";

	$result = mysqli_query($oLink,$sql);
	if(isset($result)){

	$rows = array();
	while($r = mysqli_fetch_assoc($result)) {
    	$rows[] = $r;
	}
	mysqli_close($oLink);

	echo json_encode($rows);
	}
	else{
echo "Invalid Username or Password Please Try Again !";
echo "$password";
}
	}

?>

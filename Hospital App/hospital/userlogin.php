<?php
// if($_SERVER['REQUEST_METHOD']=='POST'){

// $con=mysqli_connect("localhost","root","","hospitalApp");

// $username = $_POST['username'];
// $password = $_POST['password'];

// //$Sql_Query = "select * from users where username = '$username' and password = '$password'";

// $Sql_Query = "SELECT * FROM users WHERE username='$username' AND password='$password'";
// $res=mysqli_query($con,$Sql_Query);
// $response=array();
// //importing dbConnect.php script

// $check = mysqli_fetch_array(mysqli_query($con,$Sql_Query));

// if(isset($check)){

// echo "Data Matched";
// }
// else{
// echo "Invalid Username or Password Please Try Again !";
// echo "$password";
// }

// mysqli_close($con);
// }

if($_SERVER['REQUEST_METHOD']=='POST'){
	//connect to db
  	$oLink = mysqli_connect('localhost','root','') or die("Can't connect to MySQL server!");
	mysqli_select_db($oLink , 'hospitalApp') or die("Can't select database!");
	$username = $_POST['username'];
$password = $_POST['password'];
	// Search the rows in the markers table
	//change 3959 to 6371 for distance in KM
	$sql ="SELECT * FROM users WHERE username='$username' AND password='$password'";

	$result = mysqli_query($oLink, $sql);
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

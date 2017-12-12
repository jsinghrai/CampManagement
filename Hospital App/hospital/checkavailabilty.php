<?php
if($_SERVER['REQUEST_METHOD']=='POST'){	
$conn = mysql_connect('localhost','root','','hospitalApp');
mysql_select_db("hospitalApp",$conn);
//$result = mysql_query("SELECT * FROM candidates WHERE (username='" . $_POST["username"] . "' or email='" . $_POST["username"] . "') and password = '". sha1($_POST["password"])."'");
$result = mysql_query("SELECT * FROM appointments WHERE  date='" . $_POST["date"] . "'");
$row  = mysql_fetch_array($result);
if(is_array($row)) {
	$date = $row["date"];
	$name = $row["patient_name"];
echo "Booked";
print(json_encode($name)); 
//echo json_decode($name);

} else {
	echo "Available";

}
}

?>
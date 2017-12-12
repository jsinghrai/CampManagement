<?php
if($_SERVER['REQUEST_METHOD']=='POST'){

	$conn = mysqli_connect('localhost','root','');
	$db   = mysqli_select_db($conn, 'hospitalApp');

 $patient_name=$_POST['patient_name'];

		$date = $_POST['date'];
		$res= mysqli_query($conn,"SELECT * FROM appointments WHERE date='$date' AND patient_name = '$patient_name'");
		$row= mysqli_fetch_array($res);



		$date = $_POST['date'];
		$status = $_POST['status'];
		$id  	 = $_POST['id'];
		$sql     = "UPDATE appointments SET status='$status' WHERE date='$date' AND patient_name = '$patient_name'";
		$res 	 = mysqli_query($conn,$sql)
                                    or die("Could not update".mysqli_error());
		echo "<meta http-equiv='refresh' content='0;url=cancelappointment.php'>";
	}

?>

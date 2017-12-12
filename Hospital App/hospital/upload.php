<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		$image = $_POST['image'];
		$patient_name=$_POST['patient_name'];
$patient_email=$_POST['patient_email'];
$patient_phone=$_POST['patient_phone'];

		
		require_once('dbConnect.php');
		
		$sql ="SELECT id FROM photos ORDER BY id ASC";
		
		$res = mysqli_query($con,$sql);
		
		$id = 0;
		
		while($row = mysqli_fetch_array($res)){
				$id = $row['id'];
		}
		
		$path = "uploads/$id.png";
		
		$actualpath = "http://192.168.0.130/hospital/$path";
		
		//$sql = "INSERT INTO photos (image) VALUES ('$actualpath')";
		$sql = "INSERT INTO photos (patient_name,patient_email,patient_phone,image) VALUES ('".$patient_name."','".$patient_email."','".$patient_phone."','$actualpath')";
		if(mysqli_query($con,$sql)){
			file_put_contents($path,base64_decode($image));
			echo "Successfully Uploaded";
		}
		
		mysqli_close($con);
	}else{
		echo "Error";
	}
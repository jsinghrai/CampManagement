<?php 
 
include('hosp_conn.php');
//$uid=$_POST['uid'];
$patient_name=$_POST['patient_name'];
$patient_email=$_POST['patient_email'];
$doctor_name=$_POST['doctor_name'];
$doctor_email=$_POST['doctor_email'];
$date=$_POST['date'];
$status=$_POST['status'];



 $sql="select * from appointments where date='".$date."'";
$res=mysqli_query($conn,$sql);
$response=array();


 
if(mysqli_num_rows($res)>0)
  {
    $status="failed";
    $msg="Not available";
    array_push($response,array("status"=>$status,"msg"=>$msg));
    echo json_encode($response);
  }
else
  {
  
    $sql = "insert into appointments(patient_name,patient_email,doctor_name,doctor_email,date,status) 
    values('".$patient_name."','".$patient_email."','".$doctor_name."','".$doctor_email."','".$date."','".$status."')";
    mysqli_query($conn,$sql);
    $status="success";
    $msg="Its ".$username.". Confirmed.";
    array_push($response,array("status"=>$status,"msg"=>$msg));
    echo json_encode($response);
  }
 
 
 ?>
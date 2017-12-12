<?php 
 
include('hosp_conn.php');
$uid=$_POST['uid'];
$username=$_POST['username'];
$email=$_POST['email'];
$password=$_POST['password'];
$phone=$_POST['phone'];
$age=$_POST['age'];
$address=$_POST['address'];



 $sql="select * from users where email='".$email."'";
$res=mysqli_query($conn,$sql);
$response=array();


 
if(mysqli_num_rows($res)>0)
  {
    $status="failed";
    $msg="Already Registered";
    array_push($response,array("status"=>$status,"msg"=>$msg));
    echo json_encode($response);
  }
else
  {
   // $sql="insert into users(username,email,password,dept) values('".$username."','".$email."','".$password."','".$dept."')";

    $sql = "insert into users(uid,username,email,phone,password,age,address) values('".$uid."','".$username."','".$email."','".$phone."','".$password."','".$age."','".$address."')";
    mysqli_query($conn,$sql);
    $status="success";
    $msg="Hello ".$username.". You can login now.";
    array_push($response,array("status"=>$status,"msg"=>$msg));
    echo json_encode($response);
  }
 
 
 ?>
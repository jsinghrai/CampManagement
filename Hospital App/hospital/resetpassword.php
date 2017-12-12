<?php


$host='localhost';
  $uname='root';
  $pwd='';
  $db='hospitalApp';

  $con = mysqli_connect($host,$uname,$pwd) or die("connection failed");
  mysqli_select_db($db,$con) or die("db selection failed");


  $email=$_REQUEST['email'];
  $password=$_REQUEST['SHApassword'];

  $flag['code']=0;

  if($r=mysqli_query($con,"update users set password ='".$password."' where email ='".$email."'"))
  {
    $flag['code']=1;
    echo "Updated";


  }
  //print(json_encode($flag));
  echo json_encode($email);
  mysqli_close($con);

 ?>

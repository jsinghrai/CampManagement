<?php
$conn=mysqli_connect("localhost","root","","hospitalApp");
if(!$conn)
{
  echo "Failed to connect";
}
else {
	echo "success";
}
?>

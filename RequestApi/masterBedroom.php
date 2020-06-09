<?php

/*A read api that reads the master bedroom details from the database and prints 
it in json. So, the App can request for the data*/
define("DB_HOST", "localhost");
define("DB_USER", "root");
define("DB_PASSWORD", "");
define("DB_DATABASE", "motion");

$response2 = array();
$conn = new mysqli(DB_HOST, DB_USER, DB_PASSWORD, DB_DATABASE);
	
	//Checking if any error occured while connecting
	if (mysqli_connect_errno()) {
		echo "Failed to connect to MySQL: " . mysqli_connect_error();
		die();
	}

	$stmt = $conn->prepare("SELECT id, motion, time_detected FROM front_door ORDER BY id DESC LIMIT 1");
		$stmt->bind_result($id, $motion, $time);
		$stmt->execute();
		$response2["motion"] = array();
		while($stmt->fetch())
		{
			$info = array();
			// $temp = array();
			$info['id'] = $id;
			$info['motion_dev'] = $motion;
			$info['time_detected'] = $time;
			array_push($response["motion"], $info);
			// $response["success"] = $id;
		echo json_encode($response2);
		}
		

 
// array for JSON response
// $response = array();
 
// require_once 'include/DbConnect.php';
// $db = new DbConnect();
 
// // get all products from products table
// $result = mysql_query("SELECT id, motion, time_detected FROM front_door ORDER BY id") or die(mysql_error());
 
// // check for empty result
// if (mysql_num_rows($result) > 0) {
//     // looping through all results
//     // products node
//     $response["motion"] = array();
 
//     while ($row = mysql_fetch_array($result)) {
//         // temp user array
//         $info = array();
//         $info["id"] = $row["id"];
//         $info["motion"] = $row["motion"];
//         $info["time_detected"] = $row["time_detected"];
       
 
//         // push single product into final response array
//         array_push($response["motion"], $info);
//     }
//     // success
//     $response["success"] = 1;
 
//     // echoing JSON response
//     echo "<pre>";
//     echo json_encode($response);
// } else {
//     // no products found
//     $response["success"] = 0;
//     $response["message"] = "No products found";
 
//     // echo no users JSON
//     echo json_encode($response);
// }
?>
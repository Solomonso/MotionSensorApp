<?php
define("DB_HOST", "localhost");
define("DB_USER", "root");
define("DB_PASSWORD", "");
define("DB_DATABASE", "motion");

$response2 = array();
$conn = new mysqli(DB_HOST, DB_USER, DB_PASSWORD, DB_DATABASE);
if (mysqli_connect_errno()) {
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
    die();
}

$stmt = $conn->prepare("SELECT id, motion, time_detected FROM front_door ORDER BY id DESC LIMIT 1");
$stmt->bind_result($id, $motion, $time);
$stmt->execute();
$response2["motion"] = array();
while ($stmt->fetch()) {
    $info = array();
    $info['id'] = $id;
    $info['motion_dev'] = $motion;
    $info['time_detected'] = $time;
    array_push($response["motion"], $info);
    echo json_encode($response2);
}

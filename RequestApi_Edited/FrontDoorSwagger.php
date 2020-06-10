<?php
/*Retreive the motion detected from the front door device from swagger and insert it into mysql database*/

include 'library/Requests.php';

class FrontDoorSwagger
{
    private $conn;
    public $var;

    public function __construct()
    {
        require_once 'include/DbConnect.php';
        $db = new DbConnect();
        $this->conn = $db->connect();
    }

    public function request()
    {
        Requests::register_autoloader();
        $headers = array(
            'Accept' => 'application/json',
            'Authorization' => 'key ttn-account-v2.gs3ytj7xR4oT-qUbaVrLJjE0tnB3ArCaCR_ixH2bTGU',
        );
        $response = Requests::get('https://test-motion-sensor.data.thethingsnetwork.org/api/v2/query/front-door?last=7d', $headers);

        echo "{$response->body}\n";
        $myJson = json_decode($response->body, true);

        echo '<pre>';
        print_r($myJson);

        echo '<br>';
        echo '<pre>';
        print_r($myJson[0]['device_id']);
        echo "<br>";
        print_r($myJson[0]['raw']);

        //error below here
        $this->var = $myJson[30]['message'];
    }

    public function request2()
    {
        return $this->var;
    }

    public function insertDb()
    {
        $stmt = $this->conn->prepare("INSERT INTO front_door VALUES(NULL,'$this->var',NULL)");

        $result = $stmt->execute();
        $stmt->close();
    }
}
$test = new FrontDoorSwagger();
$test->request();
echo "<br>";
echo $test->request2();
echo "<br>";
$test->insertDb();

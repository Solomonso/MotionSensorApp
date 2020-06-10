<?php
/* Retreive the motion detected from the front door device from swagger and insert it into mysql database */

include 'library/Requests.php';

class BedroomSwagger
{
    private $conn;
    public $value;

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
        $response = Requests::get('https://test-motion-sensor.data.thethingsnetwork.org/api/v2/query/bedroom?last=7d', $headers);

        echo "{$response->body}\n";
        $myJson = json_decode($response->body, true);

        echo '<pre>';
        print_r($myJson);

        echo '<br>';
        echo '<pre>';
        print_r($myJson[0]['device_id']);
        echo "<br>";
        print_r($myJson[0]['message']);

        $this->value = $myJson[0]['device_id'];
    }

    public function request2()
    {
        return $this->value;
    }

    public function insertDb()
    {
        $stmt = $this->conn->prepare("INSERT INTO master_bedroom VALUES(NULL,'$this->value',NULL)");

        $result = $stmt->execute();
        $stmt->close();
    }
}

$test = new BedroomSwagger();
$test->request();
echo "<br>";
echo $test->request2();
echo "<br>";
$test->insertDb();

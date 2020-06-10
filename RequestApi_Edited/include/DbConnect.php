<?php
	
	class DbConnect
	{
		private $conn;

		public function connect()
		{
			require_once 'include/Config.php';

			//conn to mysql
			$this->conn = new mysqli(DB_HOST, DB_USER,DB_PASSWORD, DB_DATABASE);

			return $this->conn;
		}

		// function close() {
  //       // closing db connection
  //       mysql_close();
  //   	}
	}

/**
 * A class file to connect to database
 */
// class DbConnect {
 
//     // constructor
//     function __construct() {
//         // connecting to database
//         $this->connect();
//     }
 
//     // destructor
//     function __destruct() {
//         // closing db connection
//         $this->close();
//     }
 
//     /**
//      * Function to connect with database
//      */
//     function connect() {
//         // import database connection variables
//         require_once 'include/Config.php';
 
//         // Connecting to mysql database
//         $con = mysql_connect(DB_HOST, DB_USER, DB_PASSWORD) or die(mysql_error());
 
//         // Selecing database
//         $db = mysql_select_db(DB_DATABASE) or die(mysql_error()) or die(mysql_error());
 
//         // returing connection cursor
//         return $con;
//     }
 
//     /**
//      * Function to close db connection
//      */
//     function close() {
//         // closing db connection
//         mysql_close();
//     }
 
// }
?>
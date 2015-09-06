<?php 
	$user_email = "";
	
	if($_SERVER['REQUEST_METHOD'] == "POST"){

		extract($_POST);

		$name = htmlspecialchars($cf_name);
		$email = htmlspecialchars($cf_email);
		$message = htmlspecialchars($cf_message);
		$subject = isset($cf_subject) ? htmlspecialchars($cf_subject) : "Best Style Forever. Contact form";
		$cf_order_number = !empty($cf_order_number) ? 'Order number: ' . htmlspecialchars($cf_order_number) . "\n" : '';
	

		try{

			if(!filter_var($email, FILTER_VALIDATE_EMAIL)) throw new Exception("Your email address is incorrect!");

		}
		catch(Exception $e){

			echo $e->getMessage();
			die();

		}

		try{

			$headers .= 'From: Best Style Forever' . "\r\n" .
		   			 	'Reply-To: Best Style Forever' . "\r\n";
		   	$msg = "Name: $name\n$cf_order_number" . "Email address: $email\nMessage: $message";

			if(mail($user_email, $subject, $msg, $headers)) throw new Exception("Your message has been successfully sent!");
			else throw new Exception("Connection to server is failed!");

		}
		catch(Exception $e){

			echo $e->getMessage();

		}

	}
	
?>
#!/bin/bash
source "/home/vagrant/shared/Client_Curl/common-client-curl.sh"


echo Accessing service rest ${REST_SERVICE_NAME} at ${REST_SERVICE_URL}

echo 
echo "PUT ${REST_SERVICE_URL}/user/$1"
echo $(curl -s -H "Content-Type:application/xml" -X PUT "${REST_SERVICE_URL}/user/$1" -d "<user>
  <nickname>$2</nickname>
  <surname>$3</surname>
  <name>$4</name>
  <email>$5</email>
</user>" ) 
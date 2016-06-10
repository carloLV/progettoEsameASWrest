#!/bin/bash
source "/home/vagrant/shared/Client_Curl/common-client-curl.sh"


echo Accessing service rest ${REST_SERVICE_NAME} at ${REST_SERVICE_URL}

echo 
echo "PUT ${REST_SERVICE_URL}/user/$1"
echo $(curl -s -X PUT "${REST_SERVICE_URL}/user/$1" -d "$2")

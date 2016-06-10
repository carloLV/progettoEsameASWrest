#!/bin/bash
source "/home/vagrant/shared/Client_Curl/common-client-curl.sh"

echo Accessing service rest ${REST_SERVICE_NAME} at ${REST_SERVICE_URL}

echo 
echo "DELETE ${REST_SERVICE_URL}/user/$1"
echo $(curl -s -H "Accept:application/xml" -X DELETE "${REST_SERVICE_URL}/user/$1")

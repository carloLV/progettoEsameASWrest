#!/bin/bash
source "/home/vagrant/shared/Client_Curl/common-client-curl.sh"

echo Accessing service rest ${REST_SERVICE_NAME} at ${REST_SERVICE_URL}
echo 
echo "GET ${REST_SERVICE_URL}/user"
echo $(curl -s -H "Accept:application/xml" --get "${REST_SERVICE_URL}/user/$1")

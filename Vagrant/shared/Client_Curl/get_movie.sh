#!/bin/bash
source "/home/vagrant/shared/Client_Curl/common-client-curl.sh"

echo Accessing service rest ${REST_SERVICE_NAME} at ${REST_SERVICE_URL}
echo 
echo "GET ${REST_SERVICE_URL}/movie"
echo
echo "Movie's description in xml"
echo $(curl -s -H "Accept:application/xml" --get "${REST_SERVICE_URL}/movie/$1")
echo
echo "Movie's description in json"
echo $(curl -s -H "Accept:application/json" --get "${REST_SERVICE_URL}/movie/$1")
echo

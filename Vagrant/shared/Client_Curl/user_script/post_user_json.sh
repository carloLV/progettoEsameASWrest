#!/bin/bash
source "/home/vagrant/shared/Client_Curl/common-client-curl.sh"


echo Accessing service rest ${REST_SERVICE_NAME} at ${REST_SERVICE_URL}

echo 
echo "POST ${REST_SERVICE_URL}/users"
echo $(curl -s -H "Content-Type:application/json" -X POST "${REST_SERVICE_URL}/users" -d '{
	"user": {
		"nickname": "json",
		"surname": "White",
		"name": "Walter",
		"email":"davidedale@mate.com"
	}
}') 
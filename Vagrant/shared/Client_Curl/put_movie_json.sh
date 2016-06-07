#!/bin/bash
source "/home/vagrant/shared/Client_Curl/common-client-curl.sh"


echo Accessing service rest ${REST_SERVICE_NAME} at ${REST_SERVICE_URL}

echo 
echo "POST ${REST_SERVICE_URL}/movie/$1"
echo $(curl -s -H "Content-Type:application/json" -X POST "${REST_SERVICE_URL}/movies" -d '{
	"movie": {
		"title": "json",
		"year": "2000 ",
		"director": "Jason",
		"length":"120",
		"genre": "code"
	}
}') 

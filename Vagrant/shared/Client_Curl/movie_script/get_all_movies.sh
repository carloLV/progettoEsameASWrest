#!/bin/bash
# Script per l'accesso al servizio rest movies


source "/home/vagrant/shared/Client_Curl/common-client-curl.sh"

echo Accessing service rest ${REST_SERVICE_NAME} at ${REST_SERVICE_URL}

# accede a tutti i prodotti (JSON) 
echo 
echo "GET ${REST_SERVICE_URL}/movies"
echo $(curl -s -H "Accept:application/xml" --get "${REST_SERVICE_URL}/movies") 

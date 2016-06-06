#!/bin/bash
source "/home/vagrant/shared/Client_Curl/common-client-curl.sh"


echo Accessing service rest ${REST_SERVICE_NAME} at ${REST_SERVICE_URL}

echo 
echo "POST ${REST_SERVICE_URL}/movies"
echo $(curl -s -H "Content-Type:application/xml" -X POST "${REST_SERVICE_URL}/movies" -d "<movie>
  <title>$1</title>
  <year>$2</year>
  <director>$3</director>
  <length>$4</length>
  <genre>$5</genre>
</movie>"
  ) 

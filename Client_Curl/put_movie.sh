
REST_CONTEXT_ROOT=progettoEsameASWrest
REST_SERVICE_WAR=progettoEsameASWrest.war 
REST_SERVICE_URL=http://localhost:8080/${REST_CONTEXT_ROOT}

echo Accessing service rest ${REST_SERVICE_NAME} at ${REST_SERVICE_URL}

echo 
echo "POST ${REST_SERVICE_URL}/movie/$1"
echo $(curl -s -H "Content-Type:application/xml" -X PUT "${REST_SERVICE_URL}/movie/$1" -d "<movie>
  <title>$2</title>
  <year>$3</year>
  <director>$4</director>
  <length>$5</length>
  <genre>$6</genre>
</movie>" ) 

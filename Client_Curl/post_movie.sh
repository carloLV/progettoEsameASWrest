
REST_CONTEXT_ROOT=progettoEsameASWrest
REST_SERVICE_WAR=progettoEsameASWrest.war 
REST_SERVICE_URL=http://localhost:8080/${REST_CONTEXT_ROOT}

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

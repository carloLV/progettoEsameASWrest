
# Script per l'accesso al servizio rest movies

REST_CONTEXT_ROOT=progettoEsameASWrest
REST_SERVICE_WAR=progettoEsameASWrest.war 
REST_SERVICE_URL=http://localhost:8080/${REST_CONTEXT_ROOT}

echo Accessing service rest ${REST_SERVICE_NAME} at ${REST_SERVICE_URL}

# accede a tutti i prodotti (JSON) 
echo 
echo "GET ${REST_SERVICE_URL}/movies"
echo $(curl -s -H "Accept:application/xml" --get "${REST_SERVICE_URL}/movies") 

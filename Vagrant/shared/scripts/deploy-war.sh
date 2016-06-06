#! /bin/bash

source "/home/vagrant/shared/scripts/common.sh"

WAR_NAME=progettoEsameASWrest
WAR_FILE=${WAR_NAME}.war

function removeOldWar {
	echo "clearing old war file"	
	docker exec  scripts_tomee_1 /clear-old-ASW-war.sh 
	echo "done"
}

function deployWar {
	echo "deploying new war file"
	if resourceExists ${WAR_FILE}; then
		docker cp ${VAGRANT_RESOURCES}/${WAR_FILE} scripts_tomee_1:/usr/local/tomee/webapps
		echo "done"
	else
		echo "missing resource: " ${VAGRANT_RESOURCES}/${WAR_FILE}
		echo "moving on"
	fi
}

echo "=============================="
echo "deploying ${WAR_NAME}"
echo "=============================="
removeOldWar
deployWar

#! /bin/bash

source "/home/vagrant/shared/scripts/common.sh"

WAR_NAME=progettoEsameASWrest
WAR_FILE=${WAR_NAME}.war

function deployWar {
	if resourceExists ${WAR_FILE}; then
		docker cp ${VAGRANT_RESOURCES}/${WAR_FILE} scripts_tomee_1:/usr/local/tomee/webapps
		echo "done"
	else
		echo "missing resource: " ${VAGRANT_RESOURCES}/${WAR_FILE}
		echo "moving on"
	fi
}

echo "=================================="
echo "deploying ${WAR_FILE}"
echo "=================================="
deployWar

Prima di fare vagrant up copiare i file fuori dalla cartella di eclipse per evitare di sincronizzare con git file inutili.

Per ora viene creata una sola macchina virtuale (e non due) solo con docker e docker-compose.
Per installare db2 una volta nella macchina virtuale lanciare il seguente comando:
docker run --privileged=true -d -p 50000:50000 pheasanthunters/db2express-c /start-db.sh

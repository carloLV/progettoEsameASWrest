# Risorse Vagrant per la creazione dell'ambiente per il progetto dell'esame di Architettura dei Sistemi Software 

Vengono create due macchine virtuali (server e client).
La macchina server ha al suo interno docker e docker-compose, con due docker attivi: DB2 Express-C e Apache Tomee 1.7.4.
La macchina client prevede Ubuntu 14.04 ed è già dotata di un client curl.

Per fare automaticamente il deploy del war chiamarlo progettoEsameASWrest e posizionarlo nella cartella "shared/resources".

Con l'ultimo aggiornamento degli script è stata cambiato il docker che contiene il server.
Non è necessario ricreare l'ambiente. I cambiamenti vengono effettuati nella macchina server la prima volta che si lancia il comando:

    vagrant up


Prima di creare l'ambiente copiare i file necessari fuori dalla cartella di eclipse per evitare di sincronizzare con git file inutili.


In attesa dell'aggiornamento del docker db2 utilizzare le seguenti configurazioni del file persistence.xml
	
	<property name="openjpa.ConnectionUserName" value="root" />
	<property name="openjpa.ConnectionPassword" value="password" />
	<property name="openjpa.ConnectionURL" value="jdbc:db2://172.17.0.1:50000/dbASW" />

Lanciare inoltre al primo avvio i seguenti comandi (nell'ordine):

	vagrant ssh server
	docker exec -it scripts_db_1 bash
	passwd

impostare quindi come nuova password "password".

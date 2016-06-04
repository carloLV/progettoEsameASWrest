# Risorse Vagrant per la creazione di un ambiente client-server per il progetto dell'esame di Architettura dei Sistemi Software 

Vengono create due macchine virtuali (server e client).
La macchina server ha al suo interno docker e docker-compose, con due docker attivi: DB2 Express-C e Apache Tomee 1.7.4.
La macchina client prevede Ubuntu 14.04 ed è già dotata di un client curl.

Con l'ultimo aggiornamento degli script è stata cambiato il docker che contiene il server.
Non è necessario ricreare l'ambiente. I cambiamenti vengono effettuati nella macchina server la prima volta che si lancia il comando:

    vagrant up


Prima di creare l'ambiente copiare i file necessari fuori dalla cartella di eclipse per evitare di sincronizzare con git file inutili.

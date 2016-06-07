# Progetto per l'esame di Architettura dei Sistemi Software

Il progetto è suddiviso in tre parti principali:
- l'ambiente di esecuzione, che si trova nella cartella Vagrant;
- gli script per le richieste curl, che si trovano nella cartella Vagrant/shared/Client_Curl
- l'applicazione rest scritta in linguaggio Java, distribuita nelle altre cartelle del progetto.

L'ambiente di esecuzione è composto da due macchine Vagrant (client e server).
Per ulteriori informazioni riguardo l'installazione dell'ambiente consultare il file README nella cartella Vagrant del progetto.
Entrambe le macchine virtuali prevedono Ubuntu 14.04.
La macchina server ha al suo interno docker e docker-compose, con due docker attivi: DB2 Express-C e Apache Tomee 1.7.4.
La macchina client è dotata già di default di un client curl.

Gli script per le richieste curl sono utilizzabili dalla macchina client e si trovano nella cartella:

    ~vagrant/shared/Client_Curl


I docker utilizzati al fine del progetto sono stati sviluppati dagli autori dello stesso e sono reperibili ai link:
- DB2 Express-C: https://hub.docker.com/r/pheasanthunters/db2express-c/
- Apache Tomee 1.7.4: https://hub.docker.com/r/pheasanthunters/tomee1.7.4/

##Autori
Valerio Cetorelli
Davide Di Maria
Alessandro Fogli
Carlo La Viola

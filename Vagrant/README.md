Per eseguire l'ambiente è consigliato copiare i file nella cartella Vagrant fuori dalla cartella sincronizzata con git, così da evitare di sincronizzare file non strattamente necessari al progetto.

Creare una cartella "resources" all'interno della cartella "shared", dove andrà posizionato il file .war del progetto.
Il war deve chiamarsi "progettoEsameASWrest.war" per eseguire correttamente il deploy in automatico, in caso si voglia cambiare nome è necessario portare le opportuna modifiche allo script deploy-war.sh contenuto nella cartella shared/scripts.
Da notare che le macchine virtuali vengono create anche senza la presenza del corretto file war.

Per creare l'albiente posizionarsi nella cartella principale e lanciare il comando:

    $ vagrant up

Vengono così create e avviate automaticamente le due macchine virtuali client e server.

##Attenzione
Nel caso Vagrant dia problemi all'avvio delle macchine (non riesce a montare con successo le cartelle condivise) installare il plugin vbguest con il comando:

    $ vagrant plugin install vagrant-vbguest

Sembra inolte essere necessaria la versione 5 di VirtualBox. Versioni precedenti hanno riscontrato problemi.

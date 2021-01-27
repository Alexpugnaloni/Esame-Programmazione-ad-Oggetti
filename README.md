# Esame-Programmazione-ad-Oggetti
Servizio metereologico multilinuga utile a fornire informazioni sulle condizioni meteo attuali e previsioni dei prossimi 5 giorni. Tutte le informazioni sono ottenute tramite la REST API di OpenWeather ["5 day weather forecast"](https://openweathermap.org/forecast5)

Il programma genera statistiche periodiche e di accuratezza delle informazioni che possono essere filtrate a piacere dall' utente tramite dei filtri.

L' utente, utilizzando un Client (ad esempio [Postman](https://www.postman.com/)), utilizza le funzionalità del servizio grazie al Web Service [Tomcat](http://tomcat.apache.org/) integrato nel Framework [Spring](https://spring.io/).

## Caratteristiche del Servizio
:white_check_mark: Parametri personalizzati a disposizione dell' utente per tutte le rotte

:white_check_mark: Salvataggio di dati automatico su file di backup ogni ora

:white_check_mark: Statistiche generate utilizzando lo storico di dati raccolti dal backup automatico

:white_check_mark: Filtri personalizzati

:white_check_mark: Testing JUNIT

----------------------------------------------------------------------------------------------------------------------------------------
# Rotte Disponibili
Tipo | Nome | Descrizione
---- | ---- | ----  
GET | /weather | Effettua la chiamata all' API restituendo le previsioni meteo da oggi a cinque giorni.
POST | /periodicstats | Calcola le statistiche periodiche sul periodo filtrato selezionato dall' utente
POST | /accuracystats | Calcola le statistiche di accuratezza delle previsioni meteo generate nei giorni precedenti filtrando una determinata soglia di errore a piacere 

# GET /weather

Questa Rotta di tipo GET utilizza dei parametri scelti dall' utente per generare le previsioni. I parametri disponibili sono:

**city:** indica la città di cui si vuole visualizzare le condizioni meteo. Di default è impostata su Ancona,IT

**lang:** indica la lingua nel quale si vuole visualizzare le informazioni ricevute dall' API. Di default è impostata su "it".

Tutte le lingue utilizzabili sono disponibili nella [documentazione API](https://openweathermap.org/forecast5#multi).

Esempio di chiamata su Postman con parametri modificati e con body di risposta:

<<< INSERIRE IMMAGINE >>>>>>>>


### Body Breakdown 

 Il programma resituisce un Array popolato con Oggetti rappresentanti le singole previsioni. Vengono restituiti in totale 40 oggetti,
 esattamente una previsione ogni 3 ore per 5 giorni.
 
**description** : "nubi sparse",
**temperature** : 7.11,
**tempMin** : 7.07,
**tempMax** : 7.11,
**feels_like** : 3.38,
**humidity** : 44,
**pressure** : 1018,
**date** : "2021-01-27 12:00:00",
**city** : "Ancona",
**country** : "IT",
**mainCondition** : "Clouds"

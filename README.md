# OpenWeather 5 Days Forecast
Servizio metereologico multilingua utile a fornire informazioni sulle condizioni meteo attuali e previsioni dei prossimi 5 giorni. Tutte le informazioni sono ottenute tramite la REST API di OpenWeather ["5 day weather forecast"](https://openweathermap.org/forecast5)

Il programma genera statistiche periodiche e di accuratezza delle informazioni che possono essere filtrate a piacere dall' utente tramite dei filtri.

L' utente, utilizzando un Client (ad esempio [Postman](https://www.postman.com/)), utilizza le funzionalità del servizio grazie al Web Service [Tomcat](http://tomcat.apache.org/) integrato nel Framework [Spring](https://spring.io/).

Il server default di Tomcat su cui vanno effettuate le richieste è http://localhost:8080/ Aggiungere all'url una delle rotte disponibili per visualizzare le informazioni corrispondenti.

Perchè il Backup automatico funzioni, è necessario avviare almeno una chiamata alla rotta GET/weather. Il servizio poi salverà i parametri utilizzati e li conserverà per i salvataggi sul database.

:warning: ***Per il corretto utilizzo del servizio, è necessario innanzitutto disporre di una Key Openweather personale per poter effettuare le chiamate. Visitare [la pagina di sign up](https://home.openweathermap.org/users/sign_up) e registrarsi per ottenerne una. Inserire successivamente la propria key all' interno del file ApiKey.txt all' interno della cartella omonima presente nel progetto*** :warning:

## Caratteristiche Principali del Servizio
:white_check_mark: Parametri personalizzati a disposizione dell' utente per la chiamate alle previsioni meteo e per il calcolo delle statistiche

:white_check_mark: Salvataggio di dati automatico su file di backup ogni ora.

:white_check_mark: Statistiche generate utilizzando lo storico di dati raccolti dal backup automatico.

:white_check_mark: Filtri personalizzati.

:white_check_mark: Testing JUNIT.

----------------------------------------------------------------------------------------------------------------------------------------
# Rotte Disponibili
Tipo | Nome | Descrizione
---- | ---- | ----  
GET | /weather | Effettua la chiamata all' API restituendo le previsioni meteo da oggi a cinque giorni.
GET | /metadata | Restituisce tutti i metadati utilizzati nel servizio.
POST | /periodicstats | Calcola le statistiche periodiche sul periodo filtrato selezionato dall' utente.
POST | /accuracystats | Calcola le statistiche di accuratezza delle previsioni meteo generate nei giorni precedenti filtrando una determinata soglia di errore a piacere.


# GET /weather

Questa Rotta di tipo GET utilizza dei parametri scelti dall' utente per generare le previsioni. I parametri disponibili sono:

**city:** indica la città di cui si vuole visualizzare le condizioni meteo. Di default è impostata su Ancona,IT.

**lang:** indica la lingua nel quale si vuole visualizzare le informazioni ricevute dall' API. Di default è impostata su "it".

Tutte le lingue utilizzabili sono disponibili nella [documentazione API](https://openweathermap.org/forecast5#multi).

Esempio di chiamata su Postman con parametri modificati e con body di risposta:

![GET/weather](https://raw.githubusercontent.com/Alexpugnaloni/Esame-Programmazione-ad-Oggetti/master/UML/PostMan%20Screenshots/get%20weather.PNG)

## Body Example

```json
{
        "description": "nubi sparse",
        "temperature": 7.11,
        "tempMin": 7.07,
        "tempMax": 7.11,
        "feels_like": 3.38,
        "humidity": 44,
        "pressure": 1018,
        "date": "2021-01-18 12:00:00",
        "city": "Ancona",
        "country": "IT",
        "mainCondition": "Clouds"
    }
```

## Body Breakdown 

 Il servizio resituisce un Array popolato con Oggetti rappresentanti le singole previsioni. Vengono restituiti in totale 40 oggetti,
 esattamente una previsione ogni 3 ore per 5 giorni.
 
1. **description** : Descrizione della condizione meteo.
2. **temperature** : Temperatura.
3. **tempMin** : Temperatura minima registrata nella città.
4. **tempMax** : Temperatura massima registrata nella città.
5. **feels_like** : Temperatura percepita.
6. **humidity** : Umidità presente nell' aria.
7. **pressure** : Pressione atmosferica.
8. **date** : Data e ora della previsione.
9. **city** : Città richiesta dall' utente.
10. **country** : Stato della città richiesta.
11. **mainCondition** : macroparametro rappresentante la condizione meteo (utilizzato per le statistiche).

---------------------------------------------------------------------------------------------------------------------
# GET /metadata

Questa rotta manda in output l' elenco di metadati costruiti all' interno della classe omonima ed utilizzati all' interno del servizio.

Esempio di chiamata su Postman.

![get/metadata](https://raw.githubusercontent.com/Alexpugnaloni/Esame-Programmazione-ad-Oggetti/master/UML/PostMan%20Screenshots/get%20metadata.PNG)

## Body Example
```json
 {
     "alias": "description",
     "sourcefield": "Description",
     "type": "String"
 },
 {
     "alias": "temperature",
     "sourcefield": "Temperature",
     "type": "Double"
 }, ...
```

## Body Breakdown
1. **alias**: nome del dato.
2. **sourcefield**: campo da cui vengono presi i valori.
3. **type**: Tipo del metadato.
----------------------------------------------------------------------------------------------------------------------
# POST /periodicstats

Questa rotta POST sfrutta un body personalizzato dall' utente per calcolare statistiche periodiche su massima, minima, varianza e media di temperature reali
e percepite. Inoltre, restituisce un conteggio delle quantità di tipologie diverse di condizioni meteo nel periodo scelto.

## RequestBody Form
```json
{
   "city":"ancona",
   "period":"day"
}
```
1. **city** : città della quale calcolare le statistiche (il database deve contenere già chiamate alla stessa città)
2. **period**: scegliere fra "day", "week" o "month" per visualizzare statistiche in base al periodo scelto dalla giornata di oggi.

Esempio di chiamata su Postman con requestbody compilato e body di risposta

![post/periodicstats](https://raw.githubusercontent.com/Alexpugnaloni/Esame-Programmazione-ad-Oggetti/master/UML/PostMan%20Screenshots/post%20periodic.PNG)

## Body Example
```json
{
    "Weather Condition Count": {
        "Rain": 2,
        "Snow": 0,
        "Clouds": 2,
        "Drizzle": 0,
        "Other specific atmosphere cases": 0,
        "Thunderstorm": 1,
        "Clear": 2
    },
    "Stats for Temperature": [
        {
            "tempMax": 6.77,
            "tempMaxDate": "2021-01-19 12:00:00"
        },
        {
            "tempMinDate": "2021-01-20 12:00:00",
            "tempMin": 5.96
        },
        {
            "Average": 6.769999999999999
        },
        {
            "Variance": 7.888609052210118E-31
        }
    ],
    "Stats for Feels Like Temperature": [
        {
            "tempMax_FeelsLike": 3.13,
            "tempMaxDate_FeelsLike": "2021-01-20 12:00:00"
        },
        {
            "tempMin_FeelsLike": 3.13,
            "tempMinDate_FeelsLike": "2021-01-19 12:00:00"
        },
        {
            "Average_FeelsLike": 3.13
        },
        {
            "Variance_FeelsLike": 0.0
        }
    ]
}
```
## Body Breakdown
Il servizio utilizza due diversi array al fine di poter catalogare le diverse voci e mostrarle con un ordine prefissato. 

### Weather Condition Count

Contatore che riporta la quantità di diverse tipologie di condizioni che si riscontrano nel periodo scelto.

1. **Rain:** pioggia.
2. **Snow:** neve.
3. **Clouds:** nuvoloso.
4. **Drizzle:** pioviggine.
5. **Other specific atmosphere cases:** racchiude condizioni specifiche più rare o presenti solo in alcune parti del mondo, ad esempio "Tornado" o "Cenere Vulcanica".
6. **Thunderstorm:** temporale.
7. **Clear:** sereno.

### Stats for Temperature:

Contiene tutte le statistiche sulla temperatura del periodo scelto.

1. **tempMax:** Temperatura più alta registrata nel periodo.
2. **tempMaxDate:** Data in cui è stata registrata la massima.
3. **tempMinDate:** Data in cui è stata registrata la minima.
4. **tempMin:** Temperatura più bassa.
5. **Average:** Media di temperatura del periodo.
6. **Variance:** Varianza di temperatura del periodo.

### Stats for Feels Like Temperature:

Contiene tutte le statistiche sulla temperatura del periodo scelto.

1. **tempMax_FeelsLike:** Temperatura più alta registrata nel periodo.
2. **tempMaxDate_FeelsLike:** Data in cui è stata registrata la massima.
3. **tempMinDate_FeelsLike:** Data in cui è stata registrata la minima.
4. **tempMin_FeelsLike:** Temperatura più bassa.
5. **Average_FeelsLike:** Media di temperatura del periodo.
6. **Variance_FeelsLike:** Varianza di temperatura del periodo.
   
---------------------------------------------------------------------------------------------------------------------------------------------------------------------

# POST /accuracystats

Questa rotta POST sfrutta un body personalizzato dall' utente per calcolare statistiche sull' accuratezza delle previsioni eseguite precedentemente, confrontandole con le
chiamate correnti. La soglia di errore può essere modificata a piacere dall' utente.

## RequestBody Form
```json
{
    "city":"ancona",
    "accuracy": "1",
    "param": "temperature"
}
```
1. **city** : città della quale calcolare le statistiche, (il database deve essere già popolato con chiamate alla stessa città).
2. **accuracy**: soglia di errore di tolleranza per il filtro, è sempre un numero compreso tra 0 e 1. Il filtro riporterà le previsioni con un' accuratezza maggiore o uguale.
3. **param**: campo del quale calcolare l' accuratezza. Si può scegliere fra "temperature", "humidity" o "pressure".

Esempio di chiamata su Postman con requestbody compilato e body di risposta

![post /accuracy](https://raw.githubusercontent.com/Alexpugnaloni/Esame-Programmazione-ad-Oggetti/master/UML/PostMan%20Screenshots/post%20accuracy.PNG)

## Body Example
```json
{
    "List of correct forecasts": [
        {
            "date": "2021-01-19 12:00:00",
            "tempMax": 8.49,
            "country": "IT",
            "mainCondition": "Clouds",
            "city": "Ancona",
            "temperature": 7.21,
            "description": "cielo coperto",
            "humidity": 62,
            "pressure": 1015,
            "feels_like": 4.31,
            "tempMin": 7.21
        },
        {
            "date": "2021-01-20 09:00:00",
            "tempMax": 7.27,
            "country": "IT",
            "mainCondition": "Rain",
            "city": "Ancona",
            "temperature": 7.27,
            "description": "pioggia leggera",
            "humidity": 82,
            "pressure": 1008,
            "feels_like": 3.93,
            "tempMin": 7.27
        }
    ],
    "Amount of correct forecasts": 2,
    "Amount of total forecasts:": 37
}
```
## Body Breakdown

Il body restituito comprende una lista di tutte le previsioni al di sopra della soglia di errore presenti nel database delle previsioni: "List of Correct Forecasts".
Inoltre, restituisce due contatori:
1. **Amount of correct forecasts:** contiene il numero totale di previsioni al di sopra della soglia di errore
2. **Amount of total forecasts:** contiene il numero totale delle previsioni esaminate
----------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Eccezioni

Il programma utilzza Standard Exceptions e Custom Exceptions per gestire eventuali eccezioni che si possono verificare mentre
il servizio è in esecuzione.

### Custom Exceptions

**FailRequestException**: lanciata quando la città inserita non è stata trovata nel database di OpenWeather.

Esempio FailRequestException:
```
    failed request, check correct name of city and lang parameters
```

**MissingDataException**: lanciata quando una o più voci del requestbody non sono presenti.

Esempio MissingDataException:
```
    the field accuracy is missing
```

### Standard Exceptions
  - IOException
  - FileNotFoundException
  - ParseException
  - JSONException
  - ClassException
----------------------------------------------------------------------------------------------------------------------------------------------------------------------
# UML Diagrams

## Class Diagram
![ClassDiagram](https://raw.githubusercontent.com/Alexpugnaloni/Esame-Programmazione-ad-Oggetti/master/UML/Class%20Diagram.jpg)
## Use Case Diagram
![usecase](https://raw.githubusercontent.com/Alexpugnaloni/Esame-Programmazione-ad-Oggetti/master/UML/User%20Case%20Diagram.PNG)
# Sequence Diagrams
![getweather](https://raw.githubusercontent.com/Alexpugnaloni/Esame-Programmazione-ad-Oggetti/master/UML/OpenWeatherMap%20Model%20Sequence%20Diagram%20GETWEATHER.jpg)
![getmetadata](https://raw.githubusercontent.com/Alexpugnaloni/Esame-Programmazione-ad-Oggetti/master/UML/OpenWeatherMap%20Model%20Sequence%20Diagram%20GETMETADATA.jpg)
![postperiodic](https://raw.githubusercontent.com/Alexpugnaloni/Esame-Programmazione-ad-Oggetti/master/UML/OpenWeatherMap%20Model%20Sequence%20Diagram%20GETSTATS.jpg)
![postaccuracy](https://raw.githubusercontent.com/Alexpugnaloni/Esame-Programmazione-ad-Oggetti/master/UML/OpenWeatherMap%20Model%20Sequence%20Diagram%20GETACCURACY.jpg)
----------------------------------------------------------------------------------------------------------------------------------------------------------------------
# JUnit Tests
Sono presenti dei test all' interno del servizio.

**Test 1**: Verifica che due previsioni abbiano valori differenti.

**Test 2**: Serve a verificare che l'eccezione MissingDataException funzioni correttamente.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Authors

Nome | Matricola | Contributo
---- | ---- | ----
[Pugnaloni Alex](https://github.com/Alexpugnaloni) | s1092591 | 50%
[Riva Tommaso](https://github.com/NargoPezzo) | s1095496 | 50%

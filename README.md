# Esame-Programmazione-ad-Oggetti
Servizio metereologico multilinga utile a fornire informazioni sulle condizioni meteo attuali e previsioni dei prossimi 5 giorni. Tutte le informazioni sono ottenute tramite la REST API di OpenWeather ["5 day weather forecast"](https://openweathermap.org/forecast5)

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
GET | /metadata 
POST | /periodicstats | Calcola le statistiche periodiche sul periodo filtrato selezionato dall' utente
POST | /accuracystats | Calcola le statistiche di accuratezza delle previsioni meteo generate nei giorni precedenti filtrando una determinata soglia di errore a piacere


# GET /weather

Questa Rotta di tipo GET utilizza dei parametri scelti dall' utente per generare le previsioni. I parametri disponibili sono:

**city:** indica la città di cui si vuole visualizzare le condizioni meteo. Di default è impostata su Ancona,IT

**lang:** indica la lingua nel quale si vuole visualizzare le informazioni ricevute dall' API. Di default è impostata su "it".

Tutte le lingue utilizzabili sono disponibili nella [documentazione API](https://openweathermap.org/forecast5#multi).

Esempio di chiamata su Postman con parametri modificati e con body di risposta:

<<< INSERIRE IMMAGINE >>>>>>>>

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
        "date": "2021-01-27 12:00:00",
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

Questa rotta manda in output i metadati 

----------------------------------------------------------------------------------------------------------------------
## POST /periodicstats

Questa rotta POST sfrutta un body personalizzato dall' utente per calcolare statistiche periodiche su massima, minima, varianza e media di temperature reali
e percepite.

## RequestBody Form
```json
{
   "city":"ancona",
   "period":"day"
}
```
1. **city** : città della quale calcolare le statistice, (è opzionale, se non si inserisce il servizio calcolerà statistiche fra tutte le città nel database)
2. **period**: scegliere fra "day", "week" o "month" per visualizzare statistiche in base al periodo scelto dalla giornata di oggi.

Esempio di chiamata su Postman con requestbody compilato e body di risposta

<<< INSERIRE IMMAGINE >>>>>>>>

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
            "tempMaxDate": "2021-01-27 12:00:00"
        },
        {
            "tempMinDate": "2021-01-27 12:00:00",
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
            "tempMaxDate_FeelsLike": "2021-01-27 12:00:00"
        },
        {
            "tempMin_FeelsLike": 3.13,
            "tempMinDate_FeelsLike": "2021-01-27 12:00:00"
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
   

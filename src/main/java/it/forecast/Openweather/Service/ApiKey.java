package it.forecast.Openweather.Service;


import java.io.*;

/**
 * Classe che si occupa di prelevare l'api key dell'utente da un file di testo.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */


public class ApiKey {
    /**
     * attributo della classe ApiKey.
     */


     private  String ApiKey;

    /**
     * Costruttori della classe ApiKey.
     */
    public ApiKey(){

     }

     public ApiKey(String ApiKey){
         this.ApiKey = ApiKey;
     }

    /**
     * Getter e Setter della Classe ApiKey.
     */

    public String getApiKey() {
        return ApiKey;
    }

    public void setApiKey(String apiKey) {
        ApiKey = apiKey;
    }

    /**
     * Metodo che si occupa della lettura dell'api key dell'utente da file.
     */

    public void ReadApiKey() throws IOException {


        File file = new File("ApiKey/ApiKey.txt");

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
                ApiKey = st;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        setApiKey(ApiKey);
    }
}




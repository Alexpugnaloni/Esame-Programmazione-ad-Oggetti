package it.forecast.Openweather.Service;


import java.io.*;


public class ApiKey {


     private  String ApiKey;
     public ApiKey(){

     }

     public ApiKey(String ApiKey){
         this.ApiKey = ApiKey;
     }

    public String getApiKey() {
        return ApiKey;
    }

    public void setApiKey(String apiKey) {
        ApiKey = apiKey;
    }

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




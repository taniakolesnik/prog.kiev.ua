package uk.co.taniakolesnik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AddressCheck {

    private File file;

    public AddressCheck(File file) {
        this.file = file;
    }

    public void printAccessResult(){
        Map<String,String> result = loadAddressesFromFile(file);
        result.replaceAll((address, status) -> checkUrlConnection(address));
        result.forEach((address, status) -> System.out.println(address + " " + status));

    }

    private Map<String,String> loadAddressesFromFile(File file) {
        Map<String,String> result = new HashMap<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String address = "";
            for (;(address=bufferedReader.readLine())!=null;){
                result.put(address, " loaded from file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private String checkUrlConnection(String address){
        try {
            URL url = new URL(address);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            int response = httpURLConnection.getResponseCode();
            return response > 300 ? "failed connection " + response : "good connection " + response;

        } catch (MalformedURLException e) {
            return " url address cannot be formed";
        } catch (IOException e) {
            return " no connection";
        }
    }

}

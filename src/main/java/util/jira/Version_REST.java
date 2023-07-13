package util.jira;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;

public class Version_REST {
    private static util.PropertyUtil propertyUtil= new util.PropertyUtil();
    public static void main(String[] args) throws IOException {
        new Version_REST().createVersion("TP", "This is Testing Version");
    }

    public void createVersion(String projectKey, String versionName) throws IOException {
        JSONObject createCycleObj = new JSONObject();
        createCycleObj.put("name", versionName);
        createCycleObj.put("project", projectKey);
        String urlString1=propertyUtil.getJiraBaseURL() + "/rest/api/2/version";
        try {
            HttpResponse<JsonNode> response = Unirest.post(urlString1)
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Basic " + new String(Base64.getEncoder().encode((propertyUtil.getJiraUid() + ":" + propertyUtil.getJiraPwd()).getBytes())))
                    .body(createCycleObj)
                    .asJson();
            int statusCode= response.getStatus();
            if (statusCode >= 200 && statusCode < 300) {
                System.out.println(response.getBody().getObject().get("id"));
            }else{
                new util.ExceptionHandler().customizedException("Cannot create version in JIRA");
            }
        }catch(Exception e){

        }

    }
}
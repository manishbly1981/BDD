package util.jira;


import java.io.IOException;
import java.util.Base64;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import util.jira.DataManager.GetProjectDetails;


public class JiraApi {
    util.PropertyUtil propertyUtil;

    public JiraApi(){
        this.propertyUtil= new util.PropertyUtil();
    }

//    public static void main(String args[]){
////        System.out.println(new JiraApi().getProjectId("MAN"));
//        System.out.println(new JiraApi().getVersionId("MAN", "1.0.0"));
//    }

    public String getProjectId(String projectKey){
        String projectId="";
        try {

            HttpResponse<JsonNode> response = Unirest.get(propertyUtil.getJiraBaseURL() + "/rest/api/2/project/"+ projectKey)
                    .header("Accept", "application/json")
                    .header("Authorization", "Basic "+ new String(Base64.getEncoder().encode((propertyUtil.getJiraUid()+ ":"+ propertyUtil.getJiraPwd()).getBytes())))
                    .asJson();
            int statusCode= response.getStatus();
            if (statusCode >= 200 && statusCode < 300) {
                JsonNode responseBody= response.getBody();
                Object project= responseBody.getObject();
                projectId=(String)((JSONObject)project).get("id");
            }else{
                //Need to fail it due to connection issue
            }
        } catch (UnirestException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    return projectId;
    }
    public String getVersionId(String projectKey, String versionName){
        String versionID="";
        try {
//            System.out.println(propertyUtil.getJiraBaseURL() + "/rest/api/2/project/"+ projectKey+ "/versions");
            HttpResponse<JsonNode> response = Unirest.get(propertyUtil.getJiraBaseURL() + "/rest/api/2/project/"+ projectKey+ "/versions")
                    .header("Accept", "application/json")
                    .header("Authorization", "Basic "+ new String(Base64.getEncoder().encode((propertyUtil.getJiraUid()+ ":"+ propertyUtil.getJiraPwd()).getBytes())))
                    .asJson();
            int statusCode= response.getStatus();
            if (statusCode >= 200 && statusCode < 300) {
                JsonNode responseBody= response.getBody();
//                System.out.println(responseBody.toString());
                JSONArray versionArray= responseBody.getArray();
                for (Object currentVersion: versionArray){
                   if(((String)((JSONObject)currentVersion).get("name")).trim().equalsIgnoreCase(versionName.trim())){
                       versionID= (String)((JSONObject)currentVersion).get("id");
                    }
                }
            }else{
                //Need to fail it due to connection issue
            }
        } catch (UnirestException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return versionID;
    }

    public String createVersion(String projectKey, String versionName){
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
                return response.getBody().getObject().get("id").toString();
            }else{
                new util.ExceptionHandler().customizedException("Cannot create version in JIRA");
                return "";
            }
        }catch(Exception e){
            new util.ExceptionHandler().customizedException("Cannot create version in JIRA");
            return "";
        }
    }
}

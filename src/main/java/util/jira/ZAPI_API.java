package util.jira;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import util.PropertyUtil;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

public class ZAPI_API {
    PropertyUtil propertyUtil;
    AwtGenerator awtGenerator;
    String testId, execuctionId;

    public ZAPI_API(){
        awtGenerator=new AwtGenerator();
        propertyUtil= new PropertyUtil();
    }
    public static void main(String args[]){
        new ZAPI_API().updateJiraStatusWithAttachment("TP-13", "1", "D:\\temp\\test");
    }
    public void updateJiraStatusWithAttachment(String testKey, String testStatus, String zipReportPath){
        if (testStatus.equalsIgnoreCase("pass"))
            testStatus="1"; //Pass
        else if (testStatus.equalsIgnoreCase("fail"))
            testStatus="2"; //Fail
        else
            testStatus="-1"; //Not executed

        String projectKey=propertyUtil.getJiraProjectKey();
        String versionName=propertyUtil.getJiraVersionName();
        String cycleName=propertyUtil.getJiraCycleName();
        JiraApi jiraApi= new JiraApi();
        ZAPI_API zapi_api= new ZAPI_API();
        String projectId=jiraApi.getProjectId(projectKey);
        String versionId=jiraApi.getVersionId(projectId, versionName);
        if (versionId.equals(null)|versionId.equals("")){
            versionId= jiraApi.createVersion(projectKey, versionName);
            new util.DriverUtil().explicitWait(5);
        }
        String cycleId= zapi_api.getCycleId(projectId, versionId, cycleName);
        try {
            if (cycleId.equals(null) | cycleId.equals("")) {
                cycleId = new CreateCycle().createCyle(projectId, versionId, cycleName);
                new util.DriverUtil().explicitWait(5);
            }
        }catch(Exception e){
            //Need to cater the exception
        }

        //To update the test case status in JIRA
        PropertyUtil propertyUtil= new PropertyUtil();
        FetchExecuteUpdate.projectKey=propertyUtil.getJiraProjectKey();   //"TSL";
        FetchExecuteUpdate.versionId=versionId;    // "10003";
        FetchExecuteUpdate.projectId=projectId;
        FetchExecuteUpdate.cycleId=cycleId;      //"c2b077b2-6a0f-4735-b3c2-2e642da7be3a";
        FetchExecuteUpdate.issueKey=testKey;      //"MAN-1";
        FetchExecuteUpdate.executionStatus=testStatus;
        try {
            FetchExecuteUpdate.updateExecutionStatus();
            AddAttachment.addAttachment(versionId, projectId, FetchExecuteUpdate.issueId, cycleId, FetchExecuteUpdate.executionId, zipReportPath);
        }catch(Exception e){
            //Need to cater execution customized
        }


    }
    public String getCycleId(String projectId, String versionId, String cycleName){
        String cycleId="";
        try {
            String uri=awtGenerator.getCycleURI(projectId, versionId);
            String zapiAccessKey=new util.PropertyUtil().getZapiAccessKey();
            String token=awtGenerator.getJWTToken();
            HttpResponse<JsonNode> response = Unirest.get(uri)
                    .header("Accept", "application/json")
                    .header("zapiAccessKey", zapiAccessKey)
                    .header("Authorization", token)
                    .asJson();
            int statusCode= response.getStatus();
            if (statusCode >= 200 && statusCode < 300) {
                JsonNode responseBody= response.getBody();
                JSONArray versionArray= responseBody.getArray();
                for (Object currentVersion: versionArray){
                    if(((String)((JSONObject)currentVersion).get("name")).trim().equalsIgnoreCase(cycleName.trim())){
                        cycleId= (String)((JSONObject)currentVersion).get("id");
                    }
                }
            }else{
                //Need to fail it due to connection issue
            }
        }catch(UnirestException e){
            e.printStackTrace();
        }
        return cycleId;
    }

    public void getExecutionList(String projectId, String versionId, String cycleId, String testId){
        try {
            String uri=awtGenerator.getExecutionList(projectId,versionId,cycleId);
            String zapiAccessKey=new util.PropertyUtil().getZapiAccessKey();
            String token=awtGenerator.getJWTToken();
            HttpResponse<JsonNode> response = Unirest.get(uri)
                    .header("Accept", "application/json")
                    .header("zapiAccessKey", zapiAccessKey)
                    .header("Authorization", token)
                    .asJson();
            int statusCode= response.getStatus();
            if (statusCode >= 200 && statusCode < 300) {
                Object objExecutionList= response.getBody().getObject();
                Object objSearchList=((JSONObject) objExecutionList).get("searchObjectList");
                 JSONArray issueList=  (JSONArray)objSearchList;
                 for(Object issue:issueList){
                     if(((JSONObject)issue).get("issueKey").toString().trim().equalsIgnoreCase(testId)){
                         this.testId= ((JSONObject)((JSONObject)issue).get("execution")).get("issueId").toString();
                         this.execuctionId= ((JSONObject)((JSONObject)issue).get("execution")).get("id").toString();
                     }
                 }
//                System.out.println(((JSONObject)((JSONArray)objSearchList).get(0)).get("issueKey"));
            }
//            System.out.println(response.getStatus());
//            System.out.println(response.getBody());
        }catch(UnirestException e){
            e.printStackTrace();
        }
    }




}

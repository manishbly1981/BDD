package util.jira;

import java.util.Base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FetchExecuteUpdate {
    private static util.PropertyUtil propertyUtil=new util.PropertyUtil();
    public static String server=    propertyUtil.getZephyrBaseUrl();     //"https://prod-api.zephyr4jiracloud.com/connect";
    private static String API_SEARCH_ISSUES = server+ "/rest/api/2/search";
    private static String API_ADD_TESTS = server+ "/public/rest/api/1.0/executions/add/cycle/";
    private static String API_GET_EXECUTIONS = server+ "/public/rest/api/1.0/executions/search/cycle/";
    private static String API_UPDATE_EXECUTION= server+ "/public/rest/api/1.0/execution/";

    /** Declare JIRA,Zephyr URL,access and secret Keys */

    // JIRA Cloud URL of the instance
    protected static String jiraBaseURL = propertyUtil.getJiraBaseURL();     //"https://revver.atlassian.net";
    // Replace zephyr baseurl <ZAPI_Cloud_URL> shared with the user for ZAPI Cloud Installation
    private static String zephyrBaseUrl = server;    //"https://prod-api.zephyr4jiracloud.com/connect";
    // zephyr accessKey , we can get from Addons >> zapi section
    protected static String accessKey = propertyUtil.getZapiAccessKey();     //"NmY3MzkxYjAtNDg5Ny0zODkwLWI4ZTgtYjc2MGI2OTUwNjk5IDVjNGJkZmYyN2E5NThkNjlkMjc3YWI3MyBtYW5pc2guZ3VwdGEzQHNvcHJhc3RlcmlhLmNvbQ";
    // zephyr secretKey , we can get from Addons >> zapi section
    protected static String secretKey = propertyUtil.getZapiSecretKey();     //"BAHJu93AJqaDVwB2I9blZ37Q9pBO9c0NNlHhcrF4l-g";

    /** Declare parameter values here */
    protected static String userName = propertyUtil.getJiraUserName();     //"manish.gupta3";
    protected static String accountId = propertyUtil.getJiraAccountId();     //"5c4bdff27a958d69d277ab73";
    protected static String password = propertyUtil.getJiraPwd();     //"RhgcbIVLLdK7US5qx6ya5ACE";

    protected static String cycleId = "";     //"c2b077b2-6a0f-4735-b3c2-2e642da7be3a";
    protected static String versionId = "";     //"10003";
    protected static String projectId = "";     //"10010";
    protected static String projectKey= "";     //"TSL";
    protected static String executionId= "";
    protected static String issueKey= "";     //"MAN-1";
    protected static String issueId= "";
    protected static String executionStatus= "";     //"-1";

    static ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(zephyrBaseUrl, accessKey, secretKey, accountId)
            .build();
    JwtGenerator jwtGenerator = client.getJwtGenerator();

    public static void updateExecutionStatus() throws JSONException, URISyntaxException, ParseException, IOException {
        final String issueSearchUri = API_SEARCH_ISSUES.replace(server, jiraBaseURL);

        /**
         * Get Test Issues by JQL
         *
         */

        //Json object for JQL search

        JSONObject jqlJsonObj = new JSONObject();
        jqlJsonObj.put("jql", "project = "+ projectKey);
        jqlJsonObj.put("startAt", 0);
        jqlJsonObj.put("maxResults", 21);		// maxResults to be returned by search
        jqlJsonObj.put("fieldsByKeys", false);
        /**
         * Add tests to Cycle
         *
         */

        final String addTestsUri = API_ADD_TESTS.replace(server, zephyrBaseUrl) + cycleId;

        /** Create JSON object by providing input values */
        String[] IssueIds = {issueKey};

        JSONObject addTestsObj = new JSONObject();
        addTestsObj.put("issues", IssueIds);
        addTestsObj.put("method", "1");
        addTestsObj.put("projectId", projectId);
        addTestsObj.put("versionId", versionId);

        StringEntity addTestsJSON = null;
        try {
            addTestsJSON = new StringEntity(addTestsObj.toString());
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        addTestsToCycle(addTestsUri, client, accessKey, addTestsJSON);
        new util.DriverUtil().explicitWait(5);
        ZAPI_API zapiApi= new ZAPI_API();
        zapiApi.getExecutionList(projectId, versionId, cycleId, issueKey);
        FetchExecuteUpdate.executionId= zapiApi.execuctionId;
        FetchExecuteUpdate.issueId= zapiApi.testId;

        JSONObject statusObj = new JSONObject();
        statusObj.put("id", FetchExecuteUpdate.executionStatus);
        JSONObject executeTestsObj = new JSONObject();
        executeTestsObj.put("status", statusObj);
        executeTestsObj.put("cycleId", cycleId);
        executeTestsObj.put("projectId", projectId);
        executeTestsObj.put("versionId", versionId);
        executeTestsObj.put("comment", "Executed by ZAPI Cloud");

            final String updateExecutionUri = API_UPDATE_EXECUTION.replace(server, zephyrBaseUrl) + executionId;
//            System.out.println(updateExecutionUri);
//            System.out.println(issueId);
            executeTestsObj.put("issueId", issueId);
            StringEntity executeTestsJSON = null;
            try {
                executeTestsJSON = new StringEntity(executeTestsObj.toString());
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
            updateExecutions(updateExecutionUri, client, accessKey, executeTestsJSON);
    }

//    private static String[] getIssuesByJQL(String issueSearchURL, String userName, String password,
//                                           JSONObject jqlJsonObj) throws JSONException {
////        byte[] bytesEncoded = Base64.encodeBase64((userName + ":" + password).getBytes());
//        byte[] bytesEncoded = Base64.getEncoder().encode((userName + ":" + password).getBytes());
//        String authorizationHeader = "Basic " + new String(bytesEncoded);
//        Header header = new BasicHeader(HttpHeaders.AUTHORIZATION, authorizationHeader);
//
//        String[] issueIds = new String[jqlJsonObj.getInt("maxResults")];
//
//        StringEntity jqlJSON = null;
//        try {
//            jqlJSON = new StringEntity(jqlJsonObj.toString());
//        } catch (UnsupportedEncodingException e1) {
//            e1.printStackTrace();
//        }
//
//        HttpResponse response = null;
//        HttpClient restClient = new DefaultHttpClient();
//        try {
//            // System.out.println(issueSearchURL);
//            HttpPost createProjectReq = new HttpPost(issueSearchURL);
//            createProjectReq.addHeader(header);
//            createProjectReq.addHeader("Content-Type", "application/json");
//            createProjectReq.setEntity(jqlJSON);
//
//            response = restClient.execute(createProjectReq);
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        int statusCode = response.getStatusLine().getStatusCode();
//        // System.out.println(statusCode);
//
//        if (statusCode >= 200 && statusCode < 300) {
//            HttpEntity entity1 = response.getEntity();
//            String string1 = null;
//            try {
//                string1 = EntityUtils.toString(entity1);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println(string1);
//            JSONObject allIssues = new JSONObject(string1);
//            JSONArray IssuesArray = allIssues.getJSONArray("issues");
////			System.out.println(IssuesArray.length());
//            if (IssuesArray.length() == 0) {
//                return issueIds;
//            }
//
//            for (int j = 0; j < IssuesArray.length() ; j++) {
//                JSONObject jobj = IssuesArray.getJSONObject(j);
//                String issueId = jobj.getString("id");
//                issueIds[j] = issueId;
//            }
//        }
//        return issueIds;
//    }

    public static void addTestsToCycle(String uriStr, ZFJCloudRestClient client, String accessKey,
                                       StringEntity addTestsJSON) throws URISyntaxException, JSONException {

        URI uri = new URI(uriStr);
        int expirationInSec = 360;
        JwtGenerator jwtGenerator = client.getJwtGenerator();
        String jwt = jwtGenerator.generateJWT("POST", uri, expirationInSec);
        HttpResponse response = null;
        HttpClient restClient = new DefaultHttpClient();

        HttpPost addTestsReq = new HttpPost(uri);
        addTestsReq.addHeader("Content-Type", "application/json");
        addTestsReq.addHeader("Authorization", jwt);
        addTestsReq.addHeader("zapiAccessKey", accessKey);
        addTestsReq.setEntity(addTestsJSON);

        try {
            response = restClient.execute(addTestsReq);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode >= 200 && statusCode < 300) {
//            System.out.println("Tests added Successfully");
        } else {
            try {
                throw new ClientProtocolException("Unexpected response status: " + statusCode);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            }
        }
    }

//    private static Map<String, String> getExecutionsByCycleId(String uriStr, ZFJCloudRestClient client,
//                                                              String accessKey) throws URISyntaxException, JSONException {
//        Map<String, String> executionIds = new HashMap<String, String>();
//        URI uri = new URI(uriStr);
//        int expirationInSec = 360;
//        JwtGenerator jwtGenerator = client.getJwtGenerator();
//        String jwt = jwtGenerator.generateJWT("GET", uri, expirationInSec);
//
//        HttpResponse response = null;
//        HttpClient restClient = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet(uri);
//        httpGet.setHeader("Authorization", jwt);
//        httpGet.setHeader("zapiAccessKey", accessKey);
//
//        try {
//            response = restClient.execute(httpGet);
//        } catch (ClientProtocolException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        } catch (IOException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }
//
//        int statusCode = response.getStatusLine().getStatusCode();
//        // System.out.println(statusCode);
//
//        if (statusCode >= 200 && statusCode < 300) {
//            HttpEntity entity1 = response.getEntity();
//            String string1 = null;
//            try {
//                string1 = EntityUtils.toString(entity1);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            // System.out.println(string1);
//            JSONObject allIssues = new JSONObject(string1);
//            JSONArray IssuesArray = allIssues.getJSONArray("searchObjectList");
//            // System.out.println(IssuesArray.length());
//            if (IssuesArray.length() == 0) {
//                return executionIds;
//            }
//            for (int j = 0; j <= IssuesArray.length() - 1; j++) {
//                JSONObject jobj = IssuesArray.getJSONObject(j);
//                JSONObject jobj2 = jobj.getJSONObject("execution");
//                String executionId = jobj2.getString("id");
//                long IssueId = jobj2.getLong("issueId");
//                executionIds.put(executionId, String.valueOf(IssueId));
//            }
//        }
//        return executionIds;
//    }

    public static String updateExecutions(String uriStr, ZFJCloudRestClient client, String accessKey,
                                          StringEntity executionJSON) throws URISyntaxException, JSONException, ParseException, IOException {

        URI uri = new URI(uriStr);
        int expirationInSec = 360;
        JwtGenerator jwtGenerator = client.getJwtGenerator();
        String jwt = jwtGenerator.generateJWT("PUT", uri, expirationInSec);

        HttpResponse response = null;
        HttpClient restClient = new DefaultHttpClient();

        HttpPut executeTest = new HttpPut(uri);
        executeTest.addHeader("Content-Type", "application/json");
        executeTest.addHeader("Authorization", jwt);
        executeTest.addHeader("zapiAccessKey", accessKey);
        executeTest.setEntity(executionJSON);

        try {
            response = restClient.execute(executeTest);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int statusCode = response.getStatusLine().getStatusCode();
        String executionStatus = "No Test Executed";
        HttpEntity entity = response.getEntity();

        if (statusCode >= 200 && statusCode < 300) {
            String string = null;
            try {
                string = EntityUtils.toString(entity);
                JSONObject executionResponseObj = new JSONObject(string);
                JSONObject descriptionResponseObj = executionResponseObj.getJSONObject("execution");
                JSONObject statusResponseObj = descriptionResponseObj.getJSONObject("status");
                executionStatus = statusResponseObj.getString("description");
//                System.out.println(executionResponseObj.get("issueKey") + "--" + executionStatus);
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {

            try {
                String string = null;
                string = EntityUtils.toString(entity);
                JSONObject executionResponseObj = new JSONObject(string);
                cycleId = executionResponseObj.getString("clientMessage");
                throw new ClientProtocolException("Unexpected response status: " + statusCode);

            } catch (ClientProtocolException e) {
                e.printStackTrace();
            }
        }
        return executionStatus;
    }
}


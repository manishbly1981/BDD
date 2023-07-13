package util.jira;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;
import util.PropertyUtil;

public class CreateCycle {
    util.PropertyUtil propertyUtil;
    public CreateCycle(){
        this.propertyUtil=new PropertyUtil();
    }

    public String createCyle(String projectId, String versionId, String cycleName) throws URISyntaxException, JSONException, IllegalStateException, IOException {
        String zephyrBaseUrl = propertyUtil.getZephyrBaseUrl();
        String accessKey = propertyUtil.getZapiAccessKey();
        String secretKey = propertyUtil.getZapiSecretKey();
        String accountId = propertyUtil.getJiraAccountId();
        ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(zephyrBaseUrl, accessKey, secretKey, accountId)
                .build();

        String cycleDescription = "Created by ZAPI CLOUD API";
        String createCycleUri = zephyrBaseUrl + "/public/rest/api/1.0/cycle?expand=&clonedCycleId=";

        /** Cycle Object created - DO NOT EDIT **/
        JSONObject createCycleObj = new JSONObject();
        createCycleObj.put("name", cycleName);
        createCycleObj.put("description", cycleDescription);
        createCycleObj.put("startDate", System.currentTimeMillis());
        createCycleObj.put("projectId", projectId);
        createCycleObj.put("versionId", versionId);

        StringEntity cycleJSON = null;
        try {
            cycleJSON = new StringEntity(createCycleObj.toString());
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        String cycleID = createCycle(createCycleUri, client, accessKey, cycleJSON);
//        System.out.println("Cycle Created with Cycle Id :" + cycleID);
        return cycleID;
    }

    public String createCycle(String uriStr, ZFJCloudRestClient client, String accessKey, StringEntity cycleJSON)
            throws URISyntaxException, JSONException {

        URI uri = new URI(uriStr);
        int expirationInSec = 360;
        JwtGenerator jwtGenerator = client.getJwtGenerator();
        String jwt = jwtGenerator.generateJWT("POST", uri, expirationInSec);
//        System.out.println(uri.toString());
//        System.out.println(jwt);

        HttpResponse response = null;
        HttpClient restClient = new DefaultHttpClient();

        HttpPost createCycleReq = new HttpPost(uri);
        createCycleReq.addHeader("Content-Type", "application/json");
        createCycleReq.addHeader("Authorization", jwt);
        createCycleReq.addHeader("zapiAccessKey", accessKey);
        createCycleReq.setEntity(cycleJSON);

        try {
            response = restClient.execute(createCycleReq);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int statusCode = response.getStatusLine().getStatusCode();
//        System.out.println(statusCode);
        String cycleId = "-1";
        if (statusCode >= 200 && statusCode < 300) {
            HttpEntity entity = response.getEntity();
            String string = null;
            try {
                string = EntityUtils.toString(entity);
                JSONObject cycleObj = new JSONObject(string);
                cycleId = cycleObj.getString("id");
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                throw new ClientProtocolException("Unexpected response status: " + statusCode);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            }
        }
        return cycleId;
    }

}


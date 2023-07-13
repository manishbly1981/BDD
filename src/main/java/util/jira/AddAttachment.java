package util.jira;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;

public class AddAttachment {
    static util.PropertyUtil propertyUtil=new util.PropertyUtil();;
    public static String server= propertyUtil.getZephyrBaseUrl();       //"https://prod-api.zephyr4jiracloud.com/connect";
    public static void addAttachment(String versionId, String projectId, String issueId, String cycleId, String entityId, String fileWithAbsolutePath) throws URISyntaxException, ParseException, IOException, JSONException {
        final String API_ADD_ATTACHMENT = server + "/public/rest/api/1.0/attachment";


        /** Declare JIRA,Zephyr URL,access and secret Keys */

        final String zephyrBaseUrl = propertyUtil.getZephyrBaseUrl();
        // zephyr accessKey , we can get from Addons >> zapi section
        final String accessKey = propertyUtil.getZapiAccessKey();
        // zephyr secretKey , we can get from Addons >> zapi section
        String secretKey = propertyUtil.getZapiSecretKey();

        /** Declare parameter values here */
        final String userName = propertyUtil.getJiraUserName();
        final String comment = "This is automation execution".replaceAll(" ","%20");
        final String entityName = "execution"; // entityName takes execution/stepResult as parameter value

//        final String versionId = "10003";			//Version Id of Execution - '-1" for UNSCHEDULED version
//        final String projectId = "10010";		//ProjectId of the execution
//        final String issueId = "10413";			//Issue Id of the execution
//        final String cycleId = "c2b077b2-6a0f-4735-b3c2-2e642da7be3a";			// Cycle Id of the execution - "-1" for AdHoc Cycle
//        final String entityId = "9068445f-9db5-4a38-9cce-b084d5a4b317";    //execution Id
//        final String fileWithAbsolutePath = "D:\\Bdd\\UrsaBank_test\\test-output\\2019_06_11_16_47_44\\ExecutionSummaryReport.zip";   //Absolute path of the file
//        final String fileWithAbsolutePath = "D:\\Bdd\\UrsaBank_test\\test-output\\2019_06_11_16_47_44\\Screenshots\\20190611_044806.png";   //Absolute path of the file
        int expirationInSec = 360;

        // Add Attachment to a testcase ********DO NOT EDIT ANYTHING BELOW**********


        final ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(zephyrBaseUrl, accessKey, secretKey, userName)
                .build();
        JwtGenerator jwtGenerator = client.getJwtGenerator();

        // Initializes the URL data type with strURL created above
        String attachmentUri = API_ADD_ATTACHMENT.replace(server , zephyrBaseUrl) + "?issueId=" + issueId
                + "&versionId=" + versionId + "&entityName=" + entityName + "&cycleId=" + cycleId + "&entityId="
                + entityId + "&comment=" + comment + "&projectId=" + projectId;
        URI uri = new URI(attachmentUri);

        String jwt = jwtGenerator.generateJWT("POST", uri, expirationInSec);
//        System.out.println(uri.toString());
//        System.out.println(jwt);

        HttpResponse response = null;
        HttpClient restClient = new DefaultHttpClient();

        File file = new File(fileWithAbsolutePath);
        MultipartEntity entity = new MultipartEntity();
        entity.addPart("attachment", new FileBody(file));

        HttpPost addAttachmentReq = new HttpPost(uri);
        addAttachmentReq.addHeader("Authorization", jwt);
        addAttachmentReq.addHeader("zapiAccessKey", accessKey);
        addAttachmentReq.setEntity(entity);

        try {
            response = restClient.execute(addAttachmentReq);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println("Before getting response");
        HttpEntity entity1 = response.getEntity();
//        System.out.println("Before getting status code");
        int statusCode = response.getStatusLine().getStatusCode();
//        System.out.println("Status Code is : " + statusCode);
//         System.out.println("Response is : " + response.toString());
        if (statusCode >= 200 && statusCode < 300) {
//            System.out.println("Attachment added Successfully");
        } else {
            try {
                String string = null;
                string = EntityUtils.toString(entity1);
                System.out.println(string);
                throw new ClientProtocolException("Unexpected response status: " + statusCode);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            }
        }

    }
}

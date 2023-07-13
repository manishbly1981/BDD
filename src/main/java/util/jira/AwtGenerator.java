package util.jira;

import java.net.URI;
import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;
public class AwtGenerator {
    String zephyrBaseUrl;
    String accessKey;
    String secretKey;
    String accountId;
    String requestSpecificAPI;
    public AwtGenerator(){
        util.PropertyUtil pu= new util.PropertyUtil();
        this.zephyrBaseUrl= pu.getZephyrBaseUrl();
        this.accessKey= pu.getZapiAccessKey();
        this.secretKey= pu.getZapiSecretKey();
        this.accountId= pu.getJiraAccountId();
    }
    public static void main(String args[]){
        AwtGenerator awtg=new AwtGenerator();
        awtg.requestSpecificAPI="https://prod-api.zephyr4jiracloud.com/connect/public/rest/api/1.0/serverinfo";
//        System.out.println("URI :"+ awtg.updateExecution());
        System.out.println("Token :"+ awtg.getJWTToken());
    }


    public String getCycleURI(String projectId, String versionId){
        this.requestSpecificAPI= this.zephyrBaseUrl + "/public/rest/api/1.0/cycles/search?versionId="+versionId+"&expand=executionSummaries&projectId="+projectId;
        return this.requestSpecificAPI;
    }

    public String getAddCycleURI(String projectId, String versionId, String cycleName){
        this.requestSpecificAPI= this.zephyrBaseUrl + "/public/rest/api/1.0/cycle?name=" + cycleName + "&projectId=" + projectId + "&versionId=" + versionId;
        return this.requestSpecificAPI;
    }
    public String getExecutionList(String projectId, String versionId, String cycleId){
        this.requestSpecificAPI= this.zephyrBaseUrl + "/public/rest/api/1.0/executions/search/cycle/"+ cycleId +"?versionId="+ versionId +"&expand=executionSummaries&projectId=" + projectId;
        return this.requestSpecificAPI;
    }

    public String addAttachment(String projectId, String versionId, String cycleId, String issueId, String entityId, String comments){
        this.requestSpecificAPI= this.zephyrBaseUrl + "/public/rest/api/1.0/attachment?issueId="+ issueId +"&versionId="+ versionId +"&entityName=execution&cycleId="+ cycleId +"&entityId="+ entityId +"&comment="+ comments +"&projectId="+ projectId;
        return this.requestSpecificAPI;
    }

    public String updateExecution(){
        this.requestSpecificAPI= this.zephyrBaseUrl + "/public/rest/api/1.0/execution?id=3b3ad2e8-ae28-4273-aa71-115b17808911&issueId=10188&cycleId=e016b364-016e-455a-8ae1-ae0731ebf29c&versionId=10002&projectId=10009&status=1";
        return this.requestSpecificAPI;
    }

    public String getJWTToken(){
        try {
            String jwt_token = "";
            ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(this.zephyrBaseUrl, this.accessKey, this.secretKey, this.accountId).build();
            JwtGenerator jwtGenerator = client.getJwtGenerator();
            URI uri = new URI(this.requestSpecificAPI);
            int expirationInSec = 360;
            jwt_token = jwtGenerator.generateJWT("GET", uri, expirationInSec);
            return jwt_token;
        }catch(Exception e){
            new util.ExceptionHandler().customizedException("Not able to generate JWT Token");
            return "";
        }
    }

    public String postJWTToken(){
        try {
            String jwt_token = "";
            ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(this.zephyrBaseUrl, this.accessKey, this.secretKey, this.accountId).build();
            JwtGenerator jwtGenerator = client.getJwtGenerator();
            URI uri = new URI(this.requestSpecificAPI);
            int expirationInSec = 360;
            jwt_token = jwtGenerator.generateJWT("POST", uri, expirationInSec);
            return jwt_token;
        }catch(Exception e){
            new util.ExceptionHandler().customizedException("Not able to generate JWT Token");
            return "";
        }
    }

    public String putJWTToken(){
        try {
            String jwt_token = "";
            ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(this.zephyrBaseUrl, this.accessKey, this.secretKey, this.accountId).build();
            JwtGenerator jwtGenerator = client.getJwtGenerator();
            URI uri = new URI(this.requestSpecificAPI);
            int expirationInSec = 360;
            jwt_token = jwtGenerator.generateJWT("PUT", uri, expirationInSec);
            return jwt_token;
        }catch(Exception e){
            new util.ExceptionHandler().customizedException("Not able to generate JWT Token");
            return "";
        }
    }
}

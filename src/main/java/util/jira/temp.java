package util.jira;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

public class temp {
    public static void main(String args[]){
        Client client = ClientBuilder.newClient();
        Entity payload = Entity.json("");
        Response response = client.target("https://prod-api.zephyr4jiracloud.com/connect/public/rest/api/1.0/execution/3b3ad2e8-ae28-4273-aa71-115b17808911")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("Authorization", "JWT eyJhbGciOiJIUzI1NiI...")
                .header("zapiAccessKey", "amlyYTo3YjU3OTBhN...")
                .put(payload);

//        System.out.println("status: " + response.getStatus());
//        System.out.println("headers: " + response.getHeaders());
//        System.out.println("body:" + response.readEntity(String.class));
    }
}

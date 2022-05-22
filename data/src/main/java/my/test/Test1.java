package my.test;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Test1 {
  //https://search.51job.com/list/000000,000000,0000,00,9,99,Java,2,1.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=

  public static void main(String[] args) {
    HttpGet httpGet = new HttpGet("https://search.51job.com/list/000000,000000,0000,00,9,99,Java,2,1.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=");
    httpGet.setHeader("Accept","application/json");
    CloseableHttpClient httpClient = HttpClients.createDefault();
    try {
      CloseableHttpResponse response = httpClient.execute(httpGet);
      if (response.getStatusLine().getStatusCode()==200) {
        System.out.println("oK!");
        System.out.println(EntityUtils.toString(response.getEntity()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

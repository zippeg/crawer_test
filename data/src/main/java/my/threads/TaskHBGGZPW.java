package my.threads;

import my.model.HBGGZPW;
import my.parse.ParseData;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class TaskHBGGZPW implements Runnable{
//  http://www.hbggzp.cn/cache/cxk_gw/job/zpz/v1.0/query?PAGE=1&LINAGE=6&UCB005=&AAB301=420000"
  private String defaultPage;
  private volatile CountDownLatch countDownLatch;
  private String defaultLINAGE;
  private String UCB005;
  private List<HBGGZPW> list;
  private String AAB301;
  private String uri;
  private String url="";
  private CloseableHttpClient httpClient;
  public volatile boolean ok;
  public TaskHBGGZPW() {
    defaultPage="1";
    init();
    setPage(defaultPage);
  }
  public TaskHBGGZPW(String page) {
    init();
    this.defaultPage = page;
    setPage(page);

  }
  public void setCountDownLatch(CountDownLatch countDownLatch){
    this.countDownLatch=countDownLatch;
  }
  public List<HBGGZPW> getList(){
    return ok?list:null;
  }
  private void init() {
    ok=false;
    defaultLINAGE = "6";
    AAB301 = "420000";
    uri = "http://www.hbggzp.cn/cache/cxk_gw/job/zpz/v1.0/query?";
    UCB005 = "";
    url = "";
  }

  private TaskHBGGZPW build(String PAGE, String LINAGE, String UCB005, String AAB301){
   url = new StringBuilder(uri)
      .append("PAGE=" + PAGE)
      .append("LINAGE=" + LINAGE)
      .append("UCB005=" + UCB005)
      .append("AAB301=" + AAB301).toString();
   return this;

  }
  public TaskHBGGZPW setPage(String page){
    build(page,"6","","420000");
    return this;
  }
  @Override
  public  void run() {

    httpClient=HttpClients.createDefault();
    HttpGet httpGet = new HttpGet(url);
    try {
      CloseableHttpResponse response = httpClient.execute(httpGet);
      String json=EntityUtils.toString(response.getEntity());
      list=ParseData.parseHBDATA(json);
      if (list.size()>0){
          ok=true;
          countDownLatch.countDown();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

package my.threads;

import com.alibaba.fastjson.JSONObject;
import my.model.QCWY;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Task_QCWY implements Runnable{
  private CountDownLatch latch;
  private CloseableHttpClient httpClient;
  private String address;

  private String url;
  private HttpGet httpGet;
  private volatile boolean ok;
  private List<QCWY.EngineJdsDTO> data;

  //武汉职位,页面



  //https://search.51job.com/list/000000,000000,0000,00,9,99,Java,2,1.html
//https://search.51job.com/list/000000,000000,0000,00,9,99,Java,2,1.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=

  public Task_QCWY(String searchWord) {
    initUrl(searchWord,1+"");
    initHttp();
  }

  public Task_QCWY(String searchWord,String page) {
    initUrl(searchWord,page);
    initHttp();
  }

  private void initUrl(String searchWord, String page) {
    this.url = "https://search.51job.com/list/000000,000000,0000,00,9,99,"+searchWord+",2,"+page+".html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=";
  }
  private void initHttp() {
    httpGet = new HttpGet(url);
    httpGet.setHeader("Accept","application/json");
    httpGet.setHeader("Cookie","_uab_collina=165318059522872525850724; guid=c8f53a67d366dc38dc89d22141c74cf8; nsearch=jobarea%3D%26%7C%26ord_field%3D%26%7C%26recentSearch0%3D%26%7C%26recentSearch1%3D%26%7C%26recentSearch2%3D%26%7C%26recentSearch3%3D%26%7C%26recentSearch4%3D%26%7C%26collapse_expansion%3D; ps=needv%3D0; partner=baidupz; privacy=1653180580; slife=lowbrowser%3Dnot%26%7C%26lastlogindate%3D20220522%26%7C%26securetime%3D; acw_tc=76b20ff116531863837572538e09de14a5e8c97fc96530120b6f4850522c09; acw_sc__v2=62899f5f587302ec5f6b321c84cab17884856e0a; acw_sc__v2=62899f650f118b94c100245a1f1d31293c16553a; search=jobarea%7E%60000000%7C%21ord_field%7E%600%7C%21recentSearch0%7E%60000000%A1%FB%A1%FA000000%A1%FB%A1%FA0000%A1%FB%A1%FA00%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA9%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA0%A1%FB%A1%FAJava%A1%FB%A1%FA2%A1%FB%A1%FA1%7C%21recentSearch1%7E%60000000%A1%FB%A1%FA000000%A1%FB%A1%FA0000%A1%FB%A1%FA00%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA9%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA0%A1%FB%A1%FA%BB%AF%B9%A4%A1%FB%A1%FA2%A1%FB%A1%FA1%7C%21recentSearch2%7E%60000000%A1%FB%A1%FA000000%A1%FB%A1%FA0000%A1%FB%A1%FA00%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA9%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA0%A1%FB%A1%FAjava%A1%FB%A1%FA2%A1%FB%A1%FA1%7C%21recentSearch3%7E%60180200%A1%FB%A1%FA000000%A1%FB%A1%FA0000%A1%FB%A1%FA00%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA9%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA0%A1%FB%A1%FAjava%A1%FB%A1%FA2%A1%FB%A1%FA1%7C%21recentSearch4%7E%60000000%A1%FB%A1%FA000000%A1%FB%A1%FA0000%A1%FB%A1%FA00%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA9%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA0%A1%FB%A1%FAJAVA%A1%FB%A1%FA2%A1%FB%A1%FA1%7C%21; ssxmod_itna=Yq0x2DcDuDgDnBDy0DzgQWq0IphAw87YWRiKRDBdh4iNDnD8x7YDvA+1YDGh87sD+1e+mb7oqQ/68BUa31RirrvZ+ix0aDbqGk3iEh4GGfxBYDQxAYDGDDp8Dj4ibDYbU7DjjtzZMLdqiOD7eDXxGCDQKGVxDaDGc8kYn8nEphD+YDnED1K708D75Dux0HYiStLxDCpzStSr5vz4i3EWKhe40OD09+R2P+DB+klOv7uSwqEQGqWnTxWG033B2qMAGK=yGxSehKlGrx3xhymm2g7jqDiO0tEvhDD=; ssxmod_itna2=Yq0x2DcDuDgDnBDy0DzgQWq0IphAw87YWRiKD8q1DrwDGNmY=GanCiAaWYCzaAO7i0YV4bYAIHtA=DDQ5H9CBKEzY8pOafWd46IxXx24APGmE+0gdRgQvm1e8mcFeZCq0ov5879QMuUCDf3Ri4QMi4oVYwhGRL0PLw=qGCrMefoYa8NA7Ej3k8R944AxAnT6iBX5dux5yTvYCbxsmLTjbDN4a8DI9q2sK46/G2h8iu2ez2D7unXi2cNyFWEu4K3R0zt6W3k4hoMClMHgfSH0jIkjKI3tgdE+K43PKixEUuGcG1bmvj1Bm=fDw7pNtgInro8eYwDPe7DIceBDojn5BQXC=I4e2/CN33etbwNe27aPBaolcpHGrA60o+59gbceRF95pDXxC3Gn5Y+eKzPKSdHUpClT5Zu1ILsEbZ=5z2Qmi3VjwgQtplfg7U+GwgBUaznC1dUl5eKxgmu8Z4AiXVDFsnK2rqM0aqoRVQjCi0KmaM8IAfY9WLgWqZSKgAyli34G4DQ98D08DiQvYD==");
    httpClient = HttpClients.createDefault();
  }


  public void setLatch(CountDownLatch latch){
    this.latch=latch;
   }

  public boolean isOk() {
    return ok;
  }

  public List<QCWY.EngineJdsDTO> getData() {
    return data;
  }

  //
  @Override
  public void run() {
    ok=false;
    try {
      CloseableHttpResponse response = httpClient.execute(httpGet);
      String json = EntityUtils.toString(response.getEntity());
      QCWY qcwy = JSONObject.parseObject(json, QCWY.class);
      data=qcwy.getEngineJds();
      ok=true;
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (latch!=null){
        latch.countDown();
      }
  }



}

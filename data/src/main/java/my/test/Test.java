package my.test;


import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import my.model.HBGGZPW;
import my.model.QCWY;
import my.threads.TaskHBGGZPW;
import my.threads.Task_QCWY;
import my.utils.Util_HBGGZPW;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Test {
  //湖北公共招聘网url: http://www.hbggzp.cn/cache/cxk_gw/job/zpz/v1.0/query?PAGE=1&LINAGE=6&UCB005=&AAB301=420000
//https://search.51job.com/list/000000,000000,0000,00,9,99,Java,2,1.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=
  public static void main(String[] args) throws InterruptedException, IOException {
    //写Excel
    List<QCWY.EngineJdsDTO> data = Util_HBGGZPW.getData("化工", 10);
    System.out.println(data.size());
    System.out.println(data);
    EasyExcel.write("C:\\Users\\Apeng\\Desktop\\卷王.xlsx",QCWY.EngineJdsDTO.class).sheet().doWrite(data);
  }

}

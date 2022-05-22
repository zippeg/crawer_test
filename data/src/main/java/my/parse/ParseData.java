package my.parse;

import com.alibaba.fastjson.JSONObject;
import my.model.HBGGZPW;
import my.model.HBGGZPWList;
import my.model.QCWY;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseData {
  public static List<HBGGZPW> parseHBDATA(String json){
    List<HBGGZPW> data= new ArrayList<>();
    HBGGZPWList hbggzpw = JSONObject.parseObject(json, HBGGZPWList.class);
    data=hbggzpw.getResult().getRows();
    return data;
  }
  public static List<QCWY> parseQCWYDATA(){
    List<QCWY> data=null;
    return data;
  }
}

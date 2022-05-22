package my.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.*;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

@Data
@HeadRowHeight(value = 30)
@HeadStyle(horizontalAlignment = HorizontalAlignment.CENTER)
@ContentStyle(horizontalAlignment =HorizontalAlignment.CENTER)
public class HBGGZPW {
  //"AAC011REMARK": "学历",
  @JSONField(name = "AAC011REMARK")
  @ColumnWidth(value = 14)
  @ExcelProperty(value = {" 湖北公共招聘网招聘信息100页抓取","学历"})
  private String education;
  //"UCE466": "发布日期"
  @ColumnWidth(value = 30)
  @ExcelProperty(value = {" 湖北公共招聘网招聘信息100页抓取","发布日期"})
  @JSONField(name = "UCE466")
  private String updateTime;
  //联系人称呼
  @ JSONField(name = "AAE004")

  @ExcelProperty(value =  {" 湖北公共招聘网招聘信息100页抓取","联系人"})
  @ColumnWidth(value = 14)
  private String contacts;
  //  公司名称
  @JSONField(name = "AAB004")
  @ColumnWidth(value = 30)
  @ExcelProperty(value =  {" 湖北公共招聘网招聘信息100页抓取","公司名称"})
  private String corporateName;
  //ACB215REMARK 岗位名称
  @ JSONField(name = "ACB215REMARK")
  @ExcelProperty(value =  {" 湖北公共招聘网招聘信息100页抓取","岗位名称"})
  @ColumnWidth(value = 25)
  private String jobName;
  //ACB21AREMARK 工资
  @ JSONField(name = "ACB21AREMARK")
  @ExcelProperty(value =  {" 湖北公共招聘网招聘信息100页抓取","工资待遇"})
  @ColumnWidth(value = 14)
  private String salary;
  //AAE005 phone
  @ JSONField(name = "AAE005")
  @ColumnWidth(value = 14)
  @ExcelProperty(value =  {" 湖北公共招聘网招聘信息100页抓取","联系电话"})
  private String phone;
  //AAB301REMARK 地区
  @ExcelProperty(value =  {" 湖北公共招聘网招聘信息100页抓取","地区"})
  @ JSONField(name = "AAB301REMARK")
  @ColumnWidth(value = 14)
  private String address;
}

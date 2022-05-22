package my.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.util.List;

@NoArgsConstructor
@Data
public class QCWY {

  @JSONField(name = "top_ads")
  private List<?> topAds;
  @JSONField(name = "auction_ads")
  private List<?> auctionAds;
  @JSONField(name = "market_ads")
  private List<?> marketAds;
  @JSONField(name = "engine_jds")
  private List<EngineJdsDTO> engineJds;
  @JSONField(name = "jobid_count")
  private String jobidCount;
  @JSONField(name = "group")
  private List<?> group;
  @JSONField(name = "banner_ads")
  private String bannerAds;
  @JSONField(name = "is_collapseexpansion")
  private String isCollapseexpansion;
  @JSONField(name = "co_ads")
  private List<?> coAds;
  @JSONField(name = "keyword_recommendation")
  private KeywordRecommendationDTO keywordRecommendation;
  @JSONField(name = "search_condition")
  private SearchConditionDTO searchCondition;
  @JSONField(name = "searched_condition")
  private String searchedCondition;
  @JSONField(name = "curr_page")
  private String currPage;
  @JSONField(name = "total_page")
  private String totalPage;
  @JSONField(name = "keyword_ads")
  private List<?> keywordAds;
  @JSONField(name = "job_search_assistance")
  private String jobSearchAssistance;
  @JSONField(name = "seo_title")
  private String seoTitle;
  @JSONField(name = "seo_description")
  private String seoDescription;
  @JSONField(name = "seo_keywords")
  private String seoKeywords;

  @NoArgsConstructor
  @Data
  public static class KeywordRecommendationDTO {
    @JSONField(name = "title")
    private String title;
    @JSONField(name = "data_type")
    private String dataType;
    @JSONField(name = "keyword")
    private String keyword;
    @JSONField(name = "data")
    private List<DataDTO> data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
      @JSONField(name = "href")
      private String href;
      @JSONField(name = "text")
      private String text;
      @JSONField(name = "click")
      private String click;
    }
  }

  @NoArgsConstructor
  @Data
  public static class SearchConditionDTO {
    @JSONField(name = "lang")
    private String lang;
    @JSONField(name = "keywordtype")
    private String keywordtype;
    @JSONField(name = "ord_field")
    private String ordField;
    @JSONField(name = "jobarea")
    private String jobarea;
    @JSONField(name = "curr_page")
    private String currPage;
    @JSONField(name = "workarea")
    private String workarea;
    @JSONField(name = "district")
    private String district;
    @JSONField(name = "dibiaoid")
    private String dibiaoid;
    @JSONField(name = "postchannel")
    private String postchannel;
    @JSONField(name = "reservechannel")
    private String reservechannel;
    @JSONField(name = "issuedate")
    private String issuedate;
    @JSONField(name = "providesalary")
    private String providesalary;
    @JSONField(name = "degreefrom")
    private String degreefrom;
    @JSONField(name = "companysize")
    private String companysize;
    @JSONField(name = "cotype")
    private String cotype;
    @JSONField(name = "workyear")
    private String workyear;
    @JSONField(name = "industrytype")
    private String industrytype;
    @JSONField(name = "funtype")
    private String funtype;
    @JSONField(name = "jobterm")
    private String jobterm;
    @JSONField(name = "keyword")
    private String keyword;
    @JSONField(name = "welfare")
    private String welfare;
    @JSONField(name = "address")
    private String address;
    @JSONField(name = "line")
    private String line;
    @JSONField(name = "confirmdate")
    private String confirmdate;
    @JSONField(name = "radius")
    private String radius;
    @JSONField(name = "lonlat")
    private String lonlat;
    @JSONField(name = "exparea")
    private String exparea;
    @JSONField(name = "groupid")
    private String groupid;
    @JSONField(name = "coid")
    private String coid;
  }

  @NoArgsConstructor
  @Data
  @HeadStyle(horizontalAlignment = HorizontalAlignment.CENTER)
  @ContentStyle(horizontalAlignment =HorizontalAlignment.CENTER)
  @HeadRowHeight(30)
  public static class EngineJdsDTO {
    @ColumnWidth(20)
@ExcelProperty({"前程无忧招聘信息","工作名称"})
    @JSONField(name = "job_name")
    private String jobName;

    @ColumnWidth(20)
@ExcelProperty({"前程无忧招聘信息","工作标题"})
    @JSONField(name = "job_title")
    private String jobTitle;

    @ColumnWidth(30)
@ExcelProperty({"前程无忧招聘信息","公司名称"})
    @JSONField(name = "company_name")
    private String companyName;

    @ColumnWidth(15)
@ExcelProperty({"前程无忧招聘信息","薪资标准"})
    @JSONField(name = "providesalary_text")
    private String providesalaryText;

    @ColumnWidth(15)
@ExcelProperty({"前程无忧招聘信息","地区"})
    @JSONField(name = "workarea_text")
    private String workareaText;

    @ColumnWidth(10)
@ExcelProperty({"前程无忧招聘信息","更新时间"})
    @JSONField(name = "updatedate")
    private String updatedate;

    @ColumnWidth(10)
@ExcelProperty({"前程无忧招聘信息","公司性质"})
    @JSONField(name = "companytype_text")
    private String companytypeText;

    @ColumnWidth(10)
@ExcelProperty({"前程无忧招聘信息","工作年限"})
    @JSONField(name = "workyear")
    private String workyear;

    @ColumnWidth(20)
@ExcelProperty({"前程无忧招聘信息","发布时间"})
    @JSONField(name = "issuedate")
    private String issuedate;

    @ColumnWidth(20)
@ExcelProperty({"前程无忧招聘信息","所属行业"})
    @JSONField(name = "companyind_text")
    private String companyindText;

    @ColumnWidth(20)
@ExcelProperty({"前程无忧招聘信息","招聘链接"})
    @JSONField(name = "job_href")
    private String jobHref;
  }
}

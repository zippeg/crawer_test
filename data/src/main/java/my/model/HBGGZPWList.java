package my.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
public class HBGGZPWList {

  @JSONField(name = "Result")
  private ResultDTO result;
  @JSONField(name = "IsOK")
  private boolean isOK;
  @JSONField(name = "Code")
  private String code;

  @NoArgsConstructor
  @Data
  public static class ResultDTO {
    @JSONField(name = "Total")
    private int total;
    @JSONField(name = "Rows")
    private List<HBGGZPW> rows;
  }
}

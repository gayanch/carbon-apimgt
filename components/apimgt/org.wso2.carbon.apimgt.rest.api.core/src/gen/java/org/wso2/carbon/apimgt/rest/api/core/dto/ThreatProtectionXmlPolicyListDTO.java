package org.wso2.carbon.apimgt.rest.api.core.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.wso2.carbon.apimgt.rest.api.core.dto.ThreatProtectionXmlPolicyDTO;
import java.util.Objects;

/**
 * ThreatProtectionXmlPolicyListDTO
 */
public class ThreatProtectionXmlPolicyListDTO   {
  @JsonProperty("list")
  private List<ThreatProtectionXmlPolicyDTO> list = new ArrayList<ThreatProtectionXmlPolicyDTO>();

  public ThreatProtectionXmlPolicyListDTO list(List<ThreatProtectionXmlPolicyDTO> list) {
    this.list = list;
    return this;
  }

  public ThreatProtectionXmlPolicyListDTO addListItem(ThreatProtectionXmlPolicyDTO listItem) {
    this.list.add(listItem);
    return this;
  }

   /**
   * Get list
   * @return list
  **/
  @ApiModelProperty(value = "")
  public List<ThreatProtectionXmlPolicyDTO> getList() {
    return list;
  }

  public void setList(List<ThreatProtectionXmlPolicyDTO> list) {
    this.list = list;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ThreatProtectionXmlPolicyListDTO threatProtectionXmlPolicyList = (ThreatProtectionXmlPolicyListDTO) o;
    return Objects.equals(this.list, threatProtectionXmlPolicyList.list);
  }

  @Override
  public int hashCode() {
    return Objects.hash(list);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ThreatProtectionXmlPolicyListDTO {\n");
    
    sb.append("    list: ").append(toIndentedString(list)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


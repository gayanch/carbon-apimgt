package org.wso2.carbon.apimgt.rest.api.core.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * ThreatProtectionJsonPolicyDTO
 */
public class ThreatProtectionJsonPolicyDTO   {
  @JsonProperty("enabled")
  private Boolean enabled = null;

  @JsonProperty("apiId")
  private String apiId = null;

  @JsonProperty("maxFieldCount")
  private Integer maxFieldCount = null;

  @JsonProperty("maxStringLength")
  private Integer maxStringLength = null;

  @JsonProperty("maxArrayElementCount")
  private Integer maxArrayElementCount = null;

  @JsonProperty("maxFieldLength")
  private Integer maxFieldLength = null;

  @JsonProperty("maxDepth")
  private Integer maxDepth = null;

  public ThreatProtectionJsonPolicyDTO enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

   /**
   * Enabled/Disabled status
   * @return enabled
  **/
  @ApiModelProperty(required = true, value = "Enabled/Disabled status")
  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public ThreatProtectionJsonPolicyDTO apiId(String apiId) {
    this.apiId = apiId;
    return this;
  }

   /**
   * API ID
   * @return apiId
  **/
  @ApiModelProperty(required = true, value = "API ID")
  public String getApiId() {
    return apiId;
  }

  public void setApiId(String apiId) {
    this.apiId = apiId;
  }

  public ThreatProtectionJsonPolicyDTO maxFieldCount(Integer maxFieldCount) {
    this.maxFieldCount = maxFieldCount;
    return this;
  }

   /**
   * Maximum number of fields allowed on json document
   * @return maxFieldCount
  **/
  @ApiModelProperty(required = true, value = "Maximum number of fields allowed on json document")
  public Integer getMaxFieldCount() {
    return maxFieldCount;
  }

  public void setMaxFieldCount(Integer maxFieldCount) {
    this.maxFieldCount = maxFieldCount;
  }

  public ThreatProtectionJsonPolicyDTO maxStringLength(Integer maxStringLength) {
    this.maxStringLength = maxStringLength;
    return this;
  }

   /**
   * Maximum string length allowed
   * @return maxStringLength
  **/
  @ApiModelProperty(required = true, value = "Maximum string length allowed")
  public Integer getMaxStringLength() {
    return maxStringLength;
  }

  public void setMaxStringLength(Integer maxStringLength) {
    this.maxStringLength = maxStringLength;
  }

  public ThreatProtectionJsonPolicyDTO maxArrayElementCount(Integer maxArrayElementCount) {
    this.maxArrayElementCount = maxArrayElementCount;
    return this;
  }

   /**
   * Maximum array elements allowed
   * @return maxArrayElementCount
  **/
  @ApiModelProperty(required = true, value = "Maximum array elements allowed")
  public Integer getMaxArrayElementCount() {
    return maxArrayElementCount;
  }

  public void setMaxArrayElementCount(Integer maxArrayElementCount) {
    this.maxArrayElementCount = maxArrayElementCount;
  }

  public ThreatProtectionJsonPolicyDTO maxFieldLength(Integer maxFieldLength) {
    this.maxFieldLength = maxFieldLength;
    return this;
  }

   /**
   * Maximum field length allowed (in chars)
   * @return maxFieldLength
  **/
  @ApiModelProperty(required = true, value = "Maximum field length allowed (in chars)")
  public Integer getMaxFieldLength() {
    return maxFieldLength;
  }

  public void setMaxFieldLength(Integer maxFieldLength) {
    this.maxFieldLength = maxFieldLength;
  }

  public ThreatProtectionJsonPolicyDTO maxDepth(Integer maxDepth) {
    this.maxDepth = maxDepth;
    return this;
  }

   /**
   * Maximum depth allowed
   * @return maxDepth
  **/
  @ApiModelProperty(required = true, value = "Maximum depth allowed")
  public Integer getMaxDepth() {
    return maxDepth;
  }

  public void setMaxDepth(Integer maxDepth) {
    this.maxDepth = maxDepth;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ThreatProtectionJsonPolicyDTO threatProtectionJsonPolicy = (ThreatProtectionJsonPolicyDTO) o;
    return Objects.equals(this.enabled, threatProtectionJsonPolicy.enabled) &&
        Objects.equals(this.apiId, threatProtectionJsonPolicy.apiId) &&
        Objects.equals(this.maxFieldCount, threatProtectionJsonPolicy.maxFieldCount) &&
        Objects.equals(this.maxStringLength, threatProtectionJsonPolicy.maxStringLength) &&
        Objects.equals(this.maxArrayElementCount, threatProtectionJsonPolicy.maxArrayElementCount) &&
        Objects.equals(this.maxFieldLength, threatProtectionJsonPolicy.maxFieldLength) &&
        Objects.equals(this.maxDepth, threatProtectionJsonPolicy.maxDepth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enabled, apiId, maxFieldCount, maxStringLength, maxArrayElementCount, maxFieldLength, maxDepth);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ThreatProtectionJsonPolicyDTO {\n");
    
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    apiId: ").append(toIndentedString(apiId)).append("\n");
    sb.append("    maxFieldCount: ").append(toIndentedString(maxFieldCount)).append("\n");
    sb.append("    maxStringLength: ").append(toIndentedString(maxStringLength)).append("\n");
    sb.append("    maxArrayElementCount: ").append(toIndentedString(maxArrayElementCount)).append("\n");
    sb.append("    maxFieldLength: ").append(toIndentedString(maxFieldLength)).append("\n");
    sb.append("    maxDepth: ").append(toIndentedString(maxDepth)).append("\n");
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


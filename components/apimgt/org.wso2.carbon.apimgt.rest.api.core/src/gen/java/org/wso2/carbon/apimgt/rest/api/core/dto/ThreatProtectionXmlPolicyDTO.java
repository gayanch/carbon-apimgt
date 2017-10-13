package org.wso2.carbon.apimgt.rest.api.core.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * ThreatProtectionXmlPolicyDTO
 */
public class ThreatProtectionXmlPolicyDTO   {
  @JsonProperty("enabled")
  private Boolean enabled = null;

  @JsonProperty("apiId")
  private String apiId = null;

  @JsonProperty("dtdEnabled")
  private Boolean dtdEnabled = null;

  @JsonProperty("externalEntitiesEnabled")
  private Boolean externalEntitiesEnabled = null;

  @JsonProperty("maxDepth")
  private Integer maxDepth = null;

  @JsonProperty("maxElementCount")
  private Integer maxElementCount = null;

  @JsonProperty("maxAttributeCount")
  private Integer maxAttributeCount = null;

  @JsonProperty("maxAttributeLength")
  private Integer maxAttributeLength = null;

  @JsonProperty("entityExpansionLimit")
  private Integer entityExpansionLimit = null;

  @JsonProperty("maxChildrenPerElement")
  private Integer maxChildrenPerElement = null;

  public ThreatProtectionXmlPolicyDTO enabled(Boolean enabled) {
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

  public ThreatProtectionXmlPolicyDTO apiId(String apiId) {
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

  public ThreatProtectionXmlPolicyDTO dtdEnabled(Boolean dtdEnabled) {
    this.dtdEnabled = dtdEnabled;
    return this;
  }

   /**
   * is DTD Enabled
   * @return dtdEnabled
  **/
  @ApiModelProperty(required = true, value = "is DTD Enabled")
  public Boolean getDtdEnabled() {
    return dtdEnabled;
  }

  public void setDtdEnabled(Boolean dtdEnabled) {
    this.dtdEnabled = dtdEnabled;
  }

  public ThreatProtectionXmlPolicyDTO externalEntitiesEnabled(Boolean externalEntitiesEnabled) {
    this.externalEntitiesEnabled = externalEntitiesEnabled;
    return this;
  }

   /**
   * Is external entities enabled
   * @return externalEntitiesEnabled
  **/
  @ApiModelProperty(required = true, value = "Is external entities enabled")
  public Boolean getExternalEntitiesEnabled() {
    return externalEntitiesEnabled;
  }

  public void setExternalEntitiesEnabled(Boolean externalEntitiesEnabled) {
    this.externalEntitiesEnabled = externalEntitiesEnabled;
  }

  public ThreatProtectionXmlPolicyDTO maxDepth(Integer maxDepth) {
    this.maxDepth = maxDepth;
    return this;
  }

   /**
   * Max Depth
   * @return maxDepth
  **/
  @ApiModelProperty(required = true, value = "Max Depth")
  public Integer getMaxDepth() {
    return maxDepth;
  }

  public void setMaxDepth(Integer maxDepth) {
    this.maxDepth = maxDepth;
  }

  public ThreatProtectionXmlPolicyDTO maxElementCount(Integer maxElementCount) {
    this.maxElementCount = maxElementCount;
    return this;
  }

   /**
   * Maximum elements
   * @return maxElementCount
  **/
  @ApiModelProperty(required = true, value = "Maximum elements")
  public Integer getMaxElementCount() {
    return maxElementCount;
  }

  public void setMaxElementCount(Integer maxElementCount) {
    this.maxElementCount = maxElementCount;
  }

  public ThreatProtectionXmlPolicyDTO maxAttributeCount(Integer maxAttributeCount) {
    this.maxAttributeCount = maxAttributeCount;
    return this;
  }

   /**
   * Maximum attributes allowed
   * @return maxAttributeCount
  **/
  @ApiModelProperty(required = true, value = "Maximum attributes allowed")
  public Integer getMaxAttributeCount() {
    return maxAttributeCount;
  }

  public void setMaxAttributeCount(Integer maxAttributeCount) {
    this.maxAttributeCount = maxAttributeCount;
  }

  public ThreatProtectionXmlPolicyDTO maxAttributeLength(Integer maxAttributeLength) {
    this.maxAttributeLength = maxAttributeLength;
    return this;
  }

   /**
   * Maximum length of an attribute (in chars)
   * @return maxAttributeLength
  **/
  @ApiModelProperty(required = true, value = "Maximum length of an attribute (in chars)")
  public Integer getMaxAttributeLength() {
    return maxAttributeLength;
  }

  public void setMaxAttributeLength(Integer maxAttributeLength) {
    this.maxAttributeLength = maxAttributeLength;
  }

  public ThreatProtectionXmlPolicyDTO entityExpansionLimit(Integer entityExpansionLimit) {
    this.entityExpansionLimit = entityExpansionLimit;
    return this;
  }

   /**
   * Maximum number of entity expansions allowed
   * @return entityExpansionLimit
  **/
  @ApiModelProperty(required = true, value = "Maximum number of entity expansions allowed")
  public Integer getEntityExpansionLimit() {
    return entityExpansionLimit;
  }

  public void setEntityExpansionLimit(Integer entityExpansionLimit) {
    this.entityExpansionLimit = entityExpansionLimit;
  }

  public ThreatProtectionXmlPolicyDTO maxChildrenPerElement(Integer maxChildrenPerElement) {
    this.maxChildrenPerElement = maxChildrenPerElement;
    return this;
  }

   /**
   * Maximum children per element
   * @return maxChildrenPerElement
  **/
  @ApiModelProperty(required = true, value = "Maximum children per element")
  public Integer getMaxChildrenPerElement() {
    return maxChildrenPerElement;
  }

  public void setMaxChildrenPerElement(Integer maxChildrenPerElement) {
    this.maxChildrenPerElement = maxChildrenPerElement;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ThreatProtectionXmlPolicyDTO threatProtectionXmlPolicy = (ThreatProtectionXmlPolicyDTO) o;
    return Objects.equals(this.enabled, threatProtectionXmlPolicy.enabled) &&
        Objects.equals(this.apiId, threatProtectionXmlPolicy.apiId) &&
        Objects.equals(this.dtdEnabled, threatProtectionXmlPolicy.dtdEnabled) &&
        Objects.equals(this.externalEntitiesEnabled, threatProtectionXmlPolicy.externalEntitiesEnabled) &&
        Objects.equals(this.maxDepth, threatProtectionXmlPolicy.maxDepth) &&
        Objects.equals(this.maxElementCount, threatProtectionXmlPolicy.maxElementCount) &&
        Objects.equals(this.maxAttributeCount, threatProtectionXmlPolicy.maxAttributeCount) &&
        Objects.equals(this.maxAttributeLength, threatProtectionXmlPolicy.maxAttributeLength) &&
        Objects.equals(this.entityExpansionLimit, threatProtectionXmlPolicy.entityExpansionLimit) &&
        Objects.equals(this.maxChildrenPerElement, threatProtectionXmlPolicy.maxChildrenPerElement);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enabled, apiId, dtdEnabled, externalEntitiesEnabled, maxDepth, maxElementCount, maxAttributeCount, maxAttributeLength, entityExpansionLimit, maxChildrenPerElement);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ThreatProtectionXmlPolicyDTO {\n");
    
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    apiId: ").append(toIndentedString(apiId)).append("\n");
    sb.append("    dtdEnabled: ").append(toIndentedString(dtdEnabled)).append("\n");
    sb.append("    externalEntitiesEnabled: ").append(toIndentedString(externalEntitiesEnabled)).append("\n");
    sb.append("    maxDepth: ").append(toIndentedString(maxDepth)).append("\n");
    sb.append("    maxElementCount: ").append(toIndentedString(maxElementCount)).append("\n");
    sb.append("    maxAttributeCount: ").append(toIndentedString(maxAttributeCount)).append("\n");
    sb.append("    maxAttributeLength: ").append(toIndentedString(maxAttributeLength)).append("\n");
    sb.append("    entityExpansionLimit: ").append(toIndentedString(entityExpansionLimit)).append("\n");
    sb.append("    maxChildrenPerElement: ").append(toIndentedString(maxChildrenPerElement)).append("\n");
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


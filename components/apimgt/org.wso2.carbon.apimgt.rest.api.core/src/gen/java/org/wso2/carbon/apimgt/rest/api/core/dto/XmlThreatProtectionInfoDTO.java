package org.wso2.carbon.apimgt.rest.api.core.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.wso2.carbon.apimgt.rest.api.core.dto.CredentialsDTO;
import java.util.Objects;

/**
 * XmlThreatProtectionInfoDTO
 */
public class XmlThreatProtectionInfoDTO   {
  @JsonProperty("dtdEnabled")
  private Boolean dtdEnabled = null;

  @JsonProperty("externalEntitiesEnabled")
  private Boolean externalEntitiesEnabled = null;

  @JsonProperty("maxDepth")
  private Integer maxDepth = null;

  @JsonProperty("elementCount")
  private Integer elementCount = null;

  @JsonProperty("attributeCount")
  private Integer attributeCount = null;

  @JsonProperty("attributeLength")
  private Integer attributeLength = null;

  @JsonProperty("entityExpansionLimit")
  private Integer entityExpansionLimit = null;

  @JsonProperty("childrenPerElement")
  private Integer childrenPerElement = null;

  @JsonProperty("credentials")
  private CredentialsDTO credentials = null;

  public XmlThreatProtectionInfoDTO dtdEnabled(Boolean dtdEnabled) {
    this.dtdEnabled = dtdEnabled;
    return this;
  }

   /**
   * Get dtdEnabled
   * @return dtdEnabled
  **/
  @ApiModelProperty(example = "false", value = "")
  public Boolean getDtdEnabled() {
    return dtdEnabled;
  }

  public void setDtdEnabled(Boolean dtdEnabled) {
    this.dtdEnabled = dtdEnabled;
  }

  public XmlThreatProtectionInfoDTO externalEntitiesEnabled(Boolean externalEntitiesEnabled) {
    this.externalEntitiesEnabled = externalEntitiesEnabled;
    return this;
  }

   /**
   * Get externalEntitiesEnabled
   * @return externalEntitiesEnabled
  **/
  @ApiModelProperty(example = "false", value = "")
  public Boolean getExternalEntitiesEnabled() {
    return externalEntitiesEnabled;
  }

  public void setExternalEntitiesEnabled(Boolean externalEntitiesEnabled) {
    this.externalEntitiesEnabled = externalEntitiesEnabled;
  }

  public XmlThreatProtectionInfoDTO maxDepth(Integer maxDepth) {
    this.maxDepth = maxDepth;
    return this;
  }

   /**
   * Get maxDepth
   * @return maxDepth
  **/
  @ApiModelProperty(value = "")
  public Integer getMaxDepth() {
    return maxDepth;
  }

  public void setMaxDepth(Integer maxDepth) {
    this.maxDepth = maxDepth;
  }

  public XmlThreatProtectionInfoDTO elementCount(Integer elementCount) {
    this.elementCount = elementCount;
    return this;
  }

   /**
   * Get elementCount
   * @return elementCount
  **/
  @ApiModelProperty(value = "")
  public Integer getElementCount() {
    return elementCount;
  }

  public void setElementCount(Integer elementCount) {
    this.elementCount = elementCount;
  }

  public XmlThreatProtectionInfoDTO attributeCount(Integer attributeCount) {
    this.attributeCount = attributeCount;
    return this;
  }

   /**
   * Get attributeCount
   * @return attributeCount
  **/
  @ApiModelProperty(value = "")
  public Integer getAttributeCount() {
    return attributeCount;
  }

  public void setAttributeCount(Integer attributeCount) {
    this.attributeCount = attributeCount;
  }

  public XmlThreatProtectionInfoDTO attributeLength(Integer attributeLength) {
    this.attributeLength = attributeLength;
    return this;
  }

   /**
   * Get attributeLength
   * @return attributeLength
  **/
  @ApiModelProperty(value = "")
  public Integer getAttributeLength() {
    return attributeLength;
  }

  public void setAttributeLength(Integer attributeLength) {
    this.attributeLength = attributeLength;
  }

  public XmlThreatProtectionInfoDTO entityExpansionLimit(Integer entityExpansionLimit) {
    this.entityExpansionLimit = entityExpansionLimit;
    return this;
  }

   /**
   * Get entityExpansionLimit
   * @return entityExpansionLimit
  **/
  @ApiModelProperty(value = "")
  public Integer getEntityExpansionLimit() {
    return entityExpansionLimit;
  }

  public void setEntityExpansionLimit(Integer entityExpansionLimit) {
    this.entityExpansionLimit = entityExpansionLimit;
  }

  public XmlThreatProtectionInfoDTO childrenPerElement(Integer childrenPerElement) {
    this.childrenPerElement = childrenPerElement;
    return this;
  }

   /**
   * Get childrenPerElement
   * @return childrenPerElement
  **/
  @ApiModelProperty(value = "")
  public Integer getChildrenPerElement() {
    return childrenPerElement;
  }

  public void setChildrenPerElement(Integer childrenPerElement) {
    this.childrenPerElement = childrenPerElement;
  }

  public XmlThreatProtectionInfoDTO credentials(CredentialsDTO credentials) {
    this.credentials = credentials;
    return this;
  }

   /**
   * Get credentials
   * @return credentials
  **/
  @ApiModelProperty(value = "")
  public CredentialsDTO getCredentials() {
    return credentials;
  }

  public void setCredentials(CredentialsDTO credentials) {
    this.credentials = credentials;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    XmlThreatProtectionInfoDTO xmlThreatProtectionInfo = (XmlThreatProtectionInfoDTO) o;
    return Objects.equals(this.dtdEnabled, xmlThreatProtectionInfo.dtdEnabled) &&
        Objects.equals(this.externalEntitiesEnabled, xmlThreatProtectionInfo.externalEntitiesEnabled) &&
        Objects.equals(this.maxDepth, xmlThreatProtectionInfo.maxDepth) &&
        Objects.equals(this.elementCount, xmlThreatProtectionInfo.elementCount) &&
        Objects.equals(this.attributeCount, xmlThreatProtectionInfo.attributeCount) &&
        Objects.equals(this.attributeLength, xmlThreatProtectionInfo.attributeLength) &&
        Objects.equals(this.entityExpansionLimit, xmlThreatProtectionInfo.entityExpansionLimit) &&
        Objects.equals(this.childrenPerElement, xmlThreatProtectionInfo.childrenPerElement) &&
        Objects.equals(this.credentials, xmlThreatProtectionInfo.credentials);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dtdEnabled, externalEntitiesEnabled, maxDepth, elementCount, attributeCount, attributeLength, entityExpansionLimit, childrenPerElement, credentials);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class XmlThreatProtectionInfoDTO {\n");
    
    sb.append("    dtdEnabled: ").append(toIndentedString(dtdEnabled)).append("\n");
    sb.append("    externalEntitiesEnabled: ").append(toIndentedString(externalEntitiesEnabled)).append("\n");
    sb.append("    maxDepth: ").append(toIndentedString(maxDepth)).append("\n");
    sb.append("    elementCount: ").append(toIndentedString(elementCount)).append("\n");
    sb.append("    attributeCount: ").append(toIndentedString(attributeCount)).append("\n");
    sb.append("    attributeLength: ").append(toIndentedString(attributeLength)).append("\n");
    sb.append("    entityExpansionLimit: ").append(toIndentedString(entityExpansionLimit)).append("\n");
    sb.append("    childrenPerElement: ").append(toIndentedString(childrenPerElement)).append("\n");
    sb.append("    credentials: ").append(toIndentedString(credentials)).append("\n");
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


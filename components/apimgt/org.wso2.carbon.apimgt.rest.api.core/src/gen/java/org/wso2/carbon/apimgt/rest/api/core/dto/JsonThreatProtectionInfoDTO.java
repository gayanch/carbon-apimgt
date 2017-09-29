package org.wso2.carbon.apimgt.rest.api.core.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.wso2.carbon.apimgt.rest.api.core.dto.CredentialsDTO;
import java.util.Objects;

/**
 * JsonThreatProtectionInfoDTO
 */
public class JsonThreatProtectionInfoDTO   {
  @JsonProperty("propertyCount")
  private Integer propertyCount = null;

  @JsonProperty("stringLength")
  private Integer stringLength = null;

  @JsonProperty("arrayElementCount")
  private Integer arrayElementCount = null;

  @JsonProperty("keyLength")
  private Integer keyLength = null;

  @JsonProperty("maxDepth")
  private Integer maxDepth = null;

  @JsonProperty("credentials")
  private CredentialsDTO credentials = null;

  public JsonThreatProtectionInfoDTO propertyCount(Integer propertyCount) {
    this.propertyCount = propertyCount;
    return this;
  }

   /**
   * Get propertyCount
   * @return propertyCount
  **/
  @ApiModelProperty(value = "")
  public Integer getPropertyCount() {
    return propertyCount;
  }

  public void setPropertyCount(Integer propertyCount) {
    this.propertyCount = propertyCount;
  }

  public JsonThreatProtectionInfoDTO stringLength(Integer stringLength) {
    this.stringLength = stringLength;
    return this;
  }

   /**
   * Get stringLength
   * @return stringLength
  **/
  @ApiModelProperty(value = "")
  public Integer getStringLength() {
    return stringLength;
  }

  public void setStringLength(Integer stringLength) {
    this.stringLength = stringLength;
  }

  public JsonThreatProtectionInfoDTO arrayElementCount(Integer arrayElementCount) {
    this.arrayElementCount = arrayElementCount;
    return this;
  }

   /**
   * Get arrayElementCount
   * @return arrayElementCount
  **/
  @ApiModelProperty(value = "")
  public Integer getArrayElementCount() {
    return arrayElementCount;
  }

  public void setArrayElementCount(Integer arrayElementCount) {
    this.arrayElementCount = arrayElementCount;
  }

  public JsonThreatProtectionInfoDTO keyLength(Integer keyLength) {
    this.keyLength = keyLength;
    return this;
  }

   /**
   * Get keyLength
   * @return keyLength
  **/
  @ApiModelProperty(value = "")
  public Integer getKeyLength() {
    return keyLength;
  }

  public void setKeyLength(Integer keyLength) {
    this.keyLength = keyLength;
  }

  public JsonThreatProtectionInfoDTO maxDepth(Integer maxDepth) {
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

  public JsonThreatProtectionInfoDTO credentials(CredentialsDTO credentials) {
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
    JsonThreatProtectionInfoDTO jsonThreatProtectionInfo = (JsonThreatProtectionInfoDTO) o;
    return Objects.equals(this.propertyCount, jsonThreatProtectionInfo.propertyCount) &&
        Objects.equals(this.stringLength, jsonThreatProtectionInfo.stringLength) &&
        Objects.equals(this.arrayElementCount, jsonThreatProtectionInfo.arrayElementCount) &&
        Objects.equals(this.keyLength, jsonThreatProtectionInfo.keyLength) &&
        Objects.equals(this.maxDepth, jsonThreatProtectionInfo.maxDepth) &&
        Objects.equals(this.credentials, jsonThreatProtectionInfo.credentials);
  }

  @Override
  public int hashCode() {
    return Objects.hash(propertyCount, stringLength, arrayElementCount, keyLength, maxDepth, credentials);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonThreatProtectionInfoDTO {\n");
    
    sb.append("    propertyCount: ").append(toIndentedString(propertyCount)).append("\n");
    sb.append("    stringLength: ").append(toIndentedString(stringLength)).append("\n");
    sb.append("    arrayElementCount: ").append(toIndentedString(arrayElementCount)).append("\n");
    sb.append("    keyLength: ").append(toIndentedString(keyLength)).append("\n");
    sb.append("    maxDepth: ").append(toIndentedString(maxDepth)).append("\n");
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


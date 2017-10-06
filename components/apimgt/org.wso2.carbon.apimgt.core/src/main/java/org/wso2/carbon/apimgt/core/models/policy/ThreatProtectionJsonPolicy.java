package org.wso2.carbon.apimgt.core.models.policy;

/**
 * Models policies for JSON Threat Protection
 */
public class ThreatProtectionJsonPolicy {
    private String uuid;
    private boolean enabled;
    private String apiId;
    private int maxFieldCount;
    private int maxStringLength;
    private int maxArrayElementCount;
    private int maxFieldLength;
    private int maxDepth;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public int getMaxFieldCount() {
        return maxFieldCount;
    }

    public void setMaxFieldCount(int maxFieldCount) {
        this.maxFieldCount = maxFieldCount;
    }

    public int getMaxStringLength() {
        return maxStringLength;
    }

    public void setMaxStringLength(int maxStringLength) {
        this.maxStringLength = maxStringLength;
    }

    public int getMaxArrayElementCount() {
        return maxArrayElementCount;
    }

    public void setMaxArrayElementCount(int maxArrayElementCount) {
        this.maxArrayElementCount = maxArrayElementCount;
    }

    public int getMaxFieldLength() {
        return maxFieldLength;
    }

    public void setMaxFieldLength(int maxFieldLength) {
        this.maxFieldLength = maxFieldLength;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }
}

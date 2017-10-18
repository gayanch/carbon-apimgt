package org.wso2.carbon.apimgt.core.models.events;

import org.wso2.carbon.apimgt.core.models.policy.ThreatProtectionJsonPolicy;

/**
 * Holds XML Threat Protection details transferred to gateway
 */
public class ThreatProtectionJsonEvent extends GatewayEvent {
    private ThreatProtectionJsonPolicy policy;

    public ThreatProtectionJsonEvent(String eventType) {
        super(eventType);
    }

    public void setPolicy(ThreatProtectionJsonPolicy policy) {
        this.policy = policy;
    }

    public ThreatProtectionJsonPolicy getPolicy() {
        return policy;
    }
}

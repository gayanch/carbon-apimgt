import org.wso2.carbon.apimgt.ballerina.threatprotection;

function testAnalyzer(string payloadType, string payload) (boolean, string) {
    boolean ok = false;
    string errMessage;
    ok, errMessage = threatprotection:analyze(payloadType, payload);

    return ok, errMessage;
}

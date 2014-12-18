/**
 * Created by wlee on 12/16/14.
 */
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

import com.google.common.base.Optional;

import java.util.UUID;

public class SnsNotification {
    private final String message;
    private final UUID messageId;
    private final String signature;
    private final int signatureVersion;
    private final String signingCertUrl;
    private final Optional<String> subject;
    private final DateTime timestamp;
    private final String type;
    private final String unsubscribeUrl;
    private final String topicArn;

    @JsonCreator
    public SnsNotification(@JsonProperty("Message") String message,
                           @JsonProperty("MessageId") UUID messageId,
                           @JsonProperty("Signature") String signature,
                           @JsonProperty("SignatureVersion") int signatureVersion,
                           @JsonProperty("SigningCertURL") String signingCertUrl,
                           @JsonProperty("Subject") Optional<String> subject,
                           @JsonProperty("Timestamp") DateTime timestamp,
                           @JsonProperty("TopicArn") String topicArn,
                           @JsonProperty("Type") String type,
                           @JsonProperty("UnsubscribeURL") String unsubscribeUrl)
    {
        this.message = message;
        this.messageId = messageId;
        this.signature = signature;
        this.signatureVersion = signatureVersion;
        this.signingCertUrl = signingCertUrl;
        this.subject = subject;
        this.timestamp = timestamp;
        this.topicArn = topicArn;
        this.type = type;
        this.unsubscribeUrl = unsubscribeUrl;
    }

    public String getMessage() {
        return message;
    }

    public UUID getMessageId() {
        return messageId;
    }

    public String getSignature() {
        return signature;
    }

    public int getSignatureVersion() {
        return signatureVersion;
    }

    public String getSigningCertUrl() {
        return signingCertUrl;
    }

    public Optional<String> getSubject() {
        return subject;
    }

    public DateTime getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }

    public String getUnsubscribeUrl() {
        return unsubscribeUrl;
    }

    public String getTopicArn() {
        return topicArn;
    }

    @Override
    public String toString() {
        return String.format("AmazonSnsNotification [message=%s, messageId=%s, signature=%s, signatureVersion=%d, signingCertUrl=%s, subject=%s, timestamp=%s, topicArn=%s, type=%s, unsubscribeUrl=%s",
                message, messageId, signature, signatureVersion, signingCertUrl, subject, timestamp, topicArn, type, unsubscribeUrl);
    }

}

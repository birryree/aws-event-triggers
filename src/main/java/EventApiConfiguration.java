/**
 * Created by wlee on 12/5/14.
 */
import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class EventApiConfiguration extends Configuration {

    @NotEmpty
    @JsonProperty
    private String masterPassword;

    @NotEmpty
    @JsonProperty
    private String readOnlyPassword;

    @NotEmpty
    @JsonProperty
    private String databaseIdentifier;

    @NotEmpty
    @JsonProperty
    private String securityGroup;

    @NotEmpty
    @JsonProperty
    private String dbSubnet;

    public String getDatabaseIdentifier() {
        return databaseIdentifier;
    }

    public String getSecurityGroup() {
        return securityGroup;
    }

    public String getDbSubnet() {
        return dbSubnet;
    }

    public String getMasterPassword() {
        return masterPassword;
    }

    public String getReadOnlyPassword()
    {
        return readOnlyPassword;
    }

}

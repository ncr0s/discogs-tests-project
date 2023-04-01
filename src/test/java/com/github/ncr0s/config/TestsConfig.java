package com.github.ncr0s.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.ConfigFactory;

public class TestsConfig {

    private static Class<? extends TestProperties> getPropertySource() {
        String env = System.getProperty("env");
        if ((env != null && !env.equals("null")) && !env.equals("test")) {
            throw new RuntimeException("Invalid value for system property 'env'! Expected one of:[null, 'test']");
        } else {
            return PropertiesInterfaceTest.class;
        }
    }

    public static final TestProperties PROPERTIES = ConfigFactory.create(getPropertySource());

    @LoadPolicy(LoadType.MERGE)
    @Sources({"system:properties", "classpath:test.properties"})
    interface PropertiesInterfaceTest extends TestProperties {
    }

    public interface TestProperties extends Config {

        // Web tests properties
        @Key("browserName")
        String getBrowserName();

        @Key("browserVersion")
        String getBrowserVersion();

        @Key("baseUrl")
        @DefaultValue("https://www.discogs.com")
        String getBaseUrl();

        @Key("browserSize")
        String getBrowserSize();

        @Key("isRemote")
        Boolean isRemote();

        @Key("remoteUrl")
        String getRemoteUrl();

        @Key("pageLoadTimeout")
        Long getPageLoadTimeout();

        @Key("timeout")
        Long getTimeout();
    }
}

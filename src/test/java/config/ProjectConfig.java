package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "classpath:project.properties"
})
public interface ProjectConfig extends Config {

    @Key("baseUrl")
    String baseUrl();

    @Key("browser")
    String browser();

    @Key("browserVersion")
    String browserVersion();

    @Key("browserSize")
    String browserSize();

    @Key("pageLoadStrategy")
    String pageLoadStrategy();

    @Key("timeout")
    long timeout();

    @Key("remoteUrl")
    String remoteUrl();
}

package some.kind.of.framework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigHandler {

    Properties properties;

    public ConfigHandler() {
        try (InputStream input = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("config.properties")) {
            Properties props = new Properties();
            props.load(input);
            properties = props;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public String getValue(Configuration configuration) {
        return properties.getProperty(configuration.getVal(), "");
    }
}

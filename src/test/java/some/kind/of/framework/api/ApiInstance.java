package some.kind.of.framework.api;

import some.kind.of.framework.utils.ConfigHandler;

public class ApiInstance {

    ConfigHandler configHandler;

    public ApiInstance(ConfigHandler configHandler) {
        this.configHandler = configHandler;
    }

    public boolean login() {
        return true;
    }
}

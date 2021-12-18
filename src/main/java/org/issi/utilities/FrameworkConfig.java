package org.issi.utilities;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/test/resources/config/FrameworkConfig.properties") //property file path
public interface FrameworkConfig extends Config {
    String browser();
    String url();
    String runmode();

}

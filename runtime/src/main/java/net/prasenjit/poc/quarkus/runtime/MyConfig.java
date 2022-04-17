package net.prasenjit.poc.quarkus.runtime;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "my.config")
public interface MyConfig {
    String name();
}

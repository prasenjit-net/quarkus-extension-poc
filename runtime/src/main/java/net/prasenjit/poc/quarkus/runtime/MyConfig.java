package net.prasenjit.poc.quarkus.runtime;

import io.smallrye.config.ConfigMapping;

/**
 * An example configuration mapper interface
 *
 * @author Prasenjit Purohit
 */
@ConfigMapping(prefix = "my.config")
public interface MyConfig {

    /**
     * Returns the default name to greet to
     *
     * @return greet message
     */
    String name();
}

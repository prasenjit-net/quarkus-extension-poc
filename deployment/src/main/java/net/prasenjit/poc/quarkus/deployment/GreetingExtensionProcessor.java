package net.prasenjit.poc.quarkus.deployment;

import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.undertow.deployment.ServletBuildItem;
import net.prasenjit.poc.quarkus.runtime.ExtensionBean;
import net.prasenjit.poc.quarkus.runtime.GreetingExtensionServlet;

public class GreetingExtensionProcessor {

    private static final String FEATURE = "gradle-poc";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    ServletBuildItem createServlet() {
        return ServletBuildItem.builder("gradle-poc", GreetingExtensionServlet.class.getName())
                .addMapping("/poc")
                .build();
    }

    @BuildStep
    AdditionalBeanBuildItem createExtensionBean() {
        return AdditionalBeanBuildItem.builder().addBeanClass(ExtensionBean.class).build();
    }

}

package net.prasenjit.poc.quarkus.deployment;

import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.arc.processor.BuiltinScope;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.resteasy.common.spi.ResteasyJaxrsProviderBuildItem;
import io.quarkus.undertow.deployment.ServletBuildItem;
import net.prasenjit.poc.quarkus.runtime.ExtensionBean;
import net.prasenjit.poc.quarkus.runtime.GreetingExtensionServlet;
import net.prasenjit.poc.quarkus.runtime.ReqFilter;

/**
 * A deployment processor class
 *
 * @author Prasenjit Purohit
 */
public class GreetingExtensionProcessor {

    private static final String FEATURE = "gradle-poc";

    /**
     * Feature build step
     *
     * @return build step
     */
    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    /**
     * A servlet build step
     *
     * @return build step
     */
    @BuildStep
    ServletBuildItem createServlet() {
        return ServletBuildItem.builder("gradle-poc", GreetingExtensionServlet.class.getName())
                .addMapping("/poc")
                .build();
    }

    /**
     * register additional bean
     *
     * @return bean build step
     */
    @BuildStep
    AdditionalBeanBuildItem createExtensionBean() {
        return AdditionalBeanBuildItem.builder()
                .addBeanClasses(ExtensionBean.class)
                .setDefaultScope(BuiltinScope.APPLICATION.getName())
                .build();
    }

    /**
     * resteasy provider build step
     *
     * @param providers build step producer injected
     */
    @BuildStep
    public void restEasyProviders(BuildProducer<ResteasyJaxrsProviderBuildItem> providers) {
        providers.produce(new ResteasyJaxrsProviderBuildItem(ReqFilter.class.getName()));
    }

}

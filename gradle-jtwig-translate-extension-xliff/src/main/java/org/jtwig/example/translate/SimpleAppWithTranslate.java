package org.jtwig.example.translate;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.jtwig.environment.EnvironmentConfiguration;
import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.translate.TranslateExtension;

import static org.jtwig.translate.configuration.TranslateConfigurationBuilder.translateConfiguration;
import static org.jtwig.translate.message.source.cache.CachedMessageSourceFactory.cachedWith;
import static org.jtwig.translate.message.source.cache.PersistentMessageSourceCache.persistentCache;
import static org.jtwig.xliff.i18n.XliffMessageSourceFactoryBuilder.xliffMessageSource;

public class SimpleAppWithTranslate {
    public static void main(String[] args) {
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "TRACE");

        EnvironmentConfiguration configuration = EnvironmentConfigurationBuilder
                .configuration()
                    .extensions()
                        .add(new TranslateExtension(translateConfiguration()
                                .withMessageSourceFactory(cachedWith(
                                        persistentCache(),
                                        xliffMessageSource()
                                                .withLookupClasspath("translations")
                                                .build()
                                ))
                                .build()))
                    .and()
                .build();

        String result = JtwigTemplate.classpathTemplate("templates/example.twig", configuration)
                .render(JtwigModel.newModel());

        System.out.println(result);
    }
}

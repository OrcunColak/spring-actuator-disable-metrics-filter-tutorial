package com.colak.springtutorial.config;

import com.colak.springtutorial.filter.AtoZFilter;
import com.colak.springtutorial.filter.Range;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.MeterFilter;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

// The filter setup here will take precedence over the other filters setup by PropertiesMeterFilter spring bean
@Configuration
public class MeterRegistryCustomizerConfiguration {

    @Bean
    public MeterRegistryCustomizer<? extends MeterRegistry> meterRegistryCustomizer() {
        return registry -> registry.config()
                .meterFilter(acceptAB())
                .meterFilter(denyKZ());
    }

    private MeterFilter acceptAB() {
        return AtoZFilter.builder()
                .accept(Set.of(new Range('a', 'b')))
                .build();
    }

    private MeterFilter denyKZ() {
        return AtoZFilter.builder()
                .deny(Set.of(new Range('k', 'z')))
                .build();
    }
}
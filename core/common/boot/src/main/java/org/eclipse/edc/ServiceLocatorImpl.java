package org.eclipse.edc;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import static java.util.stream.Collectors.joining;

public class ServiceLocatorImpl implements ServiceLocator {

    @Override
    public <T> List<T> loadImplementors(Class<T> type, boolean required) {
        List<T> impls = new ArrayList<>();
        // load(): static factory method to get an instance of ServiceLoader
        // iterate(): method to search and retrieve all available impls
        ServiceLoader.load(type).iterator().forEachRemaining(impls::add);
        if (impls.isEmpty() && required)
            throw new EdcException("No implementation classes found of type: " + type.getName());
        return impls;
    }

    @Override
    public <T> T loadSingletonImplementor(Class<T> type, boolean required) {
        List<T> impls = new ArrayList<>();
        ServiceLoader.load(type).iterator().forEachRemaining(impls::add);
        if (impls.isEmpty() && required)
            throw new EdcException("No implementation found of type: " + type.getName());
        else if (impls.size() > 1) {
            String types = impls.stream().map(e -> e.getClass().getName()).collect(joining(","));
            throw new EdcException("Multiple implementations found of type: " + type.getName() + " " + types);
        }
        return !impls.isEmpty() ? impls.get(0) : null;
    }
}

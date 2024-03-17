package org.eclipse.edc;

import java.util.List;

/**
 * Discover and load implementations of a specific "type" SPI.
 */
public interface ServiceLocator { // ServiceLoader

    <T> List<T> loadImplementors(Class<T> type, boolean required);

    <T> T loadSingletonImplementor(Class<T> type, boolean required);
}

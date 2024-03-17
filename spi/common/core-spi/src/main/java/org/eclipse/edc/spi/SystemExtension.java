package org.eclipse.edc.spi;

/**
 * {@code SystemExtension} is the root interface of all EDC runtime extensions.
 */
public interface SystemExtension {

    default String name() {
        return getClass().getName();
    }
}

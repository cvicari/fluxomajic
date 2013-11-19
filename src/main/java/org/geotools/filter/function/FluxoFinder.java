/*
 *
 *   Copyright (C) 2013 Geobeyond Srl
 *
 *   This library is free software; you can redistribute it and/or modify it under
 *   the terms of the GNU Lesser General Public License as published by the Free
 *   Software Foundation; either version 2.1 of the License, or (at your option)
 *   any later version.
 *
 *   This library is distributed in the hope that it will be useful, but WITHOUT
 *   ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 *   FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 *   details.
 *
 *   You should have received a copy of the GNU Lesser General Public License along
 *   with this library; if not, write to the Free Software Foundation, Inc., 59
 *   Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *   
 *
 */

package org.geotools.filter.function;

import java.util.Iterator;
import java.util.Set;

import org.geotools.factory.FactoryCreator;
import org.geotools.factory.FactoryFinder;
import org.geotools.factory.FactoryRegistry;
import org.geotools.factory.Hints;
import org.geotools.filter.FunctionFactory;
import org.geotools.resources.LazySet;
import org.opengis.filter.FilterFactory;

public class FluxoFinder extends FactoryFinder {

    private static FactoryCreator registry;
    
    private static FactoryRegistry getServiceRegistry() {
        assert Thread.holdsLock(FluxoFinder.class);
        if (registry == null) {
            Class<?> categories[] = new Class<?>[] { FunctionFactory.class };
            registry = new FactoryCreator( categories);
        }
        return registry;
    }
    
    /**
     * Returns a set of all available implementations for the {@link FilterFactory} interface.
     *
     * @param  hints An optional map of hints, or {@code null} if none.
     * @return Set of available filter factory implementations.
     */
    public static synchronized Set<FunctionFactory> getFilterFactories(Hints hints) {
        hints = mergeSystemHints(hints);
        Iterator<FunctionFactory> serviceProviders = getServiceRegistry().getServiceProviders(
                FunctionFactory.class, null, hints);
        return new LazySet<FunctionFactory>(serviceProviders);
    }
        
    /** Allow the classpath to be rescanned */
    public static synchronized void scanForPlugins() {
        if (registry != null) {
            registry.scanForPlugins();
        }
    }
}

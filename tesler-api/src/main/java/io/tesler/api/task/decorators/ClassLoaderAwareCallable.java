/*-
 * #%L
 * IO Tesler - API
 * %%
 * Copyright (C) 2018 - 2019 Tesler Contributors
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package io.tesler.api.task.decorators;

import java.util.Objects;
import java.util.concurrent.Callable;


public class ClassLoaderAwareCallable<E> implements Callable<E> {

	private final Callable<E> delegate;

	private final ClassLoader classLoader;

	private ClassLoaderAwareCallable(Callable<E> delegate, ClassLoader classLoader) {
		this.delegate = Objects.requireNonNull(delegate);
		this.classLoader = classLoader;
	}

	@SuppressWarnings("unchecked")
	public static <V> Callable<V> wrap(Callable<V> task) {
		return new ClassLoaderAwareCallable<>(task, Thread.currentThread().getContextClassLoader());
	}


	@Override
	public E call() throws Exception {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader(classLoader);
			return delegate.call();
		} finally {
			Thread.currentThread().setContextClassLoader(cl);
		}
	}

}

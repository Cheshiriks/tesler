/*-
 * #%L
 * IO Tesler - Core
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

package io.tesler.core.util.export.model;

import io.tesler.core.util.export.model.query.Insert;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class Parameters {

	@Getter
	private final String columnName;

	private final Set<BigDecimal> ids = new TreeSet<>();

	public static Parameters id(final String columnName, final Long id) {
		return new Parameters(columnName).add(BigDecimal.valueOf(id));
	}

	public static Parameters id(final Long id) {
		return id("ID", id);
	}

	public static Parameters ids(final List<Insert> inserts) {
		return ids("ID", inserts);
	}

	public static Parameters ids(final String columnName, final List<Insert> inserts) {
		final Parameters parameters = new Parameters(columnName);
		for (final Insert insert : inserts) {
			parameters.add(insert.getLineId());
		}
		return parameters;
	}

	public Parameters add(final BigDecimal id) {
		ids.add(id);
		return this;
	}

	public boolean isNotEmpty() {
		return !ids.isEmpty();
	}

	public List<BigDecimal> getIds() {
		return new ArrayList<>(ids);
	}

}

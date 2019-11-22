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

package io.tesler.core.security.impl.obligations;

import io.tesler.api.security.attributes.IAttributeType;
import io.tesler.api.security.obligations.IObligation;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class Obligation implements IObligation {

	private final IAttributeType attributeType;

	private final List<String> values = new ArrayList<>();

	@Override
	public IObligation addValue(String value) {
		values.add(value);
		return this;
	}

}

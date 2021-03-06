/*-
 * #%L
 * IO Tesler - Model Core
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

package io.tesler.model.core.entity.security;

import io.tesler.model.core.entity.BaseEntity;
import io.tesler.model.core.entity.security.types.Permission;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Access right record
 */
@Setter
@Getter
@Entity
@Table(name = "access_record")
public class AccessRecord extends BaseEntity {

	/**
	 * Parent access list
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "access_list_id")
	private AccessList accessList;

	/**
	 * Accessor
	 */
	@Embedded
	private Accessor accessor;

	/**
	 * Access rights
	 */
	@Column(name = "permission")
	private Permission permission;

	/**
	 * Mandatory sign
	 */
	@Column(name = "mandatory")
	private boolean mandatory;

}

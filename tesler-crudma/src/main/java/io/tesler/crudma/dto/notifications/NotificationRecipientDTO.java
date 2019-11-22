/*-
 * #%L
 * IO Tesler - Source
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

package io.tesler.crudma.dto.notifications;

import static io.tesler.api.data.dictionary.DictionaryType.NOTIFICATION_RECIPIENT_TYPE;

import io.tesler.api.data.dictionary.DictionaryType;
import io.tesler.api.data.dto.DataResponseDTO;
import io.tesler.core.dto.Lov;
import io.tesler.model.core.entity.notifications.NotificationRecipient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class NotificationRecipientDTO extends DataResponseDTO {

	@Lov(NOTIFICATION_RECIPIENT_TYPE)
	private String recipientType;

	private Boolean enabled;

	private boolean sameDeptOnly;

	public NotificationRecipientDTO(NotificationRecipient recipient) {
		this.id = recipient.getId().toString();
		this.recipientType = DictionaryType.NOTIFICATION_RECIPIENT_TYPE.lookupValue(recipient.getRecipientType());
		this.sameDeptOnly = recipient.isSameDeptOnly();
	}

}

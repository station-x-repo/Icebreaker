/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.osp.icebreaker.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the OSPCluster service. Represents a row in the &quot;ICEBREAKER_OSPCluster&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.osp.icebreaker.model.impl.OSPClusterModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.osp.icebreaker.model.impl.OSPClusterImpl</code>.
 * </p>
 *
 * @author Jerry H. Seo
 * @see OSPCluster
 * @generated
 */
@ProviderType
public interface OSPClusterModel
	extends BaseModel<OSPCluster>, GroupedModel, LocalizedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a osp cluster model instance should use the {@link OSPCluster} interface instead.
	 */

	/**
	 * Returns the primary key of this osp cluster.
	 *
	 * @return the primary key of this osp cluster
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this osp cluster.
	 *
	 * @param primaryKey the primary key of this osp cluster
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this osp cluster.
	 *
	 * @return the uuid of this osp cluster
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this osp cluster.
	 *
	 * @param uuid the uuid of this osp cluster
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the cluster ID of this osp cluster.
	 *
	 * @return the cluster ID of this osp cluster
	 */
	public long getClusterId();

	/**
	 * Sets the cluster ID of this osp cluster.
	 *
	 * @param clusterId the cluster ID of this osp cluster
	 */
	public void setClusterId(long clusterId);

	/**
	 * Returns the company ID of this osp cluster.
	 *
	 * @return the company ID of this osp cluster
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this osp cluster.
	 *
	 * @param companyId the company ID of this osp cluster
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this osp cluster.
	 *
	 * @return the group ID of this osp cluster
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this osp cluster.
	 *
	 * @param groupId the group ID of this osp cluster
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this osp cluster.
	 *
	 * @return the user ID of this osp cluster
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this osp cluster.
	 *
	 * @param userId the user ID of this osp cluster
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this osp cluster.
	 *
	 * @return the user uuid of this osp cluster
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this osp cluster.
	 *
	 * @param userUuid the user uuid of this osp cluster
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this osp cluster.
	 *
	 * @return the user name of this osp cluster
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this osp cluster.
	 *
	 * @param userName the user name of this osp cluster
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this osp cluster.
	 *
	 * @return the create date of this osp cluster
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this osp cluster.
	 *
	 * @param createDate the create date of this osp cluster
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this osp cluster.
	 *
	 * @return the modified date of this osp cluster
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this osp cluster.
	 *
	 * @param modifiedDate the modified date of this osp cluster
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this osp cluster.
	 *
	 * @return the status of this osp cluster
	 */
	public int getStatus();

	/**
	 * Sets the status of this osp cluster.
	 *
	 * @param status the status of this osp cluster
	 */
	public void setStatus(int status);

	/**
	 * Returns the cluster name of this osp cluster.
	 *
	 * @return the cluster name of this osp cluster
	 */
	@AutoEscape
	public String getClusterName();

	/**
	 * Sets the cluster name of this osp cluster.
	 *
	 * @param clusterName the cluster name of this osp cluster
	 */
	public void setClusterName(String clusterName);

	/**
	 * Returns the os family of this osp cluster.
	 *
	 * @return the os family of this osp cluster
	 */
	@AutoEscape
	public String getOsFamily();

	/**
	 * Sets the os family of this osp cluster.
	 *
	 * @param osFamily the os family of this osp cluster
	 */
	public void setOsFamily(String osFamily);

	/**
	 * Returns the os name of this osp cluster.
	 *
	 * @return the os name of this osp cluster
	 */
	@AutoEscape
	public String getOsName();

	/**
	 * Sets the os name of this osp cluster.
	 *
	 * @param osName the os name of this osp cluster
	 */
	public void setOsName(String osName);

	/**
	 * Returns the os version of this osp cluster.
	 *
	 * @return the os version of this osp cluster
	 */
	@AutoEscape
	public String getOsVersion();

	/**
	 * Sets the os version of this osp cluster.
	 *
	 * @param osVersion the os version of this osp cluster
	 */
	public void setOsVersion(String osVersion);

	/**
	 * Returns the app root dir of this osp cluster.
	 *
	 * @return the app root dir of this osp cluster
	 */
	@AutoEscape
	public String getAppRootDir();

	/**
	 * Sets the app root dir of this osp cluster.
	 *
	 * @param appRootDir the app root dir of this osp cluster
	 */
	public void setAppRootDir(String appRootDir);

	/**
	 * Returns the description of this osp cluster.
	 *
	 * @return the description of this osp cluster
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this osp cluster in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this osp cluster
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this osp cluster in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this osp cluster. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this osp cluster in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this osp cluster
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this osp cluster in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this osp cluster
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this osp cluster.
	 *
	 * @return the locales and localized descriptions of this osp cluster
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this osp cluster.
	 *
	 * @param description the description of this osp cluster
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this osp cluster in the language.
	 *
	 * @param description the localized description of this osp cluster
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this osp cluster in the language, and sets the default locale.
	 *
	 * @param description the localized description of this osp cluster
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(
		String description, Locale locale, Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this osp cluster from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this osp cluster
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this osp cluster from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this osp cluster
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale);

	/**
	 * Returns the server ip of this osp cluster.
	 *
	 * @return the server ip of this osp cluster
	 */
	@AutoEscape
	public String getServerIp();

	/**
	 * Sets the server ip of this osp cluster.
	 *
	 * @param serverIp the server ip of this osp cluster
	 */
	public void setServerIp(String serverIp);

	/**
	 * Returns the ssh port of this osp cluster.
	 *
	 * @return the ssh port of this osp cluster
	 */
	@AutoEscape
	public String getSshPort();

	/**
	 * Sets the ssh port of this osp cluster.
	 *
	 * @param sshPort the ssh port of this osp cluster
	 */
	public void setSshPort(String sshPort);

	/**
	 * Returns the identification command of this osp cluster.
	 *
	 * @return the identification command of this osp cluster
	 */
	@AutoEscape
	public String getIdentificationCommand();

	/**
	 * Sets the identification command of this osp cluster.
	 *
	 * @param identificationCommand the identification command of this osp cluster
	 */
	public void setIdentificationCommand(String identificationCommand);

	/**
	 * Returns the access method of this osp cluster.
	 *
	 * @return the access method of this osp cluster
	 */
	@AutoEscape
	public String getAccessMethod();

	/**
	 * Sets the access method of this osp cluster.
	 *
	 * @param accessMethod the access method of this osp cluster
	 */
	public void setAccessMethod(String accessMethod);

	/**
	 * Returns the authorized ID of this osp cluster.
	 *
	 * @return the authorized ID of this osp cluster
	 */
	@AutoEscape
	public String getAuthorizedId();

	/**
	 * Sets the authorized ID of this osp cluster.
	 *
	 * @param authorizedId the authorized ID of this osp cluster
	 */
	public void setAuthorizedId(String authorizedId);

	/**
	 * Returns the authorized password of this osp cluster.
	 *
	 * @return the authorized password of this osp cluster
	 */
	@AutoEscape
	public String getAuthorizedPassword();

	/**
	 * Sets the authorized password of this osp cluster.
	 *
	 * @param authorizedPassword the authorized password of this osp cluster
	 */
	public void setAuthorizedPassword(String authorizedPassword);

	/**
	 * Returns the scheduler name of this osp cluster.
	 *
	 * @return the scheduler name of this osp cluster
	 */
	@AutoEscape
	public String getSchedulerName();

	/**
	 * Sets the scheduler name of this osp cluster.
	 *
	 * @param schedulerName the scheduler name of this osp cluster
	 */
	public void setSchedulerName(String schedulerName);

	/**
	 * Returns the scheduler version of this osp cluster.
	 *
	 * @return the scheduler version of this osp cluster
	 */
	@AutoEscape
	public String getSchedulerVersion();

	/**
	 * Sets the scheduler version of this osp cluster.
	 *
	 * @param schedulerVersion the scheduler version of this osp cluster
	 */
	public void setSchedulerVersion(String schedulerVersion);

	/**
	 * Returns the scheduler class of this osp cluster.
	 *
	 * @return the scheduler class of this osp cluster
	 */
	@AutoEscape
	public String getSchedulerClass();

	/**
	 * Sets the scheduler class of this osp cluster.
	 *
	 * @param schedulerClass the scheduler class of this osp cluster
	 */
	public void setSchedulerClass(String schedulerClass);

	/**
	 * Returns the scheduler status of this osp cluster.
	 *
	 * @return the scheduler status of this osp cluster
	 */
	public int getSchedulerStatus();

	/**
	 * Sets the scheduler status of this osp cluster.
	 *
	 * @param schedulerStatus the scheduler status of this osp cluster
	 */
	public void setSchedulerStatus(int schedulerStatus);

	/**
	 * Returns the security level of this osp cluster.
	 *
	 * @return the security level of this osp cluster
	 */
	@AutoEscape
	public String getSecurityLevel();

	/**
	 * Sets the security level of this osp cluster.
	 *
	 * @param securityLevel the security level of this osp cluster
	 */
	public void setSecurityLevel(String securityLevel);

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

}
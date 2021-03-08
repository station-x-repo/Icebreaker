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

package com.osp.icebreaker.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import com.osp.icebreaker.constants.OSPClusterSecurityLevels;
import com.osp.icebreaker.model.OSPCluster;

import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for OSPCluster. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Jerry H. Seo
 * @see OSPClusterServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface OSPClusterService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OSPClusterServiceUtil} to access the osp cluster remote service. Add custom service methods to <code>com.osp.icebreaker.service.impl.OSPClusterServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public OSPCluster addCluster(
			String clusterName, String osFamily, String osName,
			String osVersion, String appRootDir, String dataRootDir,
			String contentRootDir, Map<Locale, String> descriptionMap,
			String serverIp, String sshPort, String identificationCommand,
			String accessMethod, String authorizedId, String authorizedPassword,
			String schedulerName, String schedulerVersion,
			String schedulerClass, OSPClusterSecurityLevels securityLevel,
			ServiceContext sc)
		throws PortalException;

	public OSPCluster deleteCluster(long clusterId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OSPCluster getCluster(long clusterId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OSPCluster getCluster(String clusterName);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

}
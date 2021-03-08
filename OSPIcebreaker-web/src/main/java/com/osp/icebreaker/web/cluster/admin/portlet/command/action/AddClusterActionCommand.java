package com.osp.icebreaker.web.cluster.admin.portlet.command.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.ServiceContextUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.osp.icebreaker.web.constants.OSPIcebreakerWebMVCCommandNames;
import com.osp.icebreaker.web.constants.OSPIcebreakerWebParameterNames;

import java.util.Locale;
import java.util.Map;

import com.osp.icebreaker.constants.OSPClusterSecurityLevels;
import com.osp.icebreaker.constants.OSPIcebreakerWebPortletKeys;
import com.osp.icebreaker.model.OSPCluster;
import com.osp.icebreaker.service.OSPClusterLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
		"javax.portlet.name=" + OSPIcebreakerWebPortletKeys.CLUSTERADMIN,
		"mvc.command.name=" + OSPIcebreakerWebMVCCommandNames.ADD_CLUSTER
		},
		service = MVCActionCommand.class
)
public class AddClusterActionCommand implements MVCActionCommand {

	private OSPClusterLocalService _ospClusterLocalService;
	private static final Log _log = LogFactoryUtil.getLog(  AddClusterActionCommand.class );
	
	@Reference(unbind = "-")
	protected void setOSPClusterLocalService(OSPClusterLocalService ospClusterLocalService) {
		_ospClusterLocalService = ospClusterLocalService;
	}
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		if( _log.isInfoEnabled() ) {
			_log.info( "Adding new cluster...");
		}
		System.out.println("In Add cluster action....");
		
		String clusterName = ParamUtil.getString(actionRequest, OSPIcebreakerWebParameterNames.CLUSTER_NAME);
		Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(actionRequest, OSPIcebreakerWebParameterNames.DESCRIPTION);
		String securityLevelSTR = ParamUtil.getString(actionRequest, OSPIcebreakerWebParameterNames.SECURITY_LEVEL);
		OSPClusterSecurityLevels securityLevel = OSPClusterSecurityLevels.valueOf(securityLevelSTR); 
		String osFamily = ParamUtil.getString(actionRequest, OSPIcebreakerWebParameterNames.OS_FAMILY);
		String osName =  ParamUtil.getString(actionRequest, OSPIcebreakerWebParameterNames.OS_NAME);
		String osVersion =  ParamUtil.getString(actionRequest, OSPIcebreakerWebParameterNames.OS_VERSION);
		String appRootDir =  ParamUtil.getString(actionRequest, OSPIcebreakerWebParameterNames.APP_ROOT_DIR);
		String serverIp =  ParamUtil.getString(actionRequest, OSPIcebreakerWebParameterNames.SERVER_IP);
		String sshPort =  ParamUtil.getString(actionRequest, OSPIcebreakerWebParameterNames.SSH_PORT);
		String authorizedId =  ParamUtil.getString(actionRequest, OSPIcebreakerWebParameterNames.AUTHORIZED_ID);
		String authorizedPassword =  ParamUtil.getString(actionRequest, OSPIcebreakerWebParameterNames.AUTHORIZED_PASSWORD);
		String identificationCommand = ParamUtil.getString(actionRequest, OSPIcebreakerWebParameterNames.IDENTIFICATION_COMMAND);
		String accessMethod =  ParamUtil.getString(actionRequest, OSPIcebreakerWebParameterNames.ACCESS_METHOD);
		String schedulerName =  ParamUtil.getString(actionRequest, OSPIcebreakerWebParameterNames.SCHEDULER_NAME);
		String schedulerVersion = ParamUtil.getString(actionRequest, OSPIcebreakerWebParameterNames.SCHEDULER_VERSION);
		String schedulerClass = ParamUtil.getString(actionRequest, OSPIcebreakerWebParameterNames.SCHEDULER_CLASS);

		ServiceContext sc = null;
		try {
			sc = ServiceContextFactory.getInstance(OSPCluster.class.getName(), actionRequest);
		} catch (PortalException e) {
			e.printStackTrace();
			sendSessionError(actionRequest, e);
		}
		
		try {
			_ospClusterLocalService.addCluster(
					clusterName, 
					osFamily, 
					osName, 
					osVersion, 
					appRootDir, 
					descriptionMap, 
					serverIp, 
					sshPort, 
					identificationCommand, 
					accessMethod, 
					authorizedId, 
					authorizedPassword, 
					schedulerName, 
					schedulerVersion, 
					schedulerClass, 
					securityLevel, 
					sc);
			
			SessionMessages.add( actionRequest, "clusterAdded");
		} catch (PortalException e) {
			e.printStackTrace();
			sendSessionError(actionRequest, e);
		}
		
		return true;
	}
	
	private void sendSessionError( PortletRequest request, PortalException e) {
		SessionErrors.add(request, e.getClass().getName());
	}

}

package com.osp.icebreaker.web.cluster.admin.portlet.command.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.osp.icebreaker.web.constants.OSPIcebreakerWebDefaultValues;
import com.osp.icebreaker.web.constants.OSPIcebreakerWebJSPPaths;
import com.osp.icebreaker.web.constants.OSPIcebreakerWebMVCCommandNames;
import com.osp.icebreaker.constants.OSPIcebreakerWebPortletKeys;
import com.osp.icebreaker.model.OSPCluster;
import com.osp.icebreaker.service.OSPClusterLocalService;
import com.osp.icebreaker.web.constants.OSPIcebreakerWebParameterNames;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
		"javax.portlet.name=" + OSPIcebreakerWebPortletKeys.CLUSTERADMIN,
		"mvc.command.name=" + OSPIcebreakerWebMVCCommandNames.EDIT_CLUSTER
		},
		service = MVCRenderCommand.class
)
public class EditClusterRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		System.out.println("in EditClustersRenderCommand ");
		
		String command = ParamUtil.getString(
																		renderRequest,
																		OSPIcebreakerWebParameterNames.CMD, 
																		OSPIcebreakerWebDefaultValues.DEFAULT_EDIT_COMMAND);

		long clusterId = 0;
		OSPCluster cluster = null;
		if( command.equals("update") ) {
			clusterId = ParamUtil.getLong(renderRequest, OSPIcebreakerWebParameterNames.CLUSTER_ID, 0);
			if( clusterId == 0 ) {
				throw new PortletException("Cluster ID should be provided for edit: " + clusterId);
			}
			
			try {
				cluster = _ospClusterLocalService.getOSPCluster(clusterId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		renderRequest.setAttribute(OSPIcebreakerWebParameterNames.CLUSTER, cluster);
		
		return OSPIcebreakerWebJSPPaths.EDIT_CLUSTER_JSP;
	}
	
	private OSPClusterLocalService _ospClusterLocalService;
	@Reference(unbind = "-")
	protected void setOSPClusterLocalService(OSPClusterLocalService ospClusterLocalService) {
		_ospClusterLocalService = ospClusterLocalService;
	}

}

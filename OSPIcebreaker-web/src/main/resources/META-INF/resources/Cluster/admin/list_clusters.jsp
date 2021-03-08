<%@page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPDropdownItemList"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.osp.icebreaker.web.constants.OSPIcebreakerWebMVCCommandNames"%>
<%@page import="com.osp.icebreaker.web.cluster.admin.portlet.toolbar.ClusterAdminToolbarDisplayContext"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.osp.icebreaker.model.OSPCluster"%>
<%@page import="java.util.List"%>
<%@page import="com.osp.icebreaker.web.constants.OSPIcebreakerWebParameterNames"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="../../init.jsp"%>

<liferay-ui:success key="clusterAdded" message="cluster-added" />

<%
PortletURL portletURL = renderResponse.createRenderURL();
int clustersCount = GetterUtil.getInteger( renderRequest.getAttribute(OSPIcebreakerWebParameterNames.CLUSTERS_COUNT) );
List<OSPCluster> clustersList = (List<OSPCluster>)GetterUtil.getObject( renderRequest.getAttribute(OSPIcebreakerWebParameterNames.CLUSTERS_LIST) );
String displayStyle = ParamUtil.getString( request, OSPIcebreakerWebParameterNames.DISPLAY_STYLE, "" );
SearchContainer<OSPCluster> clusterSearchContainer = (SearchContainer<OSPCluster>)request.getAttribute(OSPIcebreakerWebParameterNames.CLUSTER_SEARCH_CONTAINER);
ClusterAdminToolbarDisplayContext clusterAdminToolbarDisplayContext =
(ClusterAdminToolbarDisplayContext)request.getAttribute(OSPIcebreakerWebParameterNames.CLUSTER_DISPLAY_CONTEXT);

String mvcRenderCommand = ParamUtil.getString(request, "mvcRenderCommand");
%>

<portlet:renderURL var="addClusterRenderURL">
	<portlet:param name="mvcRenderCommandName" value="<%=OSPIcebreakerWebMVCCommandNames.EDIT_CLUSTER%>"></portlet:param>
	<portlet:param name="CMD" value="add"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="updateClusterRenderURL">
	<portlet:param name="mvcRenderCommandName" value="<%=OSPIcebreakerWebMVCCommandNames.EDIT_CLUSTER%>"></portlet:param>
	<portlet:param name="CMD" value="update"></portlet:param>
</portlet:renderURL>

<h1> Clusters </h1>

<clay:management-toolbar 
    displayContext="<%= clusterAdminToolbarDisplayContext %>"
    searchContainerId="clusterSearchContainer"
    disabled="<%= clustersCount == 0 %>"
    actionDropdownItems="<%=
				    new JSPDropdownItemList(pageContext) {
				        {
				          add(
				            dropdownItem -> {
				              dropdownItem.setHref("#edit");
				              dropdownItem.setLabel("Edit");
				            });
				  
				          add(
				            dropdownItem -> {
				              dropdownItem.setHref("#download");
				              dropdownItem.setIcon("download");
				              dropdownItem.setLabel("Download");
				              dropdownItem.setQuickAction(true);
				            });
				  
				          add(
				            dropdownItem -> {
				              dropdownItem.setHref("#delete");
				              dropdownItem.setLabel("Delete");
				              dropdownItem.setIcon("trash");
				              dropdownItem.setQuickAction(true);
				            });
				        }
				    }
					%>"
/>

<liferay-ui:search-container
		searchContainer="<%= clusterSearchContainer %>"
		id="clusterSearchContainer"
>

	<liferay-ui:search-container-row className="com.osp.icebreaker.model.OSPCluster" modelVar="cluster">
			<liferay-ui:search-container-column-text name="<%= new String( Character.toChars(9745)) %>">
				<input type="checkbox"  name="clusterId" value="<%= String.valueOf(cluster.getClusterId()) %>"/>    
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="cluster-name" value="<%= cluster.getClusterName() %>" />
			<liferay-ui:search-container-column-text name="security-level" value="<%= cluster.getSecurityLevel() %>" />
			<liferay-ui:search-container-column-text name="os-name" value="<%= cluster.getOsName() %>" />
			<liferay-ui:search-container-column-text name="os-version" value="<%= cluster.getOsVersion() %>" />
			<liferay-ui:search-container-column-text name="scheduler-name" value="<%= cluster.getSchedulerName() %>" />
			<liferay-ui:search-container-column-text name="scheduler-version" value="<%= cluster.getSchedulerVersion() %>" />
			<liferay-ui:search-container-column-text name="" value="<%= new String( Character.toChars(8942)) %>" />
			<liferay-ui:icon-menu icon="ellipsis-v" >
			</liferay-ui:icon-menu>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>


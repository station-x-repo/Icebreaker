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

<liferay-frontend:management-bar
			includeCheckBox="<%= true %>"
			searchContainerId="clusterSearchContainer"
			disabled="<%= clustersCount == 0 %>"
>
	<liferay-frontend:management-bar-buttons>
		
		<liferay-portlet:actionURL name="changeDisplayStyle" varImpl="changeDisplayStyleURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
		</liferay-portlet:actionURL>
		
		<liferay-frontend:management-bar-display-buttons
					disabled="<%= clustersCount == 0 %>"
					displayViews='<%= new String[] {"descriptive", "icon", "list"} %>'
					portletURL="<%= changeDisplayStyleURL %>"
					selectedDisplayStyle="<%= clusterAdminToolbarDisplayContext.getDisplayStyle() %>"
		/>

		<liferay-frontend:add-menu inline="<%= true %>">
			<liferay-frontend:add-menu-item
						title='<%= LanguageUtil.get(request, "add-cluster-entry") %>'
						url="<%= addClusterRenderURL %>"
			/>
		</liferay-frontend:add-menu>
		
	</liferay-frontend:management-bar-buttons>
	
	 <liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation
					navigationKeys='<%= new String[] {"all"} %>'
					portletURL="<%= clusterAdminToolbarDisplayContext.getPortletURL() %>"
       />

		<liferay-frontend:management-bar-sort
					orderByCol="<%= clusterAdminToolbarDisplayContext.getOrderByCol() %>"
					orderByType="<%= clusterAdminToolbarDisplayContext.getOrderByType() %>"
					orderColumns='<%= new String[] {"removed-date"} %>'
					portletURL="<%= clusterAdminToolbarDisplayContext.getPortletURL() %>"
		/>
	</liferay-frontend:management-bar-filters>
	
	<liferay-frontend:management-bar-action-buttons>

		<liferay-frontend:management-bar-button 
					href="javascript:deleteEntries();"
					icon="delete" id="deleteSelectedEntries" label="delete" />
		</liferay-frontend:management-bar-action-buttons>

</liferay-frontend:management-bar>


<%
	PortletURL iteratorURL = renderResponse.createRenderURL();
%>

<liferay-ui:search-container
		searchContainer="<%= clusterSearchContainer %>"
		id="clusterSearchContainer"
		iteratorURL="<%= iteratorURL %>"
>
<%
%>
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

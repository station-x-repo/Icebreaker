<%@page import="com.osp.icebreaker.web.constants.OSPIcebreakerWebDefaultValues"%>
<%@page import="com.osp.icebreaker.web.constants.OSPIcebreakerWebParameterNames"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.osp.icebreaker.model.OSPCluster"%>
<%@page import="com.osp.icebreaker.web.constants.OSPIcebreakerWebMVCCommandNames"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="../../init.jsp"%>

 <%-- Generate add / edit action URL and set title. --%>
 <%
 	OSPCluster cluster = (OSPCluster)renderRequest.getAttribute(OSPIcebreakerWebParameterNames.CLUSTER);
 %>

 <c:choose>
     <c:when test="${not empty cluster}">
         <portlet:actionURL var="clusterActionURL" name="<%=OSPIcebreakerWebMVCCommandNames.EDIT_CLUSTER%>">
             <portlet:param name="redirect" value="${param.redirect}" />
         </portlet:actionURL>

         <c:set var="editTitle" value="edit-cluster"/>
     </c:when>
     <c:otherwise>
         <portlet:actionURL var="clusterActionURL" name="<%=OSPIcebreakerWebMVCCommandNames.ADD_CLUSTER%>">
             <portlet:param name="redirect" value="${param.redirect}" />
         </portlet:actionURL>

         <c:set var="editTitle" value="add-cluster"/>
     </c:otherwise>
 </c:choose>

 <div class="container-fluid-1280 edit-cluster-entry">

     <h1><liferay-ui:message key="${editTitle}" /></h1>

     <aui:model-context bean="${cluster}" model="${clusterClass}" />

     <aui:form action="${clusterActionURL}" name="fm">

         <aui:input name="clusterId" field="clusterId" type="hidden" />

         <aui:fieldset-group markupView="lexicon">

             <aui:fieldset>

                 <%-- Title field. --%>

                 <aui:input name="clusterName">
					<aui:validator name="required" />
                 </aui:input>

                 <%-- Description field. --%>

				<aui:field-wrapper label="description">
	                 <liferay-ui:input-localized name="description" xml=""/>
				</aui:field-wrapper>

				<aui:select name="securityLevel">
                 	<aui:option value="LEVEL_0" selected="true">ID and Password</aui:option>
                 	<aui:option value="LEVEL_1">One-time Password</aui:option>
                    <aui:option value="LEVEL_2">Send E-Mail and Delete</aui:option>
                    <aui:option value="LEVEL_3">Send Encoded E-Mail and Delete</aui:option>
                 </aui:select>
             </aui:fieldset>
         </aui:fieldset-group>

         <%-- Description for OS --%>
         <aui:fieldset-group markupView="lexicon">
             <aui:fieldset label="cluster-os">
                 <aui:input name="osFamily">
                 	<aui:validator name="required" />
                 </aui:input>
                 <aui:input name="osName">
                     <aui:validator name="required" />
                 </aui:input>
                 <aui:input name="osVersion">
                     <aui:validator name="required" />
                 </aui:input>
             </aui:fieldset>
         </aui:fieldset-group>

         <%-- Description for Default Path --%>
         <aui:fieldset-group markupView="lexicon">
             <aui:fieldset label="cluster-access-info">
                 <aui:input name="appRootDir">
                 	<aui:validator name="required" />
                 </aui:input>
                 <aui:input name="serverIp">
                 	<aui:validator name="required" />
                 </aui:input>
                 <aui:input name="sshPort">
                     <aui:validator name="required" />
                 </aui:input>
                 <aui:input name="authorizedId">
                     <aui:validator name="required" />
                 </aui:input>
                 <aui:input name="authorizedPassword">
                     <aui:validator name="required" />
                 </aui:input>
                 <aui:input name="identificationCommand" value="<%= OSPIcebreakerWebDefaultValues.DEFAUL_IDENTIFICATION_COMMAND %>">
                     <aui:validator name="required" />
                 </aui:input>
                 <aui:select name="accessMethod">
                 	<aui:option value="ssh" selected="true">SSH</aui:option>
                 	<aui:option value="api">API</aui:option>
                    <aui:option value="url">URL</aui:option>
                 </aui:select>
             </aui:fieldset>
         </aui:fieldset-group>

         <%-- Description for Scheduler --%>
         <aui:fieldset-group markupView="lexicon">
             <aui:fieldset label="job-scheduler-info">
                 <aui:input name="schedulerName">
                 	<aui:validator name="required" />
                 </aui:input>
                 <aui:input name="schedulerVersion">
                     <aui:validator name="required" />
                 </aui:input>
                 <aui:input name="schedulerClass">
                     <aui:validator name="required" />
                 </aui:input>
             </aui:fieldset>
         </aui:fieldset-group>

         <%--Buttons. --%>

         <aui:button-row>
             <aui:button cssClass="btn btn-primary" type="submit" />
             <aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel" />
         </aui:button-row>
     </aui:form>

 </div>
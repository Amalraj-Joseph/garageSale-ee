/**
 * 
 */
package com.ibm.websphere.svt.gs.gsjsfweb.facesflow;

import java.io.Serializable;

import jakarta.enterprise.inject.Produces;
import jakarta.faces.flow.Flow;
import jakarta.faces.flow.builder.FlowBuilder;
import jakarta.faces.flow.builder.FlowBuilderParameter;
import jakarta.faces.flow.builder.FlowDefinition;

/**
 * @author Administrator
 *
 */
public class ProductReviewFlowBuilder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2604278911831937541L;
	
    @Produces
    @FlowDefinition
	public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder){
    	
        String flowId = "productReviewFlow";
        flowBuilder.id("", flowId);
        flowBuilder.viewNode(flowId, "/" + flowId + "/" + flowId + ".jsf").markAsStartNode();

        flowBuilder.returnNode("goIndex").fromOutcome("/index.jsf");
        flowBuilder.returnNode("goReturn").fromOutcome("/facelets/productReviewFlow-Return.jsf");

        return flowBuilder.getFlow();

		
	}

}

package org.bpmnwithactiviti.chapter11.webservice;

// import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
// import org.bpmnwithactiviti.test.AbstractTest;
import org.junit.Rule;
import org.junit.Test;



public class WebServiceTest  {
	
	@Rule 
    public ActivitiRule activitiRule = new ActivitiRule("activiti.cfg-mem.xml");

	
	@Test
	@Deployment(resources="chapter11/webservice/iban.bpmn")
	public void queryTask() {
	 System.out.println("start!");
	  Map<String, Object> variableMap = new HashMap<String, Object>();
	  variableMap.put("sISBNInput", "1234567890");
	  System.out.println("After variable map creation!");
	  System.out.println(variableMap);
	  ProcessInstance processInstance = activitiRule.getRuntimeService().startProcessInstanceByKey("webserviceprocess", variableMap);
	  
	  System.out.println("dopo startprocessistance !");
	  Object responseValue = activitiRule.getRuntimeService().getVariable(processInstance.getProcessInstanceId(), "webserviceResponse");
	  System.out.println(responseValue);
	  // assertEquals("123.1", responseValue);
	  System.out.println("the end!");
	}
}

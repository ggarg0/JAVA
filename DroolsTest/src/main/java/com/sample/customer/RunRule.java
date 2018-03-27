package com.sample.customer;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
 
public class RunRule {
 
    public static void main(String[] args) {
         
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");
             
            CustomerRuleObject customerRuleObject = new CustomerRuleObject();
            customerRuleObject.setFirstName("Gaurav");
            kSession.insert(customerRuleObject);
            kSession.fireAllRules();
             
            System.out.println(customerRuleObject.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
 
}
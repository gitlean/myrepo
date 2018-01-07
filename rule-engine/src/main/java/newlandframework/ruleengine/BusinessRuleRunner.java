/**
 * @filename:BusinessRuleRunner.java
 *
 * Newland Co. Ltd. All rights reserved.
 * 
 * @Description:业务规则引擎执行器
 * @author tangjie
 * @version 1.0
 * 
 */

package newlandframework.ruleengine;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.drools.builder.ResourceType;
import org.drools.definition.KnowledgePackage;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;

public class BusinessRuleRunner {
    public BusinessRuleRunner() {}
    public void notify(String drlContent, ArrayList<Object> elements) {
        //构建知识库引擎
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        //KnowledgeBuilder规则编译：规则文件进行编译， 最终产生一批编译好的规则包(KnowledgePackage)供其它的应用程序使用
        try {
            kbuilder.add(ResourceFactory.newInputStreamResource(getDrlStream(drlContent)), ResourceType.DRL);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Collection<KnowledgePackage> pkgs = kbuilder.getKnowledgePackages();
        kbase.addKnowledgePackages(pkgs);
        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        
        
        //drl脚本有编译问题要提示
        if (kbuilder.hasErrors()) {
            System.out.println(kbuilder.getErrors().toString());
            throw new RuntimeException("Unable to compile: " + drlContent+ "\n");
        }
        
        
        //插入WorkingMemory
        for (int i = 0; i < elements.size(); i++) {
            Object fact = elements.get(i);
            ksession.insert(fact);
            
            //System.out.println("插入对象...");
        }
        
        
        //激活规则
        ksession.fireAllRules();
    }
    
    private InputStream getDrlStream(String drlContent) throws Exception{  
        ByteArrayInputStream is = new ByteArrayInputStream(drlContent.getBytes());  
        return is;  
    }  
}
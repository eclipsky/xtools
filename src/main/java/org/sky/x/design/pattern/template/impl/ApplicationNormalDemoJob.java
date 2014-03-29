
package org.sky.x.design.pattern.template.impl;

import java.util.Date;

import org.sky.x.design.pattern.template.AbstractJob;

/**
 * @author menglei
 */

public class ApplicationNormalDemoJob extends AbstractJob {

    @Override
    public void doJob() {
    	System.out.println("ApplicationNormalDemoJob程序运行时间："+new Date()+" ,ApplicationNormalDemoJob程序运行类"+ApplicationNormalDemoJob.class);
    }
    
    public static void main(String[] args) {
    	new ApplicationNormalDemoJob().execute();
    }
}

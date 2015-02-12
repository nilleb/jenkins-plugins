/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jenkinsci.plugins.rootactionexampleplugin;

import hudson.Plugin;
import jenkins.model.Jenkins;

/**
 *
 * @author BELLINSALARIN
 */
public class MyRootActionPlugin extends Plugin {
    @Override
    public void start() {
        Jenkins.getInstance().getActions().add(new MyRootActionWhichRequiresExplicitRegistration("A goalType"));
        Jenkins.getInstance().getActions().add(new MyAction("A goalType"));
    }
}

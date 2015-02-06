package org.jenkinsci.plugins.rootactionexampleplugin;

import hudson.Extension;
import hudson.model.RootAction;


@Extension
public class MyRootAction implements RootAction {
    @Override
    public String getIconFileName() {
        
        return "/images/32x32/blue.png";
    }

    @Override
    public String getDisplayName() {
        return "New Item";
    }

    @Override
    public String getUrlName() {
        return "rootactionExamplePlugin";
    }
}

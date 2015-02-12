package org.jenkinsci.plugins.rootactionexampleplugin;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Describable;
import hudson.model.Descriptor;
import hudson.model.RootAction;
import hudson.util.ListBoxModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.kohsuke.stapler.DataBoundConstructor;

public class MyRootActionWhichRequiresExplicitRegistration 
    extends AbstractDescribableImpl<MyRootActionWhichRequiresExplicitRegistration> 
    implements RootAction, Describable<MyRootActionWhichRequiresExplicitRegistration> {

    @Override
    public String getIconFileName() {

        return "/images/32x32/blue.png";
    }

    @Override
    public String getDisplayName() {
        return getClass().getSimpleName();
    }

    @Override
    public String getUrlName() {
        return getClass().getSimpleName();
    }

    @DataBoundConstructor
    public MyRootActionWhichRequiresExplicitRegistration(final String goalType)
    {
        this.goalType = goalType;
    }
    
    private String goalType = "A";
    
    public String getGoalType()
    {
        return goalType;
    }
    
    public void setGoalType(String g)
    {
        goalType = g;
    }

    public static final class MyGoal {

        public final String displayName;

        public String getDisplayName() {
            return displayName;
        }

        public final String id;

        public String getId() {
            return id;
        }

        public MyGoal(String displayName, String id) {
            this.id = id;
            this.displayName = displayName;
        }
    }

    public static List<MyGoal> getBuildGoals() {
        ArrayList<MyGoal> arrayList = new ArrayList<MyGoal>();
        arrayList.add(new MyGoal("A", "A"));
        arrayList.add(new MyGoal("B", "B"));
        arrayList.add(new MyGoal("C", "C"));
        return arrayList;
    }
    
    @Extension
    public static final class DescriptorImpl extends Descriptor<MyRootActionWhichRequiresExplicitRegistration> {
        public Map<String, Object> doCalcAttributes(){
            Map<String, Object> map = new HashMap<String, Object>();
            this.calcFillSettings("goalType", map);
            return map;
        }

        // not being called, anyway
        @Override
        public void calcFillSettings(String field, Map<String,Object> attributes) {
            super.calcFillSettings(field, attributes);
        }
        
        public ListBoxModel doFillGoalTypeItems() {
            ListBoxModel items = new ListBoxModel();
            for (MyGoal goal : getBuildGoals()) {
                items.add(goal.getDisplayName(), goal.getId());
            }
            return items;
        }

        @Override
        public String getDisplayName() {
            return clazz.getName();
        }
    }
}

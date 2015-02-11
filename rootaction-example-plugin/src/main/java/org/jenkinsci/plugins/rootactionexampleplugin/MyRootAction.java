package org.jenkinsci.plugins.rootactionexampleplugin;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Describable;
import hudson.model.Descriptor;
import hudson.model.RootAction;
import hudson.util.ListBoxModel;
import java.util.ArrayList;
import java.util.List;

@Extension
public class MyRootAction 
    extends AbstractDescribableImpl<MyRootAction> 
    implements RootAction, Describable<MyRootAction> {

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
    public static final class DescriptorImpl extends Descriptor<MyRootAction> {
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

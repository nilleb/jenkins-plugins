package org.jenkinsci.plugins.rootactionexampleplugin;

import hudson.Extension;
import hudson.model.Describable;
import hudson.model.Descriptor;
import hudson.model.RootAction;
import hudson.util.ListBoxModel;
import java.util.ArrayList;
import java.util.List;

@Extension
public class MyRootAction implements RootAction, Describable<MyRootAction> {

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
        return "MyRootAction";
    }

    @Override
    public Descriptor getDescriptor() {
        return new MyDescriptor();
    }

    public class MyGoal {

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

    public List<MyGoal> getBuildGoals() {
        ArrayList<MyGoal> arrayList = new ArrayList<MyGoal>();
        arrayList.add(new MyGoal("A", "A"));
        arrayList.add(new MyGoal("B", "B"));
        arrayList.add(new MyGoal("C", "C"));
        return arrayList;
    }
    
    public class MyDescriptor extends Descriptor<MyRootAction> {

        @Override
        public String getDisplayName() {
            return "MyRootAction";
        }

        public ListBoxModel doFillGoalTypeItems() {
            ListBoxModel items = new ListBoxModel();
            for (MyGoal goal : getBuildGoals()) {
                items.add(goal.getDisplayName(), goal.getId());
            }
            return items;
        }
    }
}

package com.javarush.task.jdk13.task41.task4121;

import com.javarush.task.jdk13.task41.task4121.support.*;

public class CRM {

    private TechSupport techSupport;

    public CRM() {
        this.techSupport = new CallCenter();
        TechSupport support1 = new HelpDesk();
        TechSupport support2 = new SysAdmin();
        TechSupport support3 = new ITDirector();
        techSupport.setNextLevel(support1);
        support1.setNextLevel(support2);
        support2.setNextLevel(support3);
    }

    public void register(String problem) {
        System.out.println(problem);
        techSupport.solve(problem.trim().toLowerCase());
    }
}

package com.javarush.task.jdk13.task41.task4109;

public class CguRequisition extends RequisitionWithPhone {
    public String requestedSubscriptionType;
    public String language;

    public CguRequisition() {
    }

    public CguRequisition(CguRequisition requisition) {
        super(requisition);
        this.requestedSubscriptionType = requisition.requestedSubscriptionType;
        this.language = requisition.language;
    }

    @Override
    public AbstractEntity clone() {
        return new CguRequisition(this);
    }
}

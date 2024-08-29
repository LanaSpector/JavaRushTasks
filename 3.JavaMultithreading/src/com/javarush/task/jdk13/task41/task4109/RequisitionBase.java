package com.javarush.task.jdk13.task41.task4109;

public abstract class RequisitionBase extends AbstractEntity {
    public User user;
    public String name;
    public String mail;
    public String utmMark;
    public String webinarType;
    public String promoCode;

    public RequisitionBase() {
    }

    public RequisitionBase(RequisitionBase base) {
        super(base);
        this.user = (User) base.user.clone();
        this.name = base.name;
        this.mail = base.mail;
        this.utmMark = base.utmMark;
        this.webinarType = base.webinarType;
        this.promoCode = base.promoCode;
    }


}

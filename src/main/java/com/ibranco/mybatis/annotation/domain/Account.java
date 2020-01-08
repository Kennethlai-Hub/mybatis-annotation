package com.ibranco.mybatis.annotation.domain;

public class Account {
    private Integer aid;
    private Integer userid;
    private String aname;
    private Double amoney;

    public Account() {
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Double getAmoney() {
        return amoney;
    }

    public void setAmoney(Double amoney) {
        this.amoney = amoney;
    }

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", userid=" + userid +
                ", aname='" + aname + '\'' +
                ", amoney=" + amoney +
                '}';
    }
}

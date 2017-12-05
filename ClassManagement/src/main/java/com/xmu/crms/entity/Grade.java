package com.xmu.crms.entity;

public class Grade {

    private int order;

    private String groupName;

    private String leader;

    private int seminarGrade;

    private int topicGrade;

    private double score;



    public Grade(int order,String groupName,String leader,int seminarGrade,int topicGrade,double score){

        this.order = order;

        this.groupName = groupName;

        this.leader = leader;

        this.seminarGrade = seminarGrade;

        this.topicGrade = topicGrade;

        this.score = score;

    }

    public int getOrder(){

        return order;

    }

    public String getLeader(){

        return leader;

    }

    public String getGroupName(){

        return groupName;

    }

    public int getSeminarGrade(){

        return seminarGrade;

    }

    public int getTopicGrade(){

        return topicGrade;

    }

    public double getScore(){

        return score;

    }



}

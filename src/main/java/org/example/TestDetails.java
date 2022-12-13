package org.example;

public class TestDetails {

    protected String publishTopic;

    protected String  subscribeTopic;
    protected int choice;
    protected int switch_status;

    protected int flag;
    public String returnMessage;
    protected String schoice;

    public void setPublishTopic(String publishTopic) {
        this.publishTopic = publishTopic;
    }

    public void setSubscribeTopic(String subscribeTopic) {
        this.subscribeTopic =  subscribeTopic;
    }
    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void setSwitch_status(int switch_status) {
        this.switch_status = switch_status;
    }

    public void setReturnMessage(String returnMessage){
        this.returnMessage = returnMessage;
    }
    public String getReturnMessage(){
        return returnMessage;
    }

    public void setsChoice(String schoice){
        this.schoice = schoice;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}

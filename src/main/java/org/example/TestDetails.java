package org.example;

public class TestDetails {

    protected String publishTopic;

    protected String  subscribeTopic;
    protected int choice;
    protected int switch_status;

    public String returnMessage;

    enum Components{
        test_motor,
        test_fs
    }

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
}

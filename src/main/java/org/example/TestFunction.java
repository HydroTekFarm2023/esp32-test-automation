package org.example;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.util.concurrent.CountDownLatch;

import java.lang.Thread.*;
import java.util.UUID;



public class TestFunction extends TestDetails
{
    public String test(final TestDetails testDetails) throws InterruptedException, IOException {

        JSONObject obj = new JSONObject();
        obj.put("choice", testDetails.choice);
        obj.put("switch_status", testDetails.switch_status);

        String topic = testDetails.publishTopic;
        String content = JSONValue.toJSONString(obj);
        int qos = 0;
        String broker = "ws://35.202.108.111:8000";
        String clientId = UUID.randomUUID().toString();
        MemoryPersistence persistence = new MemoryPersistence();

        IMqttClient sampleClient = null;
        final CountDownLatch latch = new CountDownLatch(1);
        try {

            sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            connOpts.setAutomaticReconnect(true);
            connOpts.setKeepAliveInterval(180);
            connOpts.setConnectionTimeout(10);


            System.out.println("Connecting to broker: " + broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");


            System.out.println("Publishing message: " + content);

            MqttMessage message = new MqttMessage(content.getBytes());

            message.setQos(qos);
            message.setRetained(true);
            sampleClient.publish(topic, message);

            System.out.println("Message published");




            sampleClient.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) { //Called when the client lost the connection to the broker

                    System.out.println("Connection Lost");
                    latch.countDown();
                }


                public void messageArrived(String topic, MqttMessage message) throws Exception {

                    String s = new String(message.getPayload());
                    FileWriter writer = new FileWriter("C:\\hydrotek\\work\\gitsrc\\ESP32_Automation_Testing\\src\\main\\java\\org\\example\\Result.txt");
                    writer.write(s);
                    writer.close();
                    latch.countDown();


                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                }


            });


        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("message " + me.getMessage());
            System.out.println("location " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("exception " + me);
            me.printStackTrace();
        }


        System.out.println("Subscribing client to request topic: " + testDetails.subscribeTopic);
        try {
            sampleClient.subscribe(testDetails.subscribeTopic, 1);
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Waiting for request message...");
        // Wait for till we have received a request and sent a response


        try {
            latch.await(); // block here until message received, and latch will flip
        } catch (InterruptedException e) {
            System.out.println("I was awoken while waiting");
        }
        FileReader reader = new FileReader("C:\\hydrotek\\work\\gitsrc\\ESP32_Automation_Testing\\src\\main\\java\\org\\example\\Result.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String msg = bufferedReader.readLine();
        reader.close();
        System.out.println("subscribed message: "+msg);
        return msg;
    }

}
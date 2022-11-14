package org.example;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class TestMain extends TestFunction {

 TestDetails details = new TestDetails();
 TestFunction function = new TestFunction();


        @Test
        public void testmotor ()
        {
           details.setPublishTopic("test_motor_request/TWuj4");
           details.setSubscribeTopic("test_motor_response/TWuj4");
           details.setChoice(1);
           details.setSwitch_status(1);

           try{
            String output = function.test(details);
            assertEquals("{\"choice\":1,\"switch_status\":-1}", output);
           }
           catch (Exception e){
            System.out.println(e);
           }
        }

        @Test
        public void test_fs ()
        {
            details.setPublishTopic("test_fs_request/TWuj4");
            details.setSubscribeTopic("test_fs_response/TWuj4");
            details.setChoice(1);
            details.setSwitch_status(1);

            try {
                String output = function.test(details);
                assertEquals("{\"choice\":1,\"switch_status\":1}", output);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }

        @Test
        public void test_sensor ()
        {
            details.setPublishTopic("test_sensor_request/TWuj4");
            details.setSubscribeTopic("test_sensor_response/TWuj4");
            details.setChoice(1);
            details.setSwitch_status(1);

            try {
                 String output = function.test(details);
                 assertEquals("{\"choice\":1,\"switch_status\":1}", output);
            }
            catch (Exception e) {
                 System.out.println(e);
            }
        }

        @Test
        public void test_outlets ()
        {
            details.setPublishTopic("test_outlet_request/TWuj4");
            details.setSubscribeTopic("test_outlet_response/TWuj4");
            details.setChoice(1);
            details.setSwitch_status(1);

            try {
                String output = function.test(details);
                assertEquals("{\"choice\":1,\"switch_status\":1}", output);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
}


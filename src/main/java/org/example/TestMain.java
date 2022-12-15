package org.example;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class TestMain extends TestFunction  {

 TestDetails details = new TestDetails();
 TestFunction function = new TestFunction();
 TestFunction end = new TestFunction();

        @Test
        public void testmotor ()
        {
            for(int i=1;i<=5;i++) {
                details.setPublishTopic("test_motor_request/4i6v1");
                details.setSubscribeTopic("test_motor_response/4i6v1");
                details.setChoice(i);
                details.setSwitch_status(1);

                try {
                    String output = function.test(details);
                    assertEquals("{\"choice\":"+i+",\"switch_status\":1}", output);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

        @Test
        public void test_fs ()
        {
            for(int i=0; i<2; i++) {
                details.setPublishTopic("test_fs_request/4i6v1");
                details.setSubscribeTopic("test_fs_response/4i6v1");
                details.setChoice(i);
                details.setSwitch_status(1);

                try {
                    String output = function.test(details);
                    assertEquals("{\"choice\":"+i+",\"switch_status\":1}", output);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

    @Test
    public void test_sensor() {
        String[] sensors = {"ec", "ph", "water_temp" };
        for (int i = 0; i < 3; i++) {
            details.setPublishTopic("test_sensor_request/4i6v1");
            details.setSubscribeTopic("test_sensor_response/4i6v1");
            details.setsChoice(sensors[i]);
            details.setSwitch_status(1);
            details.setFlag(1);

            try {
                String output = function.test(details);
                System.out.println("output:" + output);
                assertEquals("{\"switch_status\":1,\"choice\":\"" + sensors[i] +"\"}", output);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        details.setPublishTopic("test_sensor_request/4i6v1");
        details.setSubscribeTopic("test_sensor_response/4i6v1");
        details.setsChoice("end");
        details.setSwitch_status(12);

        try {
            String output = end.endTest(details);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

        @Test
        public void test_outlets ()
        {
           for(int i=1; i<=5; i++) {
                details.setPublishTopic("test_outlet_request/4i6v1");
                details.setSubscribeTopic("test_outlet_response/4i6v1");
                details.setChoice(i);
                details.setSwitch_status(1);

                try {
                    String output = function.test(details);
                    assertEquals("{\"switch_status\":1,\"choice\":"+i+"}", output);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            details.setPublishTopic("test_outlet_request/4i6v1");
            details.setSubscribeTopic("test_outlet_response/4i6v1");
            details.setChoice(6);
            details.setSwitch_status(12);

            try {
                String output = end.endTest(details);
            } catch (Exception e) {
                System.out.println(e);
            }

        }
}


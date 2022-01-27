package com.mingshashan.learn.mq.rocket;

public interface MQConstant {


    int MSG_COUNT_10 = 10;
    int MSG_COUNT_100 = 100;
    int MSG_COUNT_1000 = 1000;
    int MSG_COUNT_10000 = 10000;
    int MSG_COUNT_1000000 = 1000000;


    String TOPIC = "Topic01";
    String TAG = "Tag01";

    String CONSUMER_GROUP = "consumer-group-01";


    String ORDER_GROUP = "order_test_group";

    String ORDER_TOPIC = "order_test_topic";
    String ORDER_TAG1 = "order_test_tag1";
    String ORDER_TAG2 = "order_test_tag2";

    String ORDER_CONSUMER_GROUP = "order-consumer-group";


    String BROADCASTING_PRODUCER_GROUP = "broadcasting_test_group";

    String BROADCASTING_TOPIC = "broadcasting_test_topic";
    String BROADCASTING_TAG1 = "broadcasting_test_tag1";
    String BROADCASTING_TAG2 = "broadcasting_test_tag2";

    String BROADCASTING_CONSUMER_GROUP = "broadcasting-consumer-group";



    String NAME_SRV_ADDR = "192.168.75.129:9876";
}

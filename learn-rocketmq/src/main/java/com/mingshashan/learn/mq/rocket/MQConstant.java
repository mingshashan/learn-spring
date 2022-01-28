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

    String SCHEDULE_PRODUCER_GROUP =    "schedule-test-producer-group";
    String SCHEDULE_TOPIC =             "schedule-test-topic";
    String SCHEDULE_TAG1 =              "schedule-test-tag1";
    String SCHEDULE_TAG2 =              "schedule-test-tag2";
    String SCHEDULE_CONSUMER_GROUP =    "schedule-test-consumer-group";

    String BATCH_PRODUCER_GROUP =    "batch-test-producer-group";
    String BATCH_TOPIC =             "batch-test-topic";
    String BATCH_TAG1 =              "batch-test-tag1";
    String BATCH_TAG2 =              "batch-test-tag2";
    String BATCH_CONSUMER_GROUP =    "batch-test-consumer-group";

    String FILTER_PRODUCER_GROUP =    "filter-test-producer-group";
    String FILTER_TOPIC =             "filter-test-topic";
    String FILTER_TAG_A =             "filter-test-tag-a";
    String FILTER_TAG_B =             "filter-test-tag-b";
    String FILTER_TAG_C =             "filter-test-tag-c";
    String FILTER_TAG_D =             "filter-test-tag-d";
    String FILTER_TAG_E =             "filter-test-tag-e";
    String FILTER_TAG_F =             "filter-test-tag-f";
    String FILTER_TAG_DEFAULT =       "filter-test-tag-default";
    String FILTER_CONSUMER_GROUP =    "filter-test-consumer-group";


    String FILTER_PROPERTY_EVEN =     "even";

    String NAME_SRV_ADDR = "192.168.75.129:9876";
}

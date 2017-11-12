
package com.grallandco.demos;

import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.elasticsearch2.ElasticsearchSink;
import org.apache.flink.streaming.connectors.elasticsearch2.ElasticsearchSinkFunction;
import org.apache.flink.streaming.connectors.elasticsearch2.RequestIndexer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer09;
import org.apache.flink.streaming.util.serialization.SimpleStringSchema;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Requests;


import java.net.InetSocketAddress;
import java.util.*;


public class ReadFromKafka {


  public static void main(String[] args) throws Exception {
    // create execution environment
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

    Properties properties = new Properties();
    properties.setProperty("bootstrap.servers", "localhost:9092");
    properties.setProperty("group.id", "flink_consumer");


    DataStream<String> stream = env
            .addSource(new FlinkKafkaConsumer09<>("testing", new SimpleStringSchema(), properties));

    stream.map(new MapFunction<String, String>() {
      private static final long serialVersionUID = -6867736771747690202L;

      @Override
      public String map(String value) throws Exception {
        return "Stream Value: " + value;
      }
    }).print();

    env.execute();
  }


}

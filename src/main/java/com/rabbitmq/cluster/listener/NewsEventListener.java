package com.rabbitmq.cluster.listener;

import com.rabbitmq.cluster.model.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NewsEventListener {

  private final Logger log = LoggerFactory.getLogger(NewsEventListener.class);

  @RabbitListener(queues = "queue.politics.event")
  public void onPoliticsEvent(News news) {
    log.info("Consume politics news {}", news);
  }

  @RabbitListener(queues = "queue.sport.event")
  public void onSportEvent(News news) {
    log.info("Consume sport news {}", news);
  }

  @RabbitListener(queues = "queue.weather.event")
  public void onWeatherEvent(News news) {
    log.info("Consume weather news {}", news);
  }
}

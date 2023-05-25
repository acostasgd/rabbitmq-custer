package com.rabbitmq.cluster.producer;

import com.rabbitmq.cluster.model.News;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NewsEventProducer {

  private final Logger log = LoggerFactory.getLogger(NewsEventProducer.class);

  private final RabbitTemplate newsEventClient;

  public NewsEventProducer(RabbitTemplate newsEventClient) {
    this.newsEventClient = newsEventClient;
  }

  @Scheduled(fixedDelay = 12 * 1000)
  public void politicsNewsNotifications() {
    var politicsNews = new News();
    politicsNews.setUuid(UUID.randomUUID().toString());
    politicsNews.setTitle("Politics news");
    politicsNews.setContent("Politics news content");
    log.info("Publish politics news {}", politicsNews);
    newsEventClient.convertAndSend("politics.event", politicsNews);
  }

  @Scheduled(fixedDelay = 10 * 1000)
  public void sportNewsNotifications() {
    var sportNews = new News();
    sportNews.setUuid(UUID.randomUUID().toString());
    sportNews.setTitle("Sport news");
    sportNews.setContent("Sport news content");
    log.info("Publish sport news {}", sportNews);
    newsEventClient.convertAndSend("sport.event", sportNews);
  }

  @Scheduled(fixedDelay = 7 * 1000)
  public void weatherNewsNotifications() {
    var weatherNews = new News();
    weatherNews.setUuid(UUID.randomUUID().toString());
    weatherNews.setTitle("Weather news");
    weatherNews.setContent("Weather news content");
    log.info("Publish weather news {}", weatherNews);
    newsEventClient.convertAndSend("weather.event", weatherNews);
  }
}

package ba.team12.articles.Rabbitmq;

import ba.team12.articles.models.Location;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${jsa.rabbitmq.exchange}")
    private String exchange;

    @Value("${jsa.rabbitmq.routingkey}")
    private String routingKey;

    public void produceMsg(String msg){
        Location location=new Location();
        location.setName("Sarajevo");
        location.setId(5L);
        String zaslanje= "{ \"name\" : \""+location.getName() +"\", \"id\" :"+location.getId() +"}";
        System.out.println("Sent location: " + location.toString());




        amqpTemplate.convertAndSend(exchange, routingKey, zaslanje);

    }
}


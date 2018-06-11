package ba.team12.articles.Rabbitmq;

import ba.team12.articles.models.Location;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/*
@Component
public class Consumer {

    ObjectMapper objectMapper=new ObjectMapper();

    @RabbitListener(queues="${jsa.rabbitmq.queue}")
    public void recievedMessage(String msg) {
        System.out.println("Recieved Message: " + msg);
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            Location location1= objectMapper.readValue(msg,Location.class);

        }
        catch (Exception ex){
            System.out.println("neuspjesno");

        }
    }
}

*/
package class101.foo.io;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Consumer {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    PostRepository postRepository;

    @RabbitListener(queues = "CREATE_POST_QUEUE")
    public void handler(String message) throws JsonProcessingException {
        final Post post = objectMapper.readValue(message, Post.class);
        postRepository.save(post);
    }
}

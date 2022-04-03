package class101.foo.io;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends ElasticsearchRepository<Post, String> {

    List<Post> findByContent(String content);
}

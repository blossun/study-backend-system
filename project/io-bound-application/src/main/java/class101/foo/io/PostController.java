package class101.foo.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    private static final Integer PAGE_SIZE = 20;

    @Autowired
    PostRepository postRepository;

    // 1. 글을 작성한다.
    @PostMapping("/post")
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    // 2. 글 목록을 페이징하여 반환
    @GetMapping("/posts")
    public Page<Post> getPostList(@RequestParam(defaultValue = "1") Integer page) {
        return postRepository.findAll(
                PageRequest.of(page - 1, PAGE_SIZE, Sort.by("id").descending())
        );
    }

    // 3. 글 번호로 조회
    
    // 4. 글 내용으로 검색 -> 해당 내용이 포함된 모든 글

}

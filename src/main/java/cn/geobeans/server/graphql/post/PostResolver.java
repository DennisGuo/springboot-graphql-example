package cn.geobeans.server.graphql.post;

import cn.geobeans.server.graphql.user.User;
import cn.geobeans.server.graphql.user.UserService;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostResolver implements GraphQLResolver<Post> {

    private final UserService service;

    @Autowired
    public PostResolver(UserService service) {
        this.service = service;
    }

    public User getAuthor(Post post){
        return service.findByUsername(post.getAuthor().getUsername());
    }
}

package cn.geobeans.server.graphql.user;

import cn.geobeans.server.graphql.post.Post;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserResolver implements GraphQLResolver<User> {
    private final UserService service;

    @Autowired
    public UserResolver(UserService service) {
        this.service = service;
    }

    public List<Post> getPosts(User user){
        return user.getPosts();
    }

}

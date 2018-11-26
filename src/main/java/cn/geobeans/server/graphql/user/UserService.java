package cn.geobeans.server.graphql.user;

import cn.geobeans.server.graphql.post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepo repo;

    @Autowired
    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public List<Post> getUserPosts(String username) {
        List<Post> rs = new ArrayList<>();
        User user = repo.findById(username).orElse(null);
        if(user != null){
            rs = user.getPosts();
        }
        return rs;
    }

    public User save(String username, String password, String phone, String name) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setName(name);
        return repo.save(user);
    }

    public List<User> page(PageRequest page) {
        return repo.findAll(page).getContent();
    }

    public User findByUsername(String username) {
        return repo.getOne(username);
    }
}

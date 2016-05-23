package Services;

import Entities.PostEntity;
import Entities.UserEntity;
import Repositories.PostRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Stateless
public class PostService implements Serializable {

    @Inject
    PostRepository postRepository;

    public PostEntity create(String title, String content, UserEntity user) {

        if (title == null || content == null) {
            return null;
        }

        PostEntity post = new PostEntity();
        post.setTitle(title);
        post.setContent(content);
        post.setSlug(title.toLowerCase().replaceAll("[^a-z0-9-]", ""));
        post.setUser(user);

        post = postRepository.create(post);

        return post;

    }

    public List<PostEntity> getAll() {

        return postRepository.getAll();

    }

}

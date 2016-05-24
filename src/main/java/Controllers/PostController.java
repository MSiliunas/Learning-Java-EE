package Controllers;

import Entities.PostEntity;
import Entities.UserEntity;
import Services.PostService;
import Services.UserService;

import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@Stateful
@ConversationScoped
public class PostController implements Serializable {

    @Inject
    PostService postService;

    @Inject
    UserService userService;

    @PersistenceContext(type = PersistenceContextType.EXTENDED, synchronization = SynchronizationType.UNSYNCHRONIZED)
    EntityManager em;

    @Inject
    Conversation conversation;

    List<PostEntity> postList = new ArrayList<>();

    UserEntity currentUser;

    String userLoginEmail;

    String userPostTitle;
    String userPostText;

    public UserEntity getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserEntity currentUser) {
        this.currentUser = currentUser;
    }

    public String getUserLoginEmail() {
        return userLoginEmail;
    }

    public void setUserLoginEmail(String userLoginEmail) {
        this.userLoginEmail = userLoginEmail;
    }

    public String getUserPostTitle() {
        return userPostTitle;
    }

    public void setUserPostTitle(String userPostTitle) {
        this.userPostTitle = userPostTitle;
    }

    public String getUserPostText() {
        return userPostText;
    }

    public void setUserPostText(String userPostText) {
        this.userPostText = userPostText;
    }

    public void login() {

        currentUser = userService.getByEmail(userLoginEmail);
        if (currentUser == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User not found!"));
        }

        conversation.begin();

    }

    public String createPost() {

        if (currentUser == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You must login!"));
            return "";
        }

        PostEntity post = postService.create(userPostTitle, userPostText, currentUser);

        if (post == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Post not created!"));
            return "";
        }

        postList.add(post);

        return "";

    }

    public String save() {
        try {
            em.joinTransaction();
            currentUser.setLastPost(new Date());
            em.persist(currentUser);
            em.flush();
            conversation.end();
        } catch (OptimisticLockException e) {
            e.printStackTrace();

            return null;
        }

        return "postCreated";
    }

    public List<PostEntity> getAllPosts() {

        return postService.getAll();

    }

    public List<PostEntity> getPostList() {
        return postList;
    }

    public void setPostList(List<PostEntity> postList) {
        this.postList = postList;
    }
}


import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;


import java.util.Map;
import java.util.stream.Collectors;


public class StreamMain {

    public static void main(String[] args) {

        Forum forum = new Forum();

        Map<Integer, ForumUser> forumUserMap = forum.getForumUsers().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> user.getAge() >= 20)
                .filter(user -> user.getPostCount() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserID, user -> user));


        forumUserMap.forEach((key, value) -> System.out.println("ID: " + key + " " + value.toString()));

    }

}

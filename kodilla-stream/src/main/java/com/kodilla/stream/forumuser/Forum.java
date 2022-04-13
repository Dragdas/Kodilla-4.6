package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private List<ForumUser> forumUsers = new ArrayList<>();

    public Forum() {
        addUser(new ForumUser(1, "Monika",      'F', LocalDate.of(2008,8,8),5  ));
        addUser(new ForumUser(2, "Krzysiek",    'M', LocalDate.of(1992,1,19),4 ));
        addUser(new ForumUser(3, "Kasia",       'F', LocalDate.of(2010,5,14),7  ));
        addUser(new ForumUser(4, "Adnrzej",     'M', LocalDate.of(2014,8,24),0  ));
        addUser(new ForumUser(5, "Basia",       'F', LocalDate.of(1999,4,15) ,5 ));
        addUser(new ForumUser(6, "Piotr",       'M', LocalDate.of(2000,4,15),0  ));
        addUser(new ForumUser(7, "Martyna",     'F', LocalDate.of(1998,4,23),5  ));
        addUser(new ForumUser(8, "Iza",         'F', LocalDate.of(1996,12,5),78  ));


    }

    public void addUser(ForumUser user){
        forumUsers.add(user);
    }

    public List<ForumUser> getForumUsers(){
        return new ArrayList<>(forumUsers);
    }


}

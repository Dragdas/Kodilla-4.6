package com.kodilla.exception.nullpointer;

import javax.swing.text.html.Option;
import java.util.Optional;

public class NullPointerExceptionRunner {

    public static void main(String[] args) {

        User user = new User("Kamil");

        Optional<User> optionalUser = Optional.ofNullable(user);

    }

}

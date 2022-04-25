package com.kodilla.exception.nullpointer;

public class MessageSender {

    public void sendMessageTo(User user, String message) throws MessageNotSentException{
        if(user == null)
            throw new MessageNotSentException("User obj was null");

        System.out.println("Sending message: " + message + " to: " + user.getUserName());
    }

}

package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.forum.Observer;

public interface HomeworkObservable {

    void registerObserver(HomeworkObserver homeworkObserver);
    void notifyObservers();
    void removeObserver(HomeworkObserver homeworkObserver);
}

package com.netease.explore;

import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class ReactiveMain {


  public static void main(String[] args) {
    Flowable.just("Hello World").filter(s -> s.contains("He")).subscribe(s -> {
      System.out.println(s);
    });

    Flowable.just("asdasd").subscribe(new Subscriber<String>() {
      @Override
      public void onSubscribe(Subscription subscription) {

      }

      @Override
      public void onNext(String s) {

      }

      @Override
      public void onError(Throwable throwable) {

      }

      @Override
      public void onComplete() {

      }
    });

  }

}

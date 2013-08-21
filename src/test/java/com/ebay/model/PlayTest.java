package com.ebay.model;

import com.ebay.web.model.Play;

import org.testng.annotations.Test;

public class PlayTest {

  @Test
  public void smoke() {
    Play p = new Play(0, 0, 5);
  }

  @Test(expectedExceptions = RuntimeException.class)
  public void neg1() {
    Play p = new Play(10, 0, 5);
  }

  @Test(expectedExceptions = RuntimeException.class)
  public void neg2() {
    Play p = new Play(0, -1, 5);
  }

  @Test(expectedExceptions = RuntimeException.class)
  public void neg3() {
    Play p = new Play(10, 0, -1);
  }

  @Test(expectedExceptions = RuntimeException.class)
  public void neg4() {
    Play p = new Play(10, 0, 0);
  }

  @Test(expectedExceptions = RuntimeException.class)
  public void neg5() {
    Play p = new Play(10, 0, 10);
  }

  @Test
  public void ok() {
    Play p = new Play(0, 0, 1);
  }

  @Test
  public void ok1() {
    Play p = new Play(0, 0, 9);
  }
}

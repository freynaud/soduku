package com.ebay.model;

import com.ebay.web.model.Play;
import com.ebay.web.model.Position;
import com.ebay.web.model.RuleResult;
import com.ebay.web.model.SodokuModel;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SodokuTest {


  @Test
  public void initToMinusOne() {
    SodokuModel s = new SodokuModel();
    Assert.assertEquals(s.get(new Position(0, 0)), -1);
    Assert.assertEquals(s.get(new Position(8, 8)), -1);
    Assert.assertEquals(s.get(new Position(2, 2)), -1);
  }

  @Test
  public void getSet() {
    SodokuModel s = new SodokuModel();
    Position p = new Position(0, 0);
    s.set(p, 1);
    Assert.assertEquals(s.get(p), 1);
  }

  @Test(expectedExceptions = RuntimeException.class)
  public void setOnce() {
    SodokuModel s = new SodokuModel();
    Position p = new Position(0, 0);
    s.set(p, 1);
    s.set(p, 1);
  }


  @Test
  public void checkIsValid() {
    SodokuModel m = new SodokuModel();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 9; j++) {
        int value = (3*i) + j + 1;
        while (value >=10){
          value-=9;
        }
        m.set(new Position(i, j), value);
      }
    }
    Assert.assertTrue(m.isValid());
  }


  @Test
  public void checkLineAndColumn() {
    SodokuModel m = new SodokuModel();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 9; j++) {
        if( i==2 && j==0){
          continue;
        }
        int value = (3*i) + j + 1;
        while (value >=10){
          value-=9;
        }
        m.set(new Position(i, j), value);
      }
    }
    System.out.println(m);
    Assert.assertTrue(m.isValid());
    Play p = new Play(2,0,7);
    List<RuleResult> results = m.applyRules(p);
    Assert.assertTrue(results.isEmpty());
  }

  @Test
  public void checkLineAndColumnNeg() {
    SodokuModel m = new SodokuModel();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 9; j++) {
        if( i==2 && j==0){
          continue;
        }
        int value = (3*i) + j + 1;
        while (value >=10){
          value-=9;
        }
        m.set(new Position(i, j), value);
      }
    }
    System.out.println(m);
    Assert.assertTrue(m.isValid());
    Play p = new Play(2,0,1);
    List<RuleResult> results = m.applyRules(p);
    Assert.assertTrue(results.size()==2);
    System.out.println(results);

  }
}

package com.ebay.model;

import com.ebay.web.model.NumberUniquePerLine;
import com.ebay.web.model.Play;
import com.ebay.web.model.Position;
import com.ebay.web.model.RuleResult;
import com.ebay.web.model.SodokuModel;

import org.junit.Assert;
import org.testng.annotations.Test;

public class RuleLineTest {


  static SodokuModel generateLineWith4Empty() {
    SodokuModel m = new SodokuModel();
    for (int i = 0; i < 9; i++) {
      if (i == 4) {
        continue;
      }
      m.set(new Position(0, i), i + 1);
    }
    return m;
  }


  @Test
  public void testValideChoiceIsOk() {
    SodokuModel m = generateLineWith4Empty();

    Play p = new Play(new Position(0, 4), 5);
    NumberUniquePerLine pul = new NumberUniquePerLine(0);
    RuleResult res = pul.validate(m, p);

    Assert.assertTrue(res.isFullfiled());
  }

  @Test
  public void testWrongChoiceIsnotOk() {
    SodokuModel m = generateLineWith4Empty();

    Play p = new Play(new Position(0, 4), 1);
    NumberUniquePerLine pul = new NumberUniquePerLine(0);
    RuleResult res = pul.validate(m, p);

    Assert.assertFalse(res.isFullfiled());
    Assert.assertEquals(res.getViolatedPositions().size(), 1);
    Assert.assertEquals(res.getViolatedPositions().get(0), new Position(0, 0));
  }


  private SodokuModel generateWrongGrid() {
    SodokuModel m = new SodokuModel();
    for (int i = 0; i < 9; i++) {
      if (i == 4) {
        continue;
      }
      m.set(new Position(0, i), 1);
    }
    return m;
  }

  @Test
  public void handleErrors() {

    SodokuModel m = generateWrongGrid();
    Play p = new Play(new Position(0, 4), 2);
    NumberUniquePerLine pul = new NumberUniquePerLine(0);
    RuleResult res = pul.validate(m, p);

    Assert.assertTrue(res.isFullfiled());

  }

  @Test
  public void detectWrongGrid() {
    SodokuModel m = generateWrongGrid();
    Assert.assertFalse(m.isValid());
  }


  @Test
  public void detectOkGrid() {
    SodokuModel m = generateLineWith4Empty();
    Assert.assertTrue(m.isValid());
  }

}

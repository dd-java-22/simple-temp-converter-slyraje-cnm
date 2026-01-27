package edu.cnm.deepdive.tempconvert;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConverterTest {

  static final double TOLERANCE_SCALE = 0.0001;

  @Test
  void convertC2F() {
    Converter converter = new Converter();
    double celsius = -40;
    double expected = -40;
    double actual = converter.convertC2F(celsius);
    double tolerance = Math.abs(expected * TOLERANCE_SCALE);
    assertEquals(expected, actual, tolerance);


  }

}
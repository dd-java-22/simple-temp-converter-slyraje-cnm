package edu.cnm.deepdive.tempconvert.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

class ConverterTest {

  static final double TOLERANCE_SCALE = 0.0001;
  static final double MIN_ABSOLUTE_TOLERANCE = 0.0000000001;

  @ParameterizedTest
  @CsvFileSource(resources = "convert-valid.csv", useHeadersInDisplayName = true)
  void convertC2F_valid(double celsius, double expected) {
    double tolerance = Math.max(MIN_ABSOLUTE_TOLERANCE, Math.abs(expected * TOLERANCE_SCALE));
    assertEquals(
        expected,
        new Converter().convertC2F(celsius),
        tolerance
    );
  }

  @ParameterizedTest
  @ValueSource(doubles = {Converter.CELSIUS_ABSOLUTE_ZERO - 0.01, -Double.MAX_VALUE})
  void convertC2F_invalid(double celsius) {
    assertThrows(IllegalArgumentException.class, () -> new Converter().convertC2F(celsius));
  }

  @ParameterizedTest
  @CsvFileSource(resources = "convert-valid.csv", useHeadersInDisplayName = true)
  void convertF2C_valid(double expected, double fahrenheit) {
    double tolerance = Math.max(MIN_ABSOLUTE_TOLERANCE, Math.abs(expected * TOLERANCE_SCALE));
    assertEquals(
        expected,
        new Converter().convertF2C(fahrenheit),
        tolerance
    );
  }

  @ParameterizedTest
  @ValueSource(doubles = {Converter.FAHRENHEIT_ABSOLUTE_ZERO - 0.01, -Double.MAX_VALUE})
  void convertF2C_invalid(double fahrenheit) {
    assertThrows(IllegalArgumentException.class, () -> new Converter().convertF2C(fahrenheit));
  }


}
package com.davydovskyi.study.lab3;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class Algorithm01Test {

    public static Stream<Arguments> argsForFirstCond() {
        return Stream.of(
                // - && -
                Arguments.of(0, 1, 0., 0.),
                // - && -
                Arguments.of(1, 1, 0., 0.),
                // + && -
                Arguments.of(2, 1, 0., 1.),
                // - && +
                Arguments.of(0, 0, 0., 0.),
                // - && +
                Arguments.of(1, 0, 0., 0.),
                // + && +
                Arguments.of(2, 0, 0., 1.)
        );
    }

    public static Stream<Arguments> argsForSecondCond() {
        return Stream.of(
                // - || -
                Arguments.of(1, 0, 0., 0.), // could be removed as duplicate of line 28
                // - || -
                Arguments.of(1, 0, 1., 1.),
                // - || +
                Arguments.of(1, 0, 2., 3.),
                // + || -
                Arguments.of(2, 1, 0., 1.), // could be removed as duplicate of line 24
                // + || -
                Arguments.of(2, 1, 1., 2.),
                // + || +
                Arguments.of(2, 1, 2., 3.)
        );
    }

    public static Stream<Arguments> argsForCalculations() {
        return Stream.of(
                Arguments.of(4, 0, 0., 0.), //first operation only, X = 0
                Arguments.of(4, 0, -8., -2.), //first operation only, X < 0
                Arguments.of(2, 1, 0., 1.), //second operation only, by condition A
                Arguments.of(0, 1, 3., 4.), //second operation only, by condition X
                Arguments.of(2, 0, 2., 2.) //both operations
        );
    }

    @ParameterizedTest
    @MethodSource("argsForFirstCond")
    public void testFirstIf(int a, int b, double x, double expected) {
        var actual = AlgorithmExecutor.schema1(a, b, x);
        assertThat(actual)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("argsForSecondCond")
    public void testSecondIf(int a, int b, double x, double expected) {
        var actual = AlgorithmExecutor.schema1(a, b, x);
        assertThat(actual)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("argsForCalculations")
    public void checkCalculations(int a, int b, double x, double expected) {
        var actual = AlgorithmExecutor.schema1(a, b, x);
        assertThat(actual)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("argsForFirstCond")
    @Disabled
    public void testOnBroken01(int a, int b, double x, double expected) {
        var actual = AlgorithmExecutor.schema1Broken01(a, b, x);
        assertThat(actual)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("argsForSecondCond")
    @Disabled
    public void testOnBroken02(int a, int b, double x, double expected) {
        var actual = AlgorithmExecutor.schema1Broken02(a, b, x);
        assertThat(actual)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("argsForFirstCond")
    @Disabled
    public void testOnBroken03_01(int a, int b, double x, double expected) {
        var actual = AlgorithmExecutor.schema1Broken03(a, b, x);
        assertThat(actual)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("argsForSecondCond")
    @Disabled
    public void testOnBroken03_02(int a, int b, double x, double expected) {
        var actual = AlgorithmExecutor.schema1Broken03(a, b, x);
        assertThat(actual)
                .isEqualTo(expected);
    }

}

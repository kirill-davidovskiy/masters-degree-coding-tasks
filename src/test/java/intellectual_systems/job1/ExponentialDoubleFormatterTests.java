package intellectual_systems.job1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ExponentialDoubleFormatterTests {

    public static Stream<Arguments> task1ArgumentSource() {
        return Stream.of(
                Arguments.of(0.99999999999, "1.0Е0"),
                Arguments.of(-90.999999999, "-9.1Е1"),
                Arguments.of(90.99999999999, "9.1Е1"),
                Arguments.of(-0.000031475926, "-3.1Е-5"),
                Arguments.of(-37710.99999999999, "-3.8Е4"),
                Arguments.of(-3771099, "-3.8Е6"),
                Arguments.of(-4133.3333, "-4.1Е3"),
                Arguments.of(-99.99999999999, "-1.0Е2"),
                Arguments.of(-99999.99999999999, "-1.0Е5"),
                Arguments.of(-99999, "-1.0Е5"),
                Arguments.of(99999, "1.0Е5")

        );
    }


    @ParameterizedTest
    @MethodSource("task1ArgumentSource")
    public void task1(double source,
                      String expected) {
        var actual = ExponentialDoubleFormatter.format(source);
        log.info("Source {}, Expected {}, Actual {}", source, expected, actual);

        assertThat(actual).isEqualTo(expected);
    }
}
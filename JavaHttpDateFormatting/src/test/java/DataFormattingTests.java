import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DataFormattingTests {
    @ParameterizedTest
    @MethodSource("testCases")
    void customFormatter(OffsetDateTime date, String expected) {
        var formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ENGLISH).withZone(ZoneId.of("GMT"));
        var formattedDate = formatter.format(date);
        assertEquals(expected, formattedDate);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void standardFormatter(OffsetDateTime date, String expected) {
        var formattedDate = DateTimeFormatter.RFC_1123_DATE_TIME.format(date);
        assertEquals(expected, formattedDate);
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                arguments(OffsetDateTime.of(2024, 5, 6, 3, 5, 7, 0, ZoneOffset.UTC), "Mon, 06 May 2024 03:05:07 GMT"),
                arguments(OffsetDateTime.of(2024, 11, 24, 15, 13, 22, 0, ZoneOffset.UTC), "Sun, 24 Nov 2024 15:13:22 GMT")
        );
    }
}

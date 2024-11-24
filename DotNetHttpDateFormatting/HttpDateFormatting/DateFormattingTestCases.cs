using System.Collections;

namespace HttpDateFormatting;
internal class DateFormattingTestCases
{
    public static IEnumerable TestCases
    {
        get
        {
            yield return new TestCaseData(new DateTimeOffset(2024, 5, 6, 3, 5, 7, TimeSpan.Zero)).Returns("Mon, 06 May 2024 03:05:07 GMT");
            yield return new TestCaseData(new DateTimeOffset(2024, 11, 24, 15, 13, 22, TimeSpan.Zero)).Returns("Sun, 24 Nov 2024 15:13:22 GMT");
        }
    }
}

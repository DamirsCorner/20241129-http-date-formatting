using System.Globalization;

namespace HttpDateFormatting
{
    public class DateFormattingTests
    {
        [TestCaseSource(typeof(DateFormattingTestCases), nameof(DateFormattingTestCases.TestCases))]
        public string CustomFormatString(DateTimeOffset date)
        {
            return date.ToString("ddd, dd MMM yyyy HH:mm:ss 'GMT'", CultureInfo.InvariantCulture);
        }

        [TestCaseSource(typeof(DateFormattingTestCases), nameof(DateFormattingTestCases.TestCases))]
        public string StandardFormatString(DateTimeOffset date)
        {
            return date.ToString("R");
        }
    }
}

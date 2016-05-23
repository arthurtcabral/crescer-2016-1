using System;
using System.Globalization;

namespace CdZ.MVC.Extensions
{
    public static class StringExtensions
    {
        public static DateTime FromISOToDateTime(this string isoDate)
        {
            return DateTime.Parse(isoDate, null, DateTimeStyles.RoundtripKind);
        }
    }
}
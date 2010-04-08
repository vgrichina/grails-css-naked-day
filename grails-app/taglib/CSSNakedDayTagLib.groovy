class CSSNakedDayTagLib {
    static namespace = "cx"

    def isCssNakedDay = { attrs, body ->
        if (checkForCssNakedDay()) {
            out << body()
        }
    }

    def isNotCssNakedDay = { attrs, body ->
        if (!checkForCssNakedDay()) {
            out << body()
        }
    }

    /**
      * Checks if current time is within CSS Naked Day celebration time range.
      *
      * @return true if it is CSS Naked Day now, false otherwise 
      */
    private boolean checkForCssNakedDay() {
        // Return cached value if available
        if (request["isCssNakedDay"] != null) {
            return request["isCssNakedDay"]
        }

        // Get current date
        def nowCalendar = new GregorianCalendar()
        
        // Calculate start and end dates, based on 9th of April and 48 hour range
        def startCalendar = new GregorianCalendar(nowCalendar.get(Calendar.YEAR), Calendar.APRIL, 9);
        def endCalendar = startCalendar.clone()
        startCalendar.add(Calendar.HOUR, -12)
        endCalendar.add(Calendar.HOUR, 36)

        // Start and end dates are in GMT
        startCalendar.set(Calendar.ZONE_OFFSET, 0)
        endCalendar.set(Calendar.ZONE_OFFSET, 0)
    
        // Compare dates and store result in request
        boolean isNow = (nowCalendar >= startCalendar) && (nowCalendar <= endCalendar)
        request["isCssNakedDay"] = isNow

        return isNow
    }
}

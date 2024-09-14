package SeleniumSessions;

public class SeleniumWait {
	public static void main(String[] args) {

		// ExplicitWait:
		// WebDriverWait (C) (extend)--> FluentWait (C) (implement)==> Wait(I) --inside Wait(I)-- until()[method];
		// public class WebDriverWait extends FluentWait
		// class FluentWait<T> implements Wait<T>
		// Wait(I) having only one method until().

		// WebDriverWait have only --> 1 method (timeOutException() -- which is overriden method from FluentWait class)
		// zero individual methods in WebDriverWait class
		// WebDriverWait and FluentWait is exactly same only WebDriverWait have overriden method timeOutException()

	}

}

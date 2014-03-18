package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {
	private static final String template = "Hello %s!";
	private static final String template2 = "Goodbye %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	Greeting sayHello(
			@RequestParam(defaultValue = "You", required = false, value = "name") String name) {

		return new Greeting(counter.incrementAndGet(), String.format(template,
				name));
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	Greeting sayGoodbye(
			@RequestParam(defaultValue = "buddy", required = false, value = "name") String name) {

		return new Greeting(counter.incrementAndGet(), String.format(template2,
				name));
	}
}

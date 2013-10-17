import static org.fest.assertions.Assertions.*;
import static play.mvc.Http.Status.*;
import static play.test.Helpers.*;

import org.junit.Test;

import play.mvc.Result;


public class ApplicationTest {

	@Test
	public void dummy(){
		
	}

	@Test
	public void getUserInterestedInSegment() {
		running(fakeApplication(), new Runnable() {
			public void run() {

				Result result = callAction(controllers.routes.ref.Application
						.index());
				assertThat(status(result)).isEqualTo(OK);

			}
		});
	}

}

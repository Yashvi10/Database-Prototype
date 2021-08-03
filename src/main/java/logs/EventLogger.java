package logs;

import java.io.IOException;

public interface EventLogger {

  void event(String name, long timeELapsed) throws IOException;

}

package ForYouShipment.Workers;

public class LoggingWorker {
    private static LoggingWorker instance = null;

    private LoggingWorker() {}

    static LoggingWorker GetInstance() {
        if (instance == null)
            instance = new LoggingWorker();
        return instance;
    }

    void Log(String log) {
        // TODO: String time = java.time.LocalDateTime.now(); 
        System.out.println(log);
    }

}

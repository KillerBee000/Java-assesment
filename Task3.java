public class BankStatementBatchProcessor {
 
    private int processedCount = 0;
 
    public void process(List<StatementRecord> records) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
 
        for (StatementRecord record : records) {
            executor.submit(() -> {
                processRecord(record);
                synchronized (this) {
                    processedCount++;
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);
    }
 
    public int getProcessedCount() {
        return processedCount;
    }
}

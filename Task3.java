public class BankStatementBatchProcessor {
 
    // FIX: int++ is not thread-safe because multiple threads can update
    // the value simultaneously and lose increments.
    private AtomicInteger processedCount = new AtomicInteger(0);
 
    public void process(List<StatementRecord> records) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
 
        for (StatementRecord record : records) {
            executor.submit(() -> {
                processRecord(record);

                // FIX: Atomic increment prevents race condition
                processedCount.incrementAndGet();
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);
    }
 
    public int getProcessedCount() {
        return processedCount.get();
    }
}

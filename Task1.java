public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {
    List<LoanAccount> result = null;
 
    for (LoanAccount account : accounts) {
        if (account.getDueDate().before(new Date())) {
            if (account.getOutstandingBalance() > 0) {
                result.add(account);
            }
        }
    }
    return result;
}
 
// LoanAccount fields:
// Date dueDate          — may be null for restructured accounts
// double outstandingBalance
// String accountId      — always non-null


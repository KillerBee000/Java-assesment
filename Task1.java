getOverdueLoans(List<LoanAccount> accounts) {

    // FIX: Initialize result list instead of null
    List<LoanAccount> result = new ArrayList<>();

    // FIX: Handle null input list safely
    if (accounts == null) {
        return result;
    }

    Date currentDate = new Date();

    for (LoanAccount account : accounts) {

        // FIX: dueDate can be null for restructured accounts
        if (account.getDueDate() != null &&
            account.getDueDate().before(currentDate)) {
            if (account.getOutstandingBalance() > 0) {
                result.add(account);
            }
        }
    }

    return result;
}


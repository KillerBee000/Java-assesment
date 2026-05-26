/*
1. What is the exact cause of ConcurrentModificationException in Java?

ConcurrentModificationException occurs when a collection (such as
ArrayList) is structurally modified while it is being iterated using
an Iterator or enhanced for-loop, except through the iterator's own
methods. 


2. What code pattern at line 142 most likely triggered this error?

Most likely pattern:

for (Transaction t : transactions) {
    if (condition) {
        transactions.remove(t);   // triggers ConcurrentModificationException
    }
}




3. Provide the minimal code change (one or two lines) that resolves this safely.

Use Iterator.remove() instead of List.remove():

Iterator<Transaction> itr = transactions.iterator();

if (condition) itr.remove();
*/

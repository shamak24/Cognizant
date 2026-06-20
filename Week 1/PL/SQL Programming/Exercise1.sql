# SCENARIO 1
DECLARE
    CURSOR cust_cursor IS
        SELECT CustomerID,
               FLOOR(MONTHS_BETWEEN(SYSDATE, DOB)/12) AS Age
        FROM Customers;
BEGIN
    FOR cust_rec IN cust_cursor LOOP
        IF cust_rec.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = cust_rec.CustomerID;
        END IF;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Interest rate discount applied.');
END;

# SCENARIO 2
DECLARE
    CURSOR cust_cursor IS
        SELECT CustomerID, Balance
        FROM Customers;
BEGIN
    FOR cust_rec IN cust_cursor LOOP
        IF cust_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = cust_rec.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;

# SCENARIO 3
DECLARE
    CURSOR loan_cursor IS
        SELECT c.Name,
               l.LoanID,
               l.EndDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR loan_rec IN loan_cursor LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear ' || loan_rec.Name ||
            ', Loan ID ' || loan_rec.LoanID ||
            ' is due on ' ||
            TO_CHAR(loan_rec.EndDate,'DD-MON-YYYY')
        );
    END LOOP;
END;

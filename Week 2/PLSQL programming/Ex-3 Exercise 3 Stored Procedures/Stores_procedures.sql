

--------------------------------------------------------------------------------
-- Scenario 1: Monthly Interest on Savings Accounts
--------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  FOR acc IN (
    SELECT AccountID, Balance 
    FROM Accounts 
    WHERE AccountType = 'Savings'
  ) LOOP
    UPDATE Accounts
    SET Balance = Balance + (acc.Balance * 0.01),
        LastModified = SYSDATE
    WHERE AccountID = acc.AccountID;

    DBMS_OUTPUT.PUT_LINE('Interest applied to AccountID ' || acc.AccountID || 
                         '. New Balance: ' || TO_CHAR(acc.Balance * 1.01));
  END LOOP;
  COMMIT;
END;
/

--------------------------------------------------------------------------------
-- Scenario 2: Employee Bonus by Department
--------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  dept_name IN VARCHAR2,
  bonus_percent IN NUMBER
) IS
BEGIN
  FOR emp IN (
    SELECT EmployeeID, Salary 
    FROM Employees 
    WHERE Department = dept_name
  ) LOOP
    UPDATE Employees
    SET Salary = Salary + (emp.Salary * bonus_percent / 100)
    WHERE EmployeeID = emp.EmployeeID;

    DBMS_OUTPUT.PUT_LINE('Bonus applied to EmployeeID ' || emp.EmployeeID || 
                         '. New Salary: ' || TO_CHAR(emp.Salary * (1 + bonus_percent / 100)));
  END LOOP;
  COMMIT;
END;
/

--------------------------------------------------------------------------------
-- Scenario 3: Transfer Funds Between Accounts
--------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE TransferFunds(
  from_account IN NUMBER,
  to_account IN NUMBER,
  amount IN NUMBER
) IS
  from_balance NUMBER;
BEGIN
  SELECT Balance INTO from_balance FROM Accounts WHERE AccountID = from_account FOR UPDATE;

  IF from_balance < amount THEN
    DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient funds in AccountID ' || from_account);
  ELSE
    UPDATE Accounts SET Balance = Balance - amount, LastModified = SYSDATE WHERE AccountID = from_account;
    UPDATE Accounts SET Balance = Balance + amount, LastModified = SYSDATE WHERE AccountID = to_account;

    DBMS_OUTPUT.PUT_LINE('Transferred ' || amount || ' from AccountID ' || from_account || 
                         ' to AccountID ' || to_account);
  END IF;

  COMMIT;
END;
/

--------------------------------------------------------------------------------
-- Testing Section
--------------------------------------------------------------------------------
SET SERVEROUTPUT ON;

BEGIN
  ProcessMonthlyInterest;
END;
/

BEGIN
  UpdateEmployeeBonus('HR', 10);
END;
/

BEGIN
  TransferFunds(1, 2, 500);
END;
/

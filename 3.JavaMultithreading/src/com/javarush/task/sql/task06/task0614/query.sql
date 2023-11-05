update employee
set
salary = salary + 1000
WHERE employee.name IN (SELECT employee_id FROM task WHERE exp_date > '2022-10-01');
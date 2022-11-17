/*create table employee (
  id text(255),
  name text(255),
  gender text(255),
  phoneNum text(255),
  email text(255),
  designation text(255),
  salary text(255)
);

create table admin (
  username varchar(25) primary key,
  password varchar(25)
);
select * from employee;

insert into admin values
("admin","admin123"),
("admin2","0000");

insert into employee values
(142,"Jon Snow","Male","8454562158","jon@gmail.com","Associate",30000.0),
(127,"Robb Stark","Male","7654812345","robb@gmail.com","Manager",80000.0);
*/


CREATE TABLE employees (
    emp_no INT NOT NULL,
    birth_date DATE NOT NULL,
    first_name VARCHAR(14) NOT NULL,
    last_name VARCHAR(16) NOT NULL,
    gender VARCHAR(5) NOT NULL,
    hire_date DATE NOT NULL,
    PRIMARY KEY (emp_no)
);

insert into employees values
(1,"2002-10-15","Thien","Nguyen","Male","2020-01-01"),
(2,"2002-01-01","Nha","Nguyen","Male","2020-02-01");

CREATE TABLE departments (
    dept_no     VARCHAR(4)         NOT NULL, 
    dept_name   VARCHAR(40)     NOT NULL,
    PRIMARY KEY (dept_no),                 
    UNIQUE  KEY (dept_name)                
);

insert into departments values
("IT1","Machine learning"),
("IT2","Cloud service");

CREATE TABLE dept_emp (
    emp_no      INT         NOT NULL,
    dept_no     VARCHAR(4)     NOT NULL,
    from_date   DATE        NOT NULL,
    to_date     DATE        NOT NULL,
    KEY         (emp_no),   
    KEY         (dept_no),  
    FOREIGN KEY (emp_no) REFERENCES employees (emp_no) ON DELETE CASCADE,
    FOREIGN KEY (dept_no) REFERENCES departments (dept_no) ON DELETE CASCADE,
    PRIMARY KEY (emp_no, dept_no)
);

insert into dept_emp values
(1,"IT1","2020-01-01","2022-01-01"),
(2,"IT2","2020-02-01","2022-02-01");

CREATE TABLE dept_manager (
   dept_no      VARCHAR(4)  NOT NULL,
   emp_no       INT      NOT NULL,
   from_date    DATE     NOT NULL,
   to_date      DATE     NOT NULL,
   KEY         (emp_no),
   KEY         (dept_no),
   FOREIGN KEY (emp_no)  REFERENCES employees (emp_no)    ON DELETE CASCADE,
   FOREIGN KEY (dept_no) REFERENCES departments (dept_no) ON DELETE CASCADE,
   PRIMARY KEY (emp_no, dept_no) 
);

insert into dept_manager values
("IT1",1,"2019-01-01","2022-01-01"),
("IT2",2,"2019-02-01","2022-02-01");

CREATE TABLE titles (
    emp_no      INT          NOT NULL,
    title       VARCHAR(50)  NOT NULL,
    from_date   DATE         NOT NULL,
    to_date     DATE,
    KEY         (emp_no),
    FOREIGN KEY (emp_no) REFERENCES employees (emp_no) ON DELETE CASCADE,
    PRIMARY KEY (emp_no, title, from_date)
);

insert into titles values
(1,"Supervisor","2019-01-01","2022-01-01"),
(2,"Coordinator","2019-02-01","2022-02-01");

CREATE TABLE salaries (
    emp_no      INT    NOT NULL,
    salary      INT    NOT NULL,
    from_date   DATE   NOT NULL,
    to_date     DATE   NOT NULL,
    KEY         (emp_no),
    FOREIGN KEY (emp_no) REFERENCES employees (emp_no) ON DELETE CASCADE,
    PRIMARY KEY (emp_no, from_date)
);

insert into salaries values
(1,1500,"2020-01-01","2022-01-01"),
(2,1500,"2020-02-01","2022-02-01");


-- Stored Functions

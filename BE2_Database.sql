--  DROP database Library_Management_System;
CREATE DATABASE Library_Management_System;
use Library_Management_System;
-- Create
CREATE TABLE Users (
UserID varchar(50),
Name varchar(50) NOT NULL ,
Email varchar(50) NOT NULL ,
Phone varchar(50) NOT NULL ,
Address varchar(50) NOT NULL ,
DOB DATE NOT NULL ,
username varchar(50) NOT NULL ,
pass varchar(50) NOT NULL  ,
  PRIMARY KEY (UserID)
);
CREATE TABLE Staff (
StaffID varchar(50) NOT NULL ,
Name varchar(50) NOT NULL ,
Email varchar(50) NOT NULL ,
Phone varchar(50) NOT NULL ,
Address varchar(50) NOT NULL ,
DOB DATE NOT NULL ,
username varchar(50) NOT NULL ,
pass varchar(50) NOT NULL  ,
  PRIMARY KEY (StaffID)
);
CREATE TABLE Publishers (
PublisherID varchar(50) NOT NULL ,
Name varchar(50) NOT NULL ,
Email varchar(50) NOT NULL ,
Phone varchar(50) NOT NULL ,
Address varchar(50) NOT NULL ,
PRIMARY KEY (PublisherID)
);
CREATE TABLE Books (
ISBN varchar(50) NOT NULL ,
Title varchar(50) NOT NULL ,
Edition varchar(50) NOT NULL ,
Author varchar(50) NOT NULL ,
Category varchar(50) NOT NULL ,
Price int NOT NULL,
PublisherID varchar(50) NOT NULL,
-- isBorrow bool not null,
PRIMARY KEY (ISBN),
FOREIGN KEY (PublisherID) REFERENCES Publishers(PublisherID)
ON UPDATE CASCADE
);
CREATE TABLE Reports (
UserID varchar(50) NOT NULL ,
ISBN varchar(50) NOT NULL ,
date_issue DATE not null,
date_return DATE NOT NULL,
PRIMARY KEY (ISBN),
FOREIGN KEY (ISBN) REFERENCES Books(ISBN)
ON UPDATE CASCADE,
FOREIGN KEY (UserID) REFERENCES Users(UserID)
ON UPDATE CASCADE 
);
-- Insert
INSERT INTO Users VALUES ('SE181670','Luffy','luffy@gmail.com','0914749064','Quy Nhon','2004-07-01','Luffy','123');
INSERT INTO Users VALUES ('SE181671','Zoro','zoro@gmail.com','0914749064','Quy Nhon','2004-07-01','Zoro','123');
INSERT INTO Users VALUES ('SE181672','Phi Long','philongkokodudu@gmail.com','0914749064','Quy Nhon','2004-07-01','long123mlj','123');
INSERT INTO Users VALUES ('SE181673','Nami','nami@gmail.com','0914749064','Quy Nhon','2004-07-01','Nami','123');
INSERT INTO Users VALUES ('SE181674','Usopp','usopp@gmail.com','0914749064','Quy Nhon','2004-07-01','Usopp','123');
INSERT INTO Users VALUES ('SE181675','Franky','franky@gmail.com','0914749064','Quy Nhon','2004-07-01','Franky','123');
-- 
INSERT INTO Staff VALUES ('00000000','Sanji','sanj@gmail.com','0911290070','Quy Nhon','1990-07-02','Sanji','123');
INSERT INTO Staff VALUES ('00000001','Robin','robin@gmail.com','0911290070','Quy Nhon','1990-07-02','Robin','123');
INSERT INTO Staff VALUES ('00000002','Chopper','chopper@gmail.com','0911290070','Quy Nhon','1990-07-02','Chopper','123');
INSERT INTO Staff VALUES ('00000003','Brook','brook@gmail.com','0911290070','Quy Nhon','1990-07-02','Brook','123');
INSERT INTO Staff VALUES ('00000004','Jinbe','jinbe@gmail.com','0911290070','Quy Nhon','1990-07-02','Jinbe','123');
-- 
INSERT INTO Publishers VALUES ('NXB000','NXB Dong Nai','Dongnai123@gmail.com','1234567890','Ho Chi Minh');
INSERT INTO Publishers VALUES ('NXB001','NXB Hai Tac','haitac@gmail.com','1234567890','Ho Chi Minh');
INSERT INTO Publishers VALUES ('NXB002','NXB Hai Quan','haiquan@gmail.com','1234567890','Ho Chi Minh');
INSERT INTO Publishers VALUES ('NXB003','NXB Quan Cach Mang','quancachmang@gmail.com','1234567890','Ho Chi Minh');
--
INSERT INTO Books VALUES ('ISBN000000','De men phieu luu ki','1','To Hoai','Truyen ngan',5000,'NXB000');
INSERT INTO Books VALUES ('ISBN000001','Thuyen truong','1','To Hoai','Truyen ngan',5000,'NXB001');
INSERT INTO Books VALUES ('ISBN000002','Kiem si','1','To Hoai','Truyen ngan',5000,'NXB001');
INSERT INTO Books VALUES ('ISBN000003','Hoa tieu','1','To Hoai','Truyen ngan',5000,'NXB001');
INSERT INTO Books VALUES ('ISBN000004','Dau bep','1','To Hoai','Truyen ngan',5000,'NXB001');
INSERT INTO Books VALUES ('ISBN000005','Dau bep','1','To Hoai','Truyen ngan',5000,'NXB001');
--
INSERT INTO Reports VALUES ('SE181672','ISBN000000',CURDATE(),ADDDATE(CURDATE(), INTERVAL 10 DAY));
INSERT INTO Reports VALUES ('SE181671','ISBN000002',CURDATE(),ADDDATE(CURDATE(), INTERVAL 10 DAY));
INSERT INTO Reports VALUES ('SE181673','ISBN000003',CURDATE(),ADDDATE(CURDATE(), INTERVAL 10 DAY));
INSERT INTO Reports VALUES ('SE181670','ISBN000001',CURDATE(),ADDDATE(CURDATE(), INTERVAL 10 DAY));
INSERT INTO Reports VALUES ('SE181672','ISBN000004',CURDATE(),ADDDATE(CURDATE(), INTERVAL 10 DAY));
-- Function
-- insert
-- 1. Inser new user: INSERT INTO Users VALUES (id,name,mail,phone,address,dob,username,pass);
-- INSERT INTO Users VALUES ('SE181672','Phi Long','philongkokodudu@gmail.com','0914749064','Quy Nhon','2004-07-01','long123mlj','123');
-- 2.Inser new staff: INSERT INTO Staff VALUES (id,name,mail,phone,address,dob,username,pass);
-- INSERT INTO Staff VALUES ('123456','Long','lala@gmail.com','0911290070','Quy Nhon','1990-07-02','admin','123');
-- 3. Inser new publisher: INSERT INTO Publishers VALUES (PublisherID,name,mail,phone,address);
-- INSERT INTO Publishers VALUES ('NXBabc','NXB Dong Nai','Dongnai123@gmail.com','1234567890','Ho Chi Minh');
-- 4. Inser new book: INSERT INTO Books VALUES (ISBN,Title,Edition,Author,Category,Price,PublisherID);
-- INSERT INTO Books VALUES ('ISBN123456','De men phieu luu ki','1','To Hoai','Truyen ngan',5000,'NXB000',0);
-- 5. Inser new report: INSERT INTO Reports VALUES (UserID,ISBN,date_issue,date_return;
-- INSERT INTO Reports VALUES ('SE181672','ISBN000000','2023-09-19','2023-09-21');
-- select
-- 1. Select: 
-- a. id: SELECT * FROM Users WHERE UserUD = id; (staff)
SELECT * FROM Users WHERE UserID = 'SE181672';
SELECT * FROM Users WHERE username = 'Luffy' AND pass = '123';
SELECT * FROM Staff WHERE username = 'Sanji' AND pass = '123';
-- b. ISBN: SELECT * FROM Books WHERE ISBN= id; (staff,user)
SELECT ISBN, Title, Edition, Author, Category, Price,
CASE  
WHEN EXISTS (SELECT * FROM Reports WHERE ISBN= Books.ISBN) = 0 THEN 'Available'
WHEN EXISTS (SELECT * FROM Reports WHERE ISBN= Books.ISBN) = 1 THEN 'Not Available'
END AS isBorrow 
FROM Books WHERE ISBN= 'ISBN000001' ORDER BY ISBN;
-- 
   SELECT ISBN, Title, Edition, Author, Category, Price,
         CASE
         WHEN EXISTS (SELECT * FROM Reports WHERE ISBN= Books.ISBN) = 0 THEN
          'Available'
          WHEN EXISTS (SELECT * FROM Reports WHERE ISBN= Books.ISBN) = 1 THEN 'Not
          Available'
          END AS isBorrow
          FROM Books WHERE Author = 'To Hoai' ORDER BY ISBN; -- author
SELECT ISBN, Title, Edition, Author, Category, Price,
CASE  
WHEN EXISTS (SELECT * FROM Reports WHERE ISBN= Books.ISBN) = 0 THEN 'Available'
WHEN EXISTS (SELECT * FROM Reports WHERE ISBN= Books.ISBN) = 1 THEN 'Not Available'
END AS isBorrow
FROM Books WHERE Category = 'Truyen ngan' ORDER BY ISBN; -- category
--
-- SELECT * FROM Reports;
--
SELECT ISBN, Title, Edition, Author, Category, Price,
CASE  
WHEN EXISTS (SELECT * FROM Reports WHERE ISBN= Books.ISBN) = 0 THEN 'Available'
WHEN EXISTS (SELECT * FROM Reports WHERE ISBN= Books.ISBN) = 1 THEN 'Not Available'
END AS isBorrow
FROM Books INNER JOIN Publishers ON Books.PublisherID = Publishers.PublisherID
WHERE Publishers.PublisherID = 'NXB001' ORDER BY ISBN; -- publisher
--
SELECT ISBN, Title, Edition, Author, Category, Price,
CASE  
WHEN EXISTS (SELECT * FROM Reports WHERE ISBN= Books.ISBN) = 0 THEN 'Available'
WHEN EXISTS (SELECT * FROM Reports WHERE ISBN= Books.ISBN) = 1 THEN 'Not Available'
END AS isBorrow
FROM Books WHERE Title = 'Kiem si' ORDER BY ISBN; -- title
-- c. list user borrowing book (staff)
SELECT Users.UserID, Users.Name, Users.Email, Users.Phone, Books.ISBN, Books.Title, Reports.date_issue,Reports.date_return,
CASE
    WHEN Reports.date_return < CURDATE() THEN 'Late'
    WHEN Reports.date_return >= CURDATE() THEN 'NOT LATE'
END AS IsReturnLate,
CASE
    WHEN Reports.date_return < CURDATE() THEN 1000* DATEDIFF( Reports.date_return,CURDATE()) + Books.Price
    WHEN Reports.date_return >= CURDATE() THEN Books.Price
END AS Total_Fee
FROM Users
INNER JOIN Reports ON Users.UserID = Reports.UserID 
INNER JOIN Books ON Reports.ISBN= Books.ISBN
ORDER BY Users.UserID;
-- c. list book borrowing (user)
SELECT Books.ISBN, Books.Title, Reports.date_issue,Reports.date_return,
CASE
    WHEN Reports.date_return < CURDATE() THEN 'Late'
    WHEN Reports.date_return >= CURDATE() THEN 'NOT LATE'
END AS IsReturnLate,
CASE
    WHEN Reports.date_return < CURDATE() THEN 1000* DATEDIFF( Reports.date_return,CURDATE()) + Books.Price
    WHEN Reports.date_return >= CURDATE() THEN Books.Price
END AS Total_Fee
FROM Reports 
INNER JOIN Books ON Reports.ISBN= Books.ISBN
WHERE Reports.UserID = 'SE181672'
ORDER BY Books.ISBN;
--
-- 2.Update
UPDATE Users 
SET UserID = 'SE181670', Name = 'Luffy', Email = 'luffy@gmail.com', Phone = '0914749064', Address = 'Quy Nhon', DOB ='2004-07-01', username = 'Luffy', pass ='123'
WHERE UserID = 'SE181670' ; -- update user
-- 
UPDATE Staff 
SET StaffID = 'SE181670', Name = 'Luffy', Email = 'luffy@gmail.com', Phone = '0914749064', Address = 'Quy Nhon', DOB ='2004-07-01', username = 'Luffy', pass ='123'
WHERE StaffID = 'SE181670' ;-- update staff
-- 
UPDATE Books
SET ISBN= 'ISBN000001', Title = 'Thuyen truong', Edition = '1', Author='To Hoai',Category = 'Truyen ngan', Price = 5000, PublisherID= 'NXB001'
WHERE ISBN= 'ISBN000001'; -- update book
-- borrow/return 
INSERT INTO Reports VALUES ('SE181672','ISBN000005',CURDATE(),ADDDATE(CURDATE(), INTERVAL 10 DAY));
DELETE FROM Reports WHERE ISBN='ISBN000005';
-- 
UPDATE Users 
SET UserID = 'SE181670', Name = 'Luffy', Email = 'luffy@gmail.com', Phone = '0914749064', Address = 'Quy Nhon', DOB ='2004-07-01', username = 'Luffy', pass ='123'
WHERE UserID = 'SE1816790' ; 
UPDATE Books
SET ISBN= 'ISBN000001', Title = 'Thuyen truong', Edition = '1', Author='To Hoai',Category = 'Truyen ngan', Price = 5000, PublisherID= 'NXB001'
WHERE ISBN= 'ISBN000099'; -- update book
SELECT * FROM Reports;
UPDATE Publishers SET PublisherID = 'NXB000' 
WHERE PublisherID = 'NXB999';
SELECT * FROM Books;
SELECT * FROM Staff WHERE username ='Sanji' ;

-- SELECT * FROM Staff WHERE username = 'Sanji' AND pass = '123';
SELECT * FROM Staff WHERE username = 'Sanji' AND pass = '123';
SELECT * FROM Staff WHERE StaffID = '00000000';
SELECT * FROM Users WHERE UserID = 'SE181672';
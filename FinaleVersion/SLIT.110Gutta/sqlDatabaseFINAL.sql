CREATE TABLE Permission (
  adminid int(11) NOT NULL,
  type char(100) DEFAULT NULL,
  CONSTRAINT pk_Permission PRIMARY KEY (adminid)
);

CREATE TABLE User (
  userid INT NOT NULL auto_increment,
  email varchar(100) NOT NULL UNIQUE,
  firstname char(100) DEFAULT NULL,
  lastname char(100) DEFAULT NULL,
  password varchar(100) DEFAULT NULL,
  adminid int(11) DEFAULT NULL,
  CONSTRAINT pk_User PRIMARY KEY (userid),
  CONSTRAINT fk_User FOREIGN KEY (adminid) REFERENCES Permission (adminid)
);

CREATE TABLE Module (
  moduleid int(11) NOT NULL,
  modulename varchar(100) DEFAULT NULL,
  modulefilename VARCHAR(255),
  moduletypefile VARCHAR(255),
  modulefile longblob,
 CONSTRAINT pk_Module PRIMARY KEY (moduleid)
);

CREATE TABLE Delivery (
  userid int NOT NULL,
  moduleid int(11) NOT NULL,
filename VARCHAR(255),
typefile VARCHAR(255),
uploadtime timestamp default CURRENT_TIMESTAMP,
file mediumblob,
  CONSTRAINT pk_Delivery PRIMARY KEY (userid, moduleid),
  CONSTRAINT fk_Delivery_email FOREIGN KEY (userid) REFERENCES User(userid),
  CONSTRAINT fk_Delivery_moduleid FOREIGN KEY (moduleid) REFERENCES Module(moduleid)
);

CREATE TABLE Feedback (
userid int NOT NULL,
moduleid int(11) NOT NULL,
deliveryfeedback VARCHAR(255),
score int(2),
CONSTRAINT pk_Feedback PRIMARY KEY (userid, moduleid),
CONSTRAINT fk_Feedback_email FOREIGN KEY (userid) REFERENCES Delivery(userid),
CONSTRAINT fk_Feedback_moduleid FOREIGN KEY (moduleid) REFERENCES Delivery(moduleid)
);

INSERT INTO Permission (adminid, type) values
(1, "Foreleser"),
(2, "Student");



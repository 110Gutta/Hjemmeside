CREATE TABLE Permission (
  adminid int(11) NOT NULL,
  type char(100) DEFAULT NULL,
  CONSTRAINT pk_Permission PRIMARY KEY (adminid)
);

CREATE TABLE User (
  email varchar(100) NOT NULL,
  firstname char(100) DEFAULT NULL,
  lastname char(100) DEFAULT NULL,
  password varchar(100) DEFAULT NULL,
  adminid int(11) DEFAULT NULL,
  CONSTRAINT pk_User PRIMARY KEY (email),
  CONSTRAINT fk_User FOREIGN KEY (adminid) REFERENCES Permission (adminid)
);

CREATE TABLE Module (
  moduleid int(11) NOT NULL,
  modulename varchar(100) DEFAULT NULL,
  learninggoals varchar(255) DEFAULT NULL,
  moduletext varchar(255) DEFAULT NULL,
  modulefile longblob,
 CONSTRAINT pk_Module PRIMARY KEY (moduleid)
);

CREATE TABLE Delivery (
  email varchar(100) NOT NULL,
  moduleid int(11) NOT NULL,
  deliveryfile longblob,
  CONSTRAINT pk_Delivery PRIMARY KEY (email, moduleid),
  CONSTRAINT fk_Delivery_email FOREIGN KEY (email) REFERENCES User(email),
  CONSTRAINT fk_Delivery_moduleid FOREIGN KEY (moduleid) REFERENCES Module(moduleid)
);

CREATE TABLE Feedback (
email varchar(100) NOT NULL,
moduleid int(11) NOT NULL,
deliveryfeedback VARCHAR(255),
score int(2),
CONSTRAINT pk_Feedback PRIMARY KEY (email, moduleid),
CONSTRAINT fk_Feedback_email FOREIGN KEY (email) REFERENCES Delivery(email),
CONSTRAINT fk_Feedback_moduleid FOREIGN KEY (moduleid) REFERENCES Delivery(moduleid)
);
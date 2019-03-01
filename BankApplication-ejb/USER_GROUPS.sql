
/**
 * Author:  yashkhandha
 * Created: 05/10/2017
 */
-- SHA-256 hash value for 'admin' password
insert into USERS values(
NEXT VALUE FOR USER_SEQ,
'8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918',
'admin'
);
insert into GROUPS values(
NEXT VALUE FOR GROUP_SEQ,
'admin',
'admin'
);

insert into USERS values(
NEXT VALUE FOR USERS_SEQ,
'262CC47030B1803064844B94C1CB0054A247D1E550E26BB33F215149D8B2C72E',
'yash'
);
insert into GROUPS values(
NEXT VALUE FOR GROUPS_SEQ,
'users',
'yash'
);

-- alter 

alter table users
add constraint PK_USERID
primary key (id);


alter table groups 
add constraint FK_USER_GROUP
foreign key(USERNAME)
references USERS(ID);

--documentation
create table USERS (
id bigint,
username varchar(150) not null,
password varchar(150) not null,
primary key (id)
);

create table GROUPS (
id bigint,
groupname varchar(150) not null,
primary key(id)
);

create table USER_GROUP(
username varchar(150) not null, 
groupname varchar(150) not null
);

alter table USER_GROUP
add constraint FK_USER
foreign key(username)
references USERS(USERNAME);

drop USERS_SEQ;

create sequence USER_SEQ
start with 1
increment by 1;
create sequence GROUP_SEQ
start with 1
increment by 1;

insert into USERS values(
NEXT VALUE FOR USERS_SEQ,
'admin',
'8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918'
);
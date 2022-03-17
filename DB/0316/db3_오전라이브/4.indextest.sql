create database index_test;

use index_test;

create table board (
	no int auto_increment,
    subject varchar(100) not null,
    content varchar(4000) not null,
    name varchar(20),
    hit int default 0,
    test int,
    logtime timestamp default current_timestamp,
    constraint board_no_pk primary key (no)
);

create table reboard (
	no int
);

 alter table board add index board_test_idx (test);
 
 show index from board;
 
 explain select * 
from board
where no = 9000;

select * 
from board
where no between 9000 and 9500;

select * 
from board
where test between 9000 and 9500;

explain select * 
from board
where test = 9000






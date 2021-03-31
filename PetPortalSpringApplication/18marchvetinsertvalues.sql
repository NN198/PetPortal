use teams;
show tables;

select * from vets;
select * from pet;
select * from owner;
select * from appointment;
desc vets;

insert into vets values(1,'Nora','Jones','98','',2,500,'ANESTHESIA AND ANALGESIA');
insert into vets values(2,'Henry','Grant','98','',5,600,' ANIMAL WELFARE');
insert into vets values(3,'Parish','Patel','98','',6,700,'CLINICAL PHARMACOLOGY');
insert into vets values(4,'Chandan','Rajput','98','',7,800,'EMERGENCY AND CRITICAL CARE');

select * from owner;
insert into owner values(1,'rishabh','krishna','vikasnagar','etah',890873636);
insert into owner values(2,'samarth','dubey','jankipuramextension','lucknow',890874);
insert into owner values(3,'chitral','arora','jankipuram','amritsar',8908736);
insert into owner values(4,'harsh','singh','indiranagar','delhi',890873);
insert into owner values(5,'kamad','bhatt','badshahnagar','haldwani',8908736);

select * from pet;
insert into pet values(1,10,'cat','meow',20,1);
insert into pet values(2,9,'doge','sheru',30,2);
insert into pet values(3,8,'bat','corona',40,3);
insert into pet values(4,7,'lion','simba',50,4);
insert into pet values(5,6,'cheetah','bolt',60,1);


select * from appointment;

INSERT  INTO appointment VALUES (1, '2010-03-04','rabies shot', 'noella','13:00:00','12:00:00',1);
INSERT  INTO appointment VALUES (2, '2011-03-04','penguin ambush', 'harshit', '10:00:00','9:00:00',2);
INSERT  INTO appointment VALUES (3, '2009-06-04','brain hammerage', 'ankita', '11:00:00','10:00:00',3);
INSERT  INTO appointment VALUES (4, '2008-09-04','multiple organ failure', 'arpit', '12:00:00','11:00:00',1);






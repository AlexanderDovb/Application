/*
create table courses(
  idcs SERIAL primary key,
  namecs varchar(50) not null ,
  durationcs varchar(50) not null,
  freeplacescs int not null
);

create table students(
  idst SERIAL primary key,
  namest varchar(50) not null,
  surnamest varchar(50) not null,
  agest int not null
);

create table studentscourses(
  idst serial,
  idcs serial,
  foreign key(idst) references students(idst),
  foreign key(idcs) references courses(idcs)
);

insert into courses values ('1', 'Java Core', '64 hours', '10');
insert into courses values ('2', 'Java EE', '80 hours', '5');
insert into courses values ('3', 'Python', '60 hours', '8');
insert into courses values ('4', 'QA Junior', '64 hours', '7');
insert into courses values ('5', 'QA', '100 hours', '12');
insert into courses values ('6', 'Product Management', '50 hours', '3');
insert into courses values ('7', 'Golang', '80 hours', '10');
insert into courses values ('8', 'DevOps', '78 hours', '12');
insert into courses values ('9', 'PHP', '64 hours', '5');
insert into courses values ('10', 'Front-End', '100 hours', '6');

insert into students values ('1', 'Alexander', 'Dovbyshenko', '21');
insert into students values ('2', 'Alexander', 'Burgazli', '21');
insert into students values ('3', 'Victor', 'Osipov', '20');
insert into students values ('4', 'Ivan', 'Komashnia', '18');
insert into students values ('5', 'Elena', 'Avtutova', '17');
insert into students values ('6', 'Igor', 'Bilienko', '20');
insert into students values ('7', 'Anna', 'Zhuravchuk', '21');
insert into students values ('8', 'Ksenia', 'Shugayeva', '24');
insert into students values ('9', 'Nazar', 'Drimayev', '23');
insert into students values ('10', 'Maxim', 'Kostusev', '26');*/

-- Чтобы не было неожиданных 500, заменил id на значения из счетсиков которые есть в у каждой таблицы в постгресе, например nextval('plant_seq')
--- Потом нужно будет созвонится, объясню как это работает и зачем нужно

insert into plant values (nextval('plant_seq'), 1,'flower_rosa', 'rosa', '1a', '2022-01-01', 'www.rosa.com');
insert into plant values (nextval('plant_seq'), 2,'flower_cactus', 'cactus','2b', '2022-02-02', 'www.cactus.com');
insert into plant values (nextval('plant_seq') ,3,'flower_palm', 'palm','3c', '2022-03-03', 'www.palm.com');

insert into users values (nextval('user_seq'), null );
insert into users values (nextval('user_seq'), null );
insert into users values (nextval('user_seq'), null );

insert into plant_sponsor values (nextval('plant_sponsor_seq'), 1, 1);
insert into plant_sponsor values (nextval('plant_sponsor_seq'), 2, 1);
insert into plant_sponsor values (nextval('plant_sponsor_seq'), 3, 3);

insert into issue values (nextval('issue_seq'), '2022-01-01', 'not beautiful', null, 1);
insert into issue values (nextval('issue_seq'), '2022-02-02', 'not sharp', null, 2);
insert into issue values (nextval('issue_seq'), '2022-03-03', 'not green', null, 3);

insert into irrigation values (nextval('irrigation_seq'), 1, '2022-01-01', 1, 1);
insert into irrigation values (nextval('irrigation_seq'), 2, '2022-02-02', 2, 2);
insert into irrigation values (nextval('irrigation_seq'), 3, '2022-03-03', 3, 3);
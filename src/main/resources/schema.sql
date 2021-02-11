DROP TABLE IF EXISTS order_item;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS client_order;
create table client_order (id serial not null, address varchar(255), status varchar(255), telephone varchar(9), primary key (id));
create table item (id serial not null, description varchar(1024), name varchar(255), price numeric(19, 2), short_description varchar(255), primary key (id));
create table order_item (order_id int8 not null, item_id int8 not null);
alter table if exists order_item add constraint FKija6hjjiit8dprnmvtvgdp6ru foreign key (item_id) references item;
alter table if exists order_item add constraint FK9dm854t3ybtcsv86ro5lrin21 foreign key (order_id) references client_order;

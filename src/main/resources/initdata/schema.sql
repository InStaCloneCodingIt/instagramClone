drop table if exists user;


create table user(
                     user_id int primary key auto_increment,
                     email varchar(250) not null unique ,
                     password varchar(100) not null,
                     phone varchar(50) ,
                     gender varchar(10),
                     birth varchar(100),
                     name varchar(250) not null,
                     nickname varchar(250) not null unique,
                     website varchar(250),
                     introduce varchar(250),
                     profile_img varchar(250)
);


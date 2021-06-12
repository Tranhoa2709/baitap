create database qlhp;

use qlhp;

create table account(
id int primary key not null auto_increment,
username varchar(80) not null,
password varchar(80) not null
);

create table student(
	id int not null auto_increment primary key,
    maSV varchar(80) not null,
    hoTen varchar(255) not null,
    lopHoc varchar(80) not null,
    nienKhoa varchar(80) not null,
    maNganh varchar(80) not null
);

create table dsThuHocPhi(
	id int not null auto_increment primary key,
    maSV varchar(80) not null,
    kiHocDong int not null,
    namHoc int not null,
    ngayThuTien varchar(80) not null,
    nguoiThuTien varchar(255) not null,
    soTienDong int not null
);

create table dsNoHocPhi(
	id int not null auto_increment primary key,
    maSV varchar(90) not null,
    soTienConNo int not null,
    ngayDaoHan varchar(80) 
);

create table mucHocPhi(
	id int not null auto_increment primary key, 
    maNganh varchar(80) not null,
    namHoc int not null,
    soTien int not null
)


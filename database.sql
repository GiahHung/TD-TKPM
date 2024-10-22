create database qlyHangHoa;
use qlyHangHoa;

CREATE TABLE product (
    MaMh INT PRIMARY KEY auto_increment,
    productName VARCHAR(255),
    price INT,
    categoryKey VARCHAR(255),
    SL INT,
     NSX DATE  null,
    HSD DATE null,
    BH INT null,
    NhaSX VARCHAR(255) null,
    NhaCC VARCHAR(255) null,
    NNK DATE null,
    congSuat varchar(10) null
    
);

insert into product (product.Mamh,product.productName,product.price,product.categoryKey,product.Sl,product.dvt, NSX, HSD, BH, NhaSX, nhaCC, NNK, congsuat) values ("1","Chén","50000","c2","50","Cái", NULL, NULL, NULL, 'Bát tràng', NULL, '2024-10-10', NULL) ;
insert into product (product.Mamh,product.productName,product.price,product.categoryKey,product.Sl,product.dvt, NSX, HSD, BH, NhaSX, nhaCC, NNK, congsuat) values ("2","Thịt heo","100000","c1","30","Kg", "2024-10-1", "2024-10-17", NULL, Null, "aaa", null, NULL) ;
insert into product (product.Mamh,product.productName,product.price,product.categoryKey,product.Sl,product.dvt, NSX, HSD, BH, NhaSX, nhaCC, NNK, congsuat) values ("3","Tủ lạnh","5000000","c3","20","Cái", NULL, NULL, "12", null, NULL, null, "50") ;
insert into product (product.Mamh,product.productName,product.price,product.categoryKey,product.Sl,product.dvt, NSX, HSD, BH, NhaSX, nhaCC, NNK, congsuat) values ("4","Máy lạnh","4000000","c3","10","Cái", NULL, NULL, "5", null, NULL, null, "100") ;





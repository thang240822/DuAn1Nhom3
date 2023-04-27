drop database QLSHOP2
create database QLSHOP2
go
use QLSHOP2
go
---------------------------------
create table KhachHang
(
MaKH varchar(50) ,
TenKH nvarchar(50),
SDT varchar(12),
DiaChi nvarchar(500),
Email varchar(50)
constraint pk_kh primary key(MaKH)
)
create table NhanVien
(
MaNV varchar(50) ,
MatKhau varchar(50),
TenNV nvarchar(50),
GioiTinh bit,
VaiTro BIT NOT NULL DEFAULT 0,
constraint pk_nv primary key(MaNV)
)
create table SanPham
(
MaSP varchar(50) ,
NhanHieu nvarchar(50),
Ten nvarchar(500),
Mau nvarchar(50),
Size varchar(5),
SoLuong int,
GiaTien money,
constraint pk_sp primary key(MaSP)
)
create table HoaDon
(
MaHD varchar(50) ,
NgayLapHD date,
MaKH varchar(50),
ThanhTien money,
TrangThai nvarchar(50),
MaNV varchar(50)
constraint pk_hd primary key(MaHD),
foreign key (MaNV) references NhanVien(MaNV)  ,
foreign key (MaKH) references KhachHang(MaKH) ,
)
create table ChiTietHoaDon
(
MaHD varchar(50),
SoLuong int,
MaSP varchar(50),
constraint pk_cthd primary key(MaHD,MaSP),
foreign key (MaHD) references HoaDon(MaHD),
foreign key (MaSP) references SanPham(MaSP)  
)




INSERT INTO NhanVien(MaNV,MatKhau,TenNV,GioiTinh,VaiTro) VALUES 
('TQN','123',N'Trương Quang Nghĩa',0,0),
('TTT','123',N'Trương Thanh Tiến',0,0),
('NLMT','123',N'Ngô Lê Minh Thắng',0,1),
('PNQH','123',N'Phùng Nguyễn Quốc Huy',0,1),
('NND','123',N'Nguyễn Nhật Duy',0,0);
INSERT INTO SanPham(MaSP,NhanHieu,Ten,Mau,Size,SoLuong,GiaTien) VALUES
('A1','NIKE',N'Áo Nike Sportswear Faux Fur','Black','S',20,8000000),
('A2','NIKE',N'Áo Nike Sportswear Faux Fur','Black','M',20,4000000),
('B1','ADIDAS',N'Áo Adidas Essentials Track Jacket','White','S',20,1900000),
('B2','ADIDAS',N'Áo Adidas Essentials Track Jacket','White','M',20,1500000),
('C1','LACOSTE',N'Áo Thun Lacoste Men’s Form Slim Fit','Blue','S',20,7000000),
('C2','LACOSTE',N'Áo Thun Lacoste Men’s Form Slim Fit','Blue','M',20,3000000),
('D1','NIKE',N'Quần Nike Dri-FIT Men Tapered Fleece Training Pants','Black','S',20,2400000),
('D2','NIKE',N'Quần Nike Dri-FIT Men Tapered Fleece Training Pants','Black','M',20,2500000),
('E1','ADIDAS',N'QUẦN ADIDAS Z.N.E. SPORTSWEAR','Black','S',20,1300000),
('E2','ADIDAS',N'QUẦN ADIDAS Z.N.E. SPORTSWEAR','Black','M',20,1600000),
('F1','LACOSTE',N'Quần nam Lacoste Shorts Sport Two-Tone','Navy Red','S',20,2700000),
('F2','LACOSTE',N'Quần nam Lacoste Shorts Sport Two-Tone','Navy Red','M',20,2700000);
INSERT INTO KhachHang(MaKH,TenKH,SDT,DiaChi,Email) VALUES
('A11',N'Nguyễn Văn A','0377889911',N'G5 tổ 8, ấp Phước tân, xã Phước Tỉnh, huyện Long Điền, tỉnh BR-VT','vana@gmail.com'),
('A22',N'Nguyễn Văn B','0377889912',N'G6 tổ 1, ấp Phước tân, xã Phước Tỉnh, huyện Long Điền, tỉnh BR-VT','vanb@gmail.com'),
('A33',N'Nguyễn Thị C','0377889913',N'G7 tổ 2, ấp Phước tân, xã Phước Tỉnh, huyện Long Điền, tỉnh BR-VT','thic@gmail.com'),
('A44',N'Nguyễn Thị D','0377889914',N'G8 tổ 3, ấp Phước tân, xã Phước Tỉnh, huyện Long Điền, tỉnh BR-VT','thid@gmail.com'),
('A55',N'Nguyễn Văn E','0377889915',N'G9 tổ 4, ấp Phước tân, xã Phước Tỉnh, huyện Long Điền, tỉnh BR-VT','vane@gmail.com'),
('A66',N'Nguyễn Văn F','0377889916',N'G4 tổ 7, ấp Phước tân, xã Phước Tỉnh, huyện Long Điền, tỉnh BR-VT','vanf@gmail.com');
INSERT INTO HoaDon(MaHD,NgayLapHD,MaKH,ThanhTien,TrangThai,MaNV) VAlUES
('001','2021-01-01','A11','4000000',N'Đang vận chuyển','TQN'),
('002','2021-02-02','A22','12000000',N'Đã Hoàn thành','TTT'),
('003','2021-03-03','A33','2500000',N'Đã xác nhận đơn hàng','PNQH'),
('004','2021-04-04','A44','9500000',N'Đã xác nhận đơn hàng','NND'),
('005','2021-05-05','A55','2700000',N'Đã Hoàn thành','NLMT');

INSERT INTO ChiTietHoaDon(MaHD,SoLuong,MaSP) VALUES
('001',1,'A1'),
('002',1,'A1'),
('003',3,'A2'),
('004',1,'B2'),
('004',1,'B1'),
('005',1,'C1');
-------------------------------------------------------------------
--thong ke
go
CREATE PROC sp_ThongKeDoanhThu(@Year INT)
AS BEGIN 
	SELECT
	NhanHieu ThuongHieu,
	SUM(hd.ThanhTien) DoanhThu,
	MIN(hd.ThanhTien) ThapNhat,
	MAX(hd.ThanhTien) CaoNhat,
	AVG(hd.ThanhTien) TrungBinh
FROM SanPham sp 
	JOIN ChiTietHoaDon cthd ON sp.MaSP=cthd.MaSP 
	JOIN HoaDon hd ON hd.MaHD=cthd.MaHD
	WHERE YEAR(NgayLapHD) = @Year
	GROUP BY NhanHieu
END
exec sp_ThongKeDoanhThu 2021
--thongketonkho
go

create proc sp_thongketonkho
as
begin
	select SanPham.MaSP, SanPham.Ten,SanPham.NhanHieu,SanPham.Mau,
	SanPham.SoLuong-sum(ChiTietHoaDon.SoLuong) as soluongton 
	from SanPham, ChiTietHoaDon
	where SanPham.MaSP=ChiTietHoaDon.MaSP
	group by SanPham.MaSP,SanPham.Ten,SanPham.NhanHieu,SanPham.Mau,SanPham.SoLuong
		end
go
exec sp_thongketonkho
-------------------------------------------------------------------------------------------------

-- san pham ban chay nhat, it nhat
go
create proc top1sanpham
as
begin
		select top 1 Ten,count(ChiTietHoaDon.MaSP) as sanphambanchaynhat 
		from ChiTietHoaDon, SanPham
		where ChiTietHoaDon.MaSP=SanPham.MaSP
		group by Ten
		order by sanphambanchaynhat desc
		end
go
exec top1sanpham 
--cap nhap so luong ton
go
create proc CapNhapSoLuong(@masanpham varchar(50), @soluongban int)
as
update SanPham
set SoLuong=SoLuong-@soluongban
where MaSP=@masanpham
go
exec CapNhapSoLuong 'A1',3
select * from SanPham
--doanhthu
go
create proc doanhthu
as
begin
	select HoaDon.MaHD,sum(SanPham.SoLuong*SanPham.GiaTien) as doanhthu
	from ChiTietHoaDon,HoaDon,SanPham
	where HoaDon.MaHD=ChiTietHoaDon.MaHD and SanPham.MaSP=ChiTietHoaDon.MaSP
	group by HoaDon.MaHD
end
go
exec doanhthu
--sanphamchuabanlannao
go
create proc sanphamchuabanlannao
as
begin
	select MaSP,Ten
	from SanPham
	where MaSP not in (select MaSP from ChiTietHoaDon)
end
go
exec sanphamchuabanlannao
--tong tien cac mat hang
go
create proc tongtiencacmathang
as
begin
	select sum(SanPham.SoLuong*SanPham.GiaTien) as tongtiencacmathang
	from ChiTietHoaDon,HoaDon,SanPham
	where HoaDon.MaHD=ChiTietHoaDon.MaHD and SanPham.MaSP=ChiTietHoaDon.MaSP
		end
go
exec tongtiencacmathang
go
create proc ps_login(@pass nvarchar(50),@MaNV nvarchar(50)) 
as
begin
	select * from NhanVien
	where NhanVien.MaNV = @MaNV and NhanVien.MatKhau= @pass
end
go

exec ps_login '123', 'NLMT'
INSERT INTO HoaDon(MaHD,NgayLapHD,MaKH,ThanhTien,TrangThai,MaNV) VAlUES
('001','2021-01-01','A11','4000000',N'Đang vận chuyển','TQN')
INSERT INTO HoaDon (MaHD,NgayLapHD,MaKH,ThanhTien,TrangThai,MaNV) VALUES 
('Ac','','A22',700,N'dang giao','NLMT')
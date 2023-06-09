USE [QLSHOP3]
GO
/****** Object:  StoredProcedure [dbo].[CapNhapSoLuong]    Script Date: 4/7/2023 10:11:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[CapNhapSoLuong](@masanpham varchar(50), @soluongban int)
as
update SanPham
set SoLuong=SoLuong-@soluongban
where MaSP=@masanpham

GO
/****** Object:  StoredProcedure [dbo].[doanhthu]    Script Date: 4/7/2023 10:11:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[doanhthu]
as
begin
	select HoaDon.MaHD,sum(SanPham.SoLuong*SanPham.GiaTien) as doanhthu
	from ChiTietHoaDon,HoaDon,SanPham
	where HoaDon.MaHD=ChiTietHoaDon.MaHD and SanPham.MaSP=ChiTietHoaDon.MaSP
	group by HoaDon.MaHD
end

GO
/****** Object:  StoredProcedure [dbo].[ps_login]    Script Date: 4/7/2023 10:11:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[ps_login](@pass nvarchar(50),@MaNV nvarchar(50)) 
as
begin
	select * from NhanVien
	where NhanVien.MaNV = @MaNV and NhanVien.MatKhau= @pass
end

GO
/****** Object:  StoredProcedure [dbo].[sanphamchuabanlannao]    Script Date: 4/7/2023 10:11:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sanphamchuabanlannao]
as
begin
	select MaSP,Ten
	from SanPham
	where MaSP not in (select MaSP from ChiTietHoaDon)
end

GO
/****** Object:  StoredProcedure [dbo].[sp_ThongKeDoanhThu]    Script Date: 4/7/2023 10:11:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_ThongKeDoanhThu](@Year INT)
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

GO
/****** Object:  StoredProcedure [dbo].[sp_thongketonkho]    Script Date: 4/7/2023 10:11:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_thongketonkho]
as
begin
	select SanPham.MaSP, 
	SanPham.SoLuong-sum(ChiTietHoaDon.SoLuong) as soluongton 
	from SanPham, ChiTietHoaDon
	where SanPham.MaSP=ChiTietHoaDon.MaSP
	group by SanPham.MaSP,SanPham.SoLuong
		end

GO
/****** Object:  StoredProcedure [dbo].[tongtiencacmathang]    Script Date: 4/7/2023 10:11:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[tongtiencacmathang]
as
begin
	select sum(SanPham.SoLuong*SanPham.GiaTien) as tongtiencacmathang
	from ChiTietHoaDon,HoaDon,SanPham
	where HoaDon.MaHD=ChiTietHoaDon.MaHD and SanPham.MaSP=ChiTietHoaDon.MaSP
		end

GO
/****** Object:  StoredProcedure [dbo].[top1sanpham]    Script Date: 4/7/2023 10:11:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[top1sanpham]
as
begin
		select top 1 Ten,count(ChiTietHoaDon.MaSP) as sanphambanchaynhat 
		from ChiTietHoaDon, SanPham
		where ChiTietHoaDon.MaSP=SanPham.MaSP
		group by Ten
		order by sanphambanchaynhat desc
		end

GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 4/7/2023 10:11:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaHD] [varchar](50) NOT NULL,
	[SoLuong] [int] NULL,
	[MaSP] [varchar](50) NOT NULL,
 CONSTRAINT [pk_cthd] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC,
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 4/7/2023 10:11:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [varchar](50) NOT NULL,
	[NgayLapHD] [date] NULL,
	[MaKH] [varchar](50) NULL,
	[ThanhTien] [money] NULL,
	[TrangThai] [nvarchar](50) NULL,
	[MaNV] [varchar](50) NULL,
 CONSTRAINT [pk_hd] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 4/7/2023 10:11:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [varchar](50) NOT NULL,
	[TenKH] [nvarchar](50) NULL,
	[SDT] [varchar](12) NULL,
	[DiaChi] [nvarchar](500) NULL,
	[Email] [varchar](50) NULL,
 CONSTRAINT [pk_kh] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 4/7/2023 10:11:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [varchar](50) NOT NULL,
	[MatKhau] [varchar](50) NULL,
	[TenNV] [nvarchar](50) NULL,
	[GioiTinh] [bit] NULL,
	[NgaySinh] [date] NULL,
	[VaiTro] [bit] NOT NULL DEFAULT ((0)),
 CONSTRAINT [pk_nv] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 4/7/2023 10:11:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSP] [varchar](50) NOT NULL,
	[NhanHieu] [nvarchar](50) NULL,
	[Ten] [nvarchar](500) NULL,
	[Mau] [nvarchar](50) NULL,
	[Size] [varchar](5) NULL,
	[SoLuong] [int] NULL,
	[GiaTien] [money] NULL,
 CONSTRAINT [pk_sp] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [SoLuong], [MaSP]) VALUES (N'001', 1, N'A1')
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [SoLuong], [MaSP]) VALUES (N'002', 1, N'A1')
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [SoLuong], [MaSP]) VALUES (N'003', 3, N'A2')
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [SoLuong], [MaSP]) VALUES (N'004', 1, N'B1')
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [SoLuong], [MaSP]) VALUES (N'004', 1, N'B2')
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [SoLuong], [MaSP]) VALUES (N'005', 1, N'C1')
INSERT [dbo].[HoaDon] ([MaHD], [NgayLapHD], [MaKH], [ThanhTien], [TrangThai], [MaNV]) VALUES (N'001', CAST(N'2021-01-01' AS Date), N'A11', 4000000.0000, N'Đang vận chuyển', N'TQN')
INSERT [dbo].[HoaDon] ([MaHD], [NgayLapHD], [MaKH], [ThanhTien], [TrangThai], [MaNV]) VALUES (N'002', CAST(N'2021-02-02' AS Date), N'A22', 12000000.0000, N'Đã Hoàn thành', N'TTT')
INSERT [dbo].[HoaDon] ([MaHD], [NgayLapHD], [MaKH], [ThanhTien], [TrangThai], [MaNV]) VALUES (N'003', CAST(N'2021-03-03' AS Date), N'A33', 2500000.0000, N'Đã xác nhận đơn hàng', N'PNQH')
INSERT [dbo].[HoaDon] ([MaHD], [NgayLapHD], [MaKH], [ThanhTien], [TrangThai], [MaNV]) VALUES (N'004', CAST(N'2021-04-04' AS Date), N'A44', 9500000.0000, N'Đã xác nhận đơn hàng', N'NND')
INSERT [dbo].[HoaDon] ([MaHD], [NgayLapHD], [MaKH], [ThanhTien], [TrangThai], [MaNV]) VALUES (N'005', CAST(N'2021-05-05' AS Date), N'A55', 2700000.0000, N'Đã Hoàn thành', N'NLMT')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi], [Email]) VALUES (N'A11', N'Nguyễn Văn A', N'0377889911', N'G5 tổ 8, ấp Phước tân, xã Phước Tỉnh, huyện Long Điền, tỉnh BR-VT', N'vana@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi], [Email]) VALUES (N'A22', N'Nguyễn Văn B', N'0377889912', N'G6 tổ 1, ấp Phước tân, xã Phước Tỉnh, huyện Long Điền, tỉnh BR-VT', N'vanb@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi], [Email]) VALUES (N'A33', N'Nguyễn Thị C', N'0377889913', N'G7 tổ 2, ấp Phước tân, xã Phước Tỉnh, huyện Long Điền, tỉnh BR-VT', N'thic@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi], [Email]) VALUES (N'A44', N'Nguyễn Thị D', N'0377889914', N'G8 tổ 3, ấp Phước tân, xã Phước Tỉnh, huyện Long Điền, tỉnh BR-VT', N'thid@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi], [Email]) VALUES (N'A55', N'Nguyễn Văn E', N'0377889915', N'G9 tổ 4, ấp Phước tân, xã Phước Tỉnh, huyện Long Điền, tỉnh BR-VT', N'vane@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi], [Email]) VALUES (N'A66', N'Nguyễn Văn F', N'0377889916', N'G4 tổ 7, ấp Phước tân, xã Phước Tỉnh, huyện Long Điền, tỉnh BR-VT', N'vanf@gmail.com')
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [TenNV], [GioiTinh], [NgaySinh], [VaiTro]) VALUES (N'NLMT', N'123', N'Ngô Lê Minh Thắng', 0, CAST(N'2002-02-02' AS Date), 1)
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [TenNV], [GioiTinh], [NgaySinh], [VaiTro]) VALUES (N'NND', N'123', N'Nguyễn Nhật Duy', 0, CAST(N'2002-03-03' AS Date), 0)
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [TenNV], [GioiTinh], [NgaySinh], [VaiTro]) VALUES (N'PNQH', N'123', N'Phùng Nguyễn Quốc Huy', 0, CAST(N'2002-01-01' AS Date), 1)
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [TenNV], [GioiTinh], [NgaySinh], [VaiTro]) VALUES (N'TQN', N'123', N'Trương Quang Nghĩa', 0, CAST(N'2002-02-22' AS Date), 0)
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [TenNV], [GioiTinh], [NgaySinh], [VaiTro]) VALUES (N'TTT', N'123', N'Trương Thanh Tiến', 0, CAST(N'2001-09-17' AS Date), 0)
INSERT [dbo].[SanPham] ([MaSP], [NhanHieu], [Ten], [Mau], [Size], [SoLuong], [GiaTien]) VALUES (N'A1', N'NIKE', N'Áo Nike Sportswear Faux Fur', N'Black', N'S', 14, 8000000.0000)
INSERT [dbo].[SanPham] ([MaSP], [NhanHieu], [Ten], [Mau], [Size], [SoLuong], [GiaTien]) VALUES (N'A2', N'NIKE', N'Áo Nike Sportswear Faux Fur', N'Black', N'M', 20, 4000000.0000)
INSERT [dbo].[SanPham] ([MaSP], [NhanHieu], [Ten], [Mau], [Size], [SoLuong], [GiaTien]) VALUES (N'B1', N'ADIDAS', N'Áo Adidas Essentials Track Jacket', N'White', N'S', 20, 1900000.0000)
INSERT [dbo].[SanPham] ([MaSP], [NhanHieu], [Ten], [Mau], [Size], [SoLuong], [GiaTien]) VALUES (N'B2', N'ADIDAS', N'Áo Adidas Essentials Track Jacket', N'White', N'M', 20, 1500000.0000)
INSERT [dbo].[SanPham] ([MaSP], [NhanHieu], [Ten], [Mau], [Size], [SoLuong], [GiaTien]) VALUES (N'C1', N'LACOSTE', N'Áo Thun Lacoste Men’s Form Slim Fit', N'Blue', N'S', 20, 7000000.0000)
INSERT [dbo].[SanPham] ([MaSP], [NhanHieu], [Ten], [Mau], [Size], [SoLuong], [GiaTien]) VALUES (N'C2', N'LACOSTE', N'Áo Thun Lacoste Men’s Form Slim Fit', N'Blue', N'M', 20, 3000000.0000)
INSERT [dbo].[SanPham] ([MaSP], [NhanHieu], [Ten], [Mau], [Size], [SoLuong], [GiaTien]) VALUES (N'D1', N'NIKE', N'Quần Nike Dri-FIT Men Tapered Fleece Training Pants', N'Black', N'S', 20, 2400000.0000)
INSERT [dbo].[SanPham] ([MaSP], [NhanHieu], [Ten], [Mau], [Size], [SoLuong], [GiaTien]) VALUES (N'D2', N'NIKE', N'Quần Nike Dri-FIT Men Tapered Fleece Training Pants', N'Black', N'M', 20, 2500000.0000)
INSERT [dbo].[SanPham] ([MaSP], [NhanHieu], [Ten], [Mau], [Size], [SoLuong], [GiaTien]) VALUES (N'E1', N'ADIDAS', N'QUẦN ADIDAS Z.N.E. SPORTSWEAR', N'Black', N'S', 20, 1300000.0000)
INSERT [dbo].[SanPham] ([MaSP], [NhanHieu], [Ten], [Mau], [Size], [SoLuong], [GiaTien]) VALUES (N'E2', N'ADIDAS', N'QUẦN ADIDAS Z.N.E. SPORTSWEAR', N'Black', N'M', 20, 1600000.0000)
INSERT [dbo].[SanPham] ([MaSP], [NhanHieu], [Ten], [Mau], [Size], [SoLuong], [GiaTien]) VALUES (N'F1', N'LACOSTE', N'Quần nam Lacoste Shorts Sport Two-Tone', N'Navy Red', N'S', 20, 2700000.0000)
INSERT [dbo].[SanPham] ([MaSP], [NhanHieu], [Ten], [Mau], [Size], [SoLuong], [GiaTien]) VALUES (N'F2', N'LACOSTE', N'Quần nam Lacoste Shorts Sport Two-Tone', N'Navy Red', N'M', 20, 2700000.0000)
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([MaHD])
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO

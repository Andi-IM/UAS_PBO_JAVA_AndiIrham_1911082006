-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Waktu pembuatan: 23 Jun 2020 pada 11.38
-- Versi server: 5.7.24
-- Versi PHP: 7.2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `politeknikcontoh`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `no_bp` varchar(10) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jekel` varchar(10) NOT NULL,
  `tempatLahir` varchar(20) NOT NULL,
  `tanggalLahir` date NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `noTelepon` varchar(20) NOT NULL,
  `kdJurusan` varchar(2) NOT NULL,
  `kdProdi` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `mahasiswa`
--

INSERT INTO `mahasiswa` (`no_bp`, `nama`, `jekel`, `tempatLahir`, `tanggalLahir`, `alamat`, `noTelepon`, `kdJurusan`, `kdProdi`) VALUES
('1702021077', 'Morina Tokunaga', 'perempuan', 'Osaka', '2001-03-22', 'Chibubu, Osaka', '+8112290841', 'TM', 'TM002'),
('1702031033', 'Ahmad Hambali', 'laki-laki', 'Solok', '2000-03-13', 'Komplek Perumahan Dosen Unand Blok B3/11/04', '08231234321', 'TM', 'TM003'),
('1703011005', 'Richardo Simanjuntak', 'laki-laki', 'Mandailing Natal', '2000-03-20', 'Jalan Toba', '08247238123', 'TE', 'TE001'),
('1703012020', 'Rizal Ramlee', 'laki-laki', 'Bandung', '1998-12-05', 'Jalan Sitiung', '083147523821', 'TE', 'TE001'),
('1703052007', 'Shobirin Maulana', 'laki-laki', 'Padang', '2000-02-02', 'Komplek Unand Blok B', '08237849231', 'TE', 'TE005'),
('1704031056', 'Arif Nursahid', 'laki-laki', 'Bantul', '2001-05-01', 'Jl. Ringroad Timur No. 21, Bantul', '02745021223', 'TS', 'TS003'),
('1705021003', 'Suci Aurelia Puri', 'perempuan', 'Padang', '2000-03-02', 'Bunguih', '0784123123', 'AN', 'AN002'),
('1801022005', 'Khairul Amin Abdul Latif', 'laki-laki', 'Aceh Besar', '1999-01-01', 'Jalan By. Pass KM. 10, Padang', '08231239412', 'TI', 'TI002'),
('1802032026', 'Richard Feymann', 'laki-laki', 'GreenFields', '2020-01-01', 'Jalan Kabuto', '+1232452532', 'TM', 'TM003'),
('1803022001', 'Fathimah Az-Zahra', 'perempuan', 'Sawahlunto', '2000-08-07', 'Jalan Kenanga No. 1', '0824285732', 'TE', 'TE002'),
('1803051021', 'Ahmad Dahlan', 'laki-laki', 'Poso', '1999-05-13', 'Tanah Sirah', '0823123542', 'TE', 'TE005'),
('1804011005', 'Andini Khoiriyah', 'perempuan', 'Banjarnegara', '2001-02-14', 'Komplek Taruko ', '08524323412', 'TS', 'TS001'),
('1804012023', 'Irfan Syahputra', 'laki-laki', 'Palangkaraya', '2000-12-09', 'Komplek Cerdikiawan', '0823428723', 'TS', 'TS001'),
('1804021011', 'Alga Noor Hasanah', 'perempuan', 'Surakarta', '1999-07-08', 'Jl. Pisang No. 12 Surakarta', '085110003340', 'TS', 'TS002'),
('1901011003', 'Jerome Polin', 'laki-laki', 'Surabaya', '1999-10-31', 'Jl. Kapalo Koto', '08219248239', 'TI', 'TI003'),
('1901021015', 'Ahmad Affandi', 'laki-laki', 'Jakarta', '2001-05-31', 'Komplek Cendana No. 14 Padang', '08834212312', 'TI', 'TI002'),
('1902011002', 'Ahmad Hariawan', 'laki-laki', 'PadangPanjang', '2001-04-15', 'Komplek griya Insani ', '0822823921', 'TM', 'TM001'),
('1902012005', 'Rudy Hambali', 'laki-laki', 'Bukittinggi', '2003-02-22', 'Mess Polisi', '0820193123', 'TM', 'TM001'),
('1903021002', 'Chintya Rahma Ayunani', 'perempuan', 'Padang', '2001-02-15', 'Komplek Griya Insani Pemai No. 15', '08573482391', 'TE', 'TE002'),
('1903031011', 'Hatta Rajasa', 'laki-laki', 'Solo', '2002-10-07', 'Jalan Simpang Raja Ampat', '07519238721', 'TE', 'TE003'),
('1904022003', 'Hariyanto', 'laki-laki', 'Klaten', '2002-02-02', 'Jl. Pisang No.11 Surakarta', '0812423212', 'TS', 'TS002'),
('1904032024', 'Galih Wahyu', 'laki-laki', 'Surakarta', '2001-02-06', 'Jl. Kol. Ahmad Hosen No. 55 Surakarta', '+62823835531', 'TS', 'TS003'),
('1905011003', 'Tri Wahyu Putra', 'laki-laki', 'Muarolabuh', '2001-05-23', 'Jl. Andalas No. 14 Padang', '07512352412', 'AN', 'AN001'),
('1906021022', 'Muhammad Fajri', 'laki-laki', 'Padang', '2002-08-08', 'Jl. Bagindo Aziz Chan', '082383543241', 'AK', 'AK002'),
('1907012029', 'Furaidah', 'perempuan', 'Malang', '2001-01-05', 'Jl. Semarang No. 5', '0341123532', 'BI', 'BI001'),
('2001011001', 'Abdul Latif Sijabat', 'laki-laki', 'Medan', '2000-03-13', 'Jalan. Sitompul No. 15 Medan', '0823457321', 'TI', 'TI001'),
('2001012002', 'Annisa Azzahra', 'perempuan', 'Padang', '2002-07-09', 'Jalan Jend. Sudirman, Padang', '0882392123', 'TI', 'TI003'),
('2001012020', 'Kamado Tanjiro', 'laki-laki', 'Tohoku', '2000-02-19', 'Shibuya, Tokyo', '+0112715566', 'TI', 'TI001'),
('2002022022', 'Michida Haruno', 'perempuan', 'Kyoto', '2003-05-31', 'Yamanashi, Hokkaido', '+81092391824', 'TM', 'TM002'),
('2003032044', 'Rizal Mahfan At-Tirmidzi', 'laki-laki', 'Payakumbuh', '2020-01-01', 'Kompek Perumnas Indarung', '08528379842', 'TE', 'TE003'),
('2003041055', 'Ingga Pratama', 'laki-laki', 'Padang', '2000-03-19', 'Komplek Unand Blok B', '088212314532', 'TE', 'TE004'),
('2003042005', 'Annisa Al-Fatani', 'perempuan', 'Pasaman', '2020-01-01', 'Jalan Sebatas Kenangan', '0858923123', 'TE', 'TE004'),
('2004041001', 'Muklis', 'laki-laki', 'Mojokerto', '2001-08-06', 'Jalan Ki Hajar Dewantara No. 11 Klaten', '0272 3322442', 'TS', 'TS004'),
('2004042021', 'Miyanto', 'laki-laki', 'Brebes', '2000-06-19', 'Jalan Ki Hajar Dewantara No. 11 Klaten', '0272 4422131', 'TS', 'TS004'),
('2005022021', 'Kekeyi Kaka Kekeyu', 'perempuan', 'Bukittinggi', '2005-02-06', 'Komplek Perum. Griya Indah', '0723812312', 'AN', 'AN002'),
('2005022027', 'Jesica Iskandar', 'perempuan', 'Padang', '2020-01-01', 'Jl. Andalas No. 11', '0809223412', 'AN', 'AN001'),
('2006011002', 'Muhammad Fauzan', 'laki-laki', 'Padang', '2003-01-01', 'Jl. Dr. Soetomo No. 5', '085492398123', 'AK', 'AK001'),
('2006012004', 'Muhammad Faldi Dzaky', 'laki-laki', 'Padang', '2003-06-03', 'Jl. Dr. Soetomo No. 16', '085492398773', 'AK', 'AK001'),
('2006022002', 'Muhammad Fikri', 'laki-laki', 'Padang Panjang', '1997-02-01', 'Jl. Dr. Soetomo No. 5', '92463178683', 'AK', 'AK002'),
('2007011001', 'Zuliati Rohmah', 'perempuan', 'Surabaya', '2003-12-21', 'Jl. A Yani No. 11 Surabaya', '031849231', 'BI', 'BI001');

-- --------------------------------------------------------

--
-- Struktur dari tabel `prodi`
--

CREATE TABLE `prodi` (
  `kdjurusan` varchar(5) NOT NULL,
  `namajurusan` varchar(30) NOT NULL,
  `kdProdi` varchar(5) NOT NULL,
  `NamaProdi` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `prodi`
--

INSERT INTO `prodi` (`kdjurusan`, `namajurusan`, `kdProdi`, `NamaProdi`) VALUES
('AK', 'Akuntansi', 'AK001', 'D3 Akuntansi'),
('AK', 'Akuntansi', 'AK002', 'D4 Akuntansi'),
('AN', 'Administrasi Niaga', 'AN001', 'D3 Administrasi Bisnis'),
('AN', 'Administrasi Niaga', 'AN002', 'D3 Usaha Perjalanan Wisata'),
('BI', 'Bahasa Inggris', 'BI001', 'D3 Bahasa Inggris'),
('TE', 'Teknik Elektro', 'TE001', 'D3 Teknik Listrik'),
('TE', 'Teknik Elektro', 'TE002', 'D3 Teknik Elektro'),
('TE', 'Teknik Elektro', 'TE003', 'D3 Teknik Telekomunikasi'),
('TE', 'Teknik Elektro', 'TE004', 'D4 Teknik Elektro'),
('TE', 'Teknik Elektro', 'TE005', 'D4 Teknik Telekomunikasi'),
('TI', 'Teknologi Informasi', 'TI001', 'D3 Teknik Komputer'),
('TI', 'Teknologi Informasi', 'TI002', 'D3 Manajemen Informatika'),
('TI', 'Teknologi Informasi', 'TI003', 'D4 Rekayasa Perangkat Lunak'),
('TM', 'Teknik Mesin', 'TM001', 'D3 Teknik Mesin'),
('TM', 'Teknik Mesin', 'TM002', 'D3 Teknik Alat Berat'),
('TM', 'Teknik Mesin', 'TM003', 'D4 Teknik Manufaktur'),
('TS', 'Teknik Sipil', 'TS001', 'D3 Teknik Sipil'),
('TS', 'Teknik Sipil', 'TS002', 'D4 Perencanaan Irigasi Rawa'),
('TS', 'Teknik Sipil', 'TS003', 'D4 Manajemen Rek. Konstruksi'),
('TS', 'Teknik Sipil', 'TS004', 'D4 Perancangan Jalan Jembatan');

-- --------------------------------------------------------

--
-- Struktur dari tabel `uangkuliah`
--

CREATE TABLE `uangkuliah` (
  `nopembayaran` varchar(5) NOT NULL,
  `no_bp` varchar(10) NOT NULL,
  `semester` varchar(2) NOT NULL,
  `tahunAjaran` varchar(10) NOT NULL,
  `jenispembayaran` varchar(20) NOT NULL,
  `golongan` varchar(2) NOT NULL,
  `jumlah` bigint(20) NOT NULL,
  `tanggalpembayaran` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `uangkuliah`
--

INSERT INTO `uangkuliah` (`nopembayaran`, `no_bp`, `semester`, `tahunAjaran`, `jenispembayaran`, `golongan`, `jumlah`, `tanggalpembayaran`) VALUES
('NE001', '1702031033', '5', '2020/2021', 'e-Wallet', '5', 5000000, '2020-06-23 08:20:17'),
('TB001', '1702021077', '5', '2020/2021', 'Transfer Bank', '3', 2500000, '2020-06-23 08:19:26'),
('UK001', '2001011001', '1', '2020/2021', 'Tunai', '0', 0, '2020-06-23 00:54:45');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`no_bp`),
  ADD KEY `kdJurusan` (`kdJurusan`,`kdProdi`);

--
-- Indeks untuk tabel `prodi`
--
ALTER TABLE `prodi`
  ADD PRIMARY KEY (`kdjurusan`,`kdProdi`) USING BTREE;

--
-- Indeks untuk tabel `uangkuliah`
--
ALTER TABLE `uangkuliah`
  ADD PRIMARY KEY (`nopembayaran`),
  ADD KEY `nobp` (`no_bp`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD CONSTRAINT `mahasiswa_ibfk_1` FOREIGN KEY (`kdJurusan`,`kdProdi`) REFERENCES `prodi` (`kdjurusan`, `kdProdi`);

--
-- Ketidakleluasaan untuk tabel `uangkuliah`
--
ALTER TABLE `uangkuliah`
  ADD CONSTRAINT `uangkuliah_ibfk_1` FOREIGN KEY (`no_bp`) REFERENCES `mahasiswa` (`no_bp`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

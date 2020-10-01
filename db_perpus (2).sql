-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 02 Apr 2019 pada 12.05
-- Versi server: 10.1.38-MariaDB
-- Versi PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_perpus`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `pegawai`
--

CREATE TABLE `pegawai` (
  `pegawai` varchar(15) NOT NULL,
  `pas` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pegawai`
--

INSERT INTO `pegawai` (`pegawai`, `pas`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `perpus_new`
--

CREATE TABLE `perpus_new` (
  `isbn` varchar(20) NOT NULL,
  `judul` text NOT NULL,
  `kategori` text NOT NULL,
  `nama_pengarang` text NOT NULL,
  `nama_penerbit` text NOT NULL,
  `tahun_terbit` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `perpus_new`
--

INSERT INTO `perpus_new` (`isbn`, `judul`, `kategori`, `nama_pengarang`, `nama_penerbit`, `tahun_terbit`) VALUES
('00000000000000000002', 'Muah 2', 'Fiksi', 'Anda Hebat', 'Anda Production', '2005'),
('00000000000000000003', 'Seberang Jalan Warung Ayam', 'Non-Fiksi', 'Hebata Nda', 'Bathe Product', '2003'),
('00000000000000000004', 'Proyektor Masa Depan', 'Ilmiah', 'Pantu Tunpa', 'Pannap Write', '2009'),
('00000000000000000012', 'Muah 4', 'Fiksi', 'Anda Hebat', 'Anda Production', '2013');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_buku`
--

CREATE TABLE `tb_buku` (
  `isbn` varchar(20) NOT NULL,
  `judul` text NOT NULL,
  `kategori` text NOT NULL,
  `kode_penerbit` varchar(20) NOT NULL,
  `kode_pengarang` varchar(20) NOT NULL,
  `tahun_terbit` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_penerbit`
--

CREATE TABLE `tb_penerbit` (
  `kode_penerbit` varchar(20) NOT NULL,
  `nama` text NOT NULL,
  `alamat` text NOT NULL,
  `nomor_telepon` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_pengarang`
--

CREATE TABLE `tb_pengarang` (
  `kode_pengarang` varchar(20) NOT NULL,
  `nama` text NOT NULL,
  `jenis_kelamin` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `usser`
--

CREATE TABLE `usser` (
  `user` varchar(15) NOT NULL,
  `pass` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `usser`
--

INSERT INTO `usser` (`user`, `pass`) VALUES
('Kelvin', '1234'),
('SimKan', 'black');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`pegawai`);

--
-- Indeks untuk tabel `perpus_new`
--
ALTER TABLE `perpus_new`
  ADD PRIMARY KEY (`isbn`);

--
-- Indeks untuk tabel `tb_buku`
--
ALTER TABLE `tb_buku`
  ADD PRIMARY KEY (`isbn`),
  ADD KEY `k_p_fk` (`kode_penerbit`),
  ADD KEY `k_pe_fk` (`kode_pengarang`);

--
-- Indeks untuk tabel `tb_penerbit`
--
ALTER TABLE `tb_penerbit`
  ADD PRIMARY KEY (`kode_penerbit`);

--
-- Indeks untuk tabel `tb_pengarang`
--
ALTER TABLE `tb_pengarang`
  ADD PRIMARY KEY (`kode_pengarang`);

--
-- Indeks untuk tabel `usser`
--
ALTER TABLE `usser`
  ADD PRIMARY KEY (`user`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tb_buku`
--
ALTER TABLE `tb_buku`
  ADD CONSTRAINT `k_p_fk` FOREIGN KEY (`kode_penerbit`) REFERENCES `tb_penerbit` (`kode_penerbit`) ON UPDATE CASCADE,
  ADD CONSTRAINT `k_pe_fk` FOREIGN KEY (`kode_pengarang`) REFERENCES `tb_pengarang` (`kode_pengarang`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

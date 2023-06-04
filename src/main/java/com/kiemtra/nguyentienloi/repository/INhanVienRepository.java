package com.kiemtra.nguyentienloi.repository;

import com.kiemtra.nguyentienloi.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INhanVienRepository extends JpaRepository<NhanVien, String> {
}

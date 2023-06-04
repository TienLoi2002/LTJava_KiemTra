package com.kiemtra.nguyentienloi.service;

import com.kiemtra.nguyentienloi.entity.NhanVien;
import com.kiemtra.nguyentienloi.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NhanVienService {

    @Autowired
    private INhanVienRepository NhanVienRepository;

    public List<NhanVien> getAllNhanViens() {
        return NhanVienRepository.findAll();
    }

    public NhanVien getNhanVienById(String id) {
        Optional<NhanVien> optional = NhanVienRepository.findById(id);
        return optional.orElse(null);
    }

    public void addNhanVien(NhanVien NhanVien) {
        NhanVienRepository.save(NhanVien);
    }

    public void updateNhanVien(NhanVien NhanVien) {
        NhanVienRepository.save(NhanVien);
    }

    public void deleteNhanVien(String id) {
        NhanVienRepository.deleteById(id);
    }
    
}

package com.kiemtra.nguyentienloi.service;

import com.kiemtra.nguyentienloi.entity.PhongBan;
import com.kiemtra.nguyentienloi.repository.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PhongBanService {
    @Autowired
    private IPhongBanRepository PhongBanRepository;

    public List<PhongBan> getAllPhongBan() {
        return PhongBanRepository.findAll();
    }

    public PhongBan getPhongBanById(String id) {
        Optional<PhongBan> optionalPhongBan = PhongBanRepository.findById(id);

        if (optionalPhongBan.isPresent()) {
            return optionalPhongBan.get();
        } else {
            throw new RuntimeException("PhongBan not found");
        }
    }


    public PhongBan savePhongBan(PhongBan PhongBan) {
        return PhongBanRepository.save(PhongBan);
    }

    public void deletePhongBan(String id) {
        PhongBanRepository.deleteById(id);
    }

    public void addPhongBan(PhongBan PhongBan) {
        PhongBanRepository.save(PhongBan);
    }

    public void updatePhongBan(PhongBan PhongBan) {
        PhongBanRepository.save(PhongBan);
    }



}

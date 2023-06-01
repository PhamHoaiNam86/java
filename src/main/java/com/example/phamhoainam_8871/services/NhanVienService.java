package com.example.phamhoainam_8871.services;

import com.example.phamhoainam_8871.entity.NhanVien;
import com.example.phamhoainam_8871.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {

    @Autowired

    private INhanVienRepository nhanVienRepository;
    public List<NhanVien> getALLNhanViens () {

        return nhanVienRepository.findAll();
    }
    public NhanVien getNhanVienById(Long id) {
        Optional<NhanVien> optional = nhanVienRepository.findById(id);
        return optional.orElse(null);
    }
    public void addNhanVien (NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }
    public void updateNhanVien (NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    public void editNhanVien (NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }
    public void deleteNhanVien (Long id) {
        nhanVienRepository.deleteById(id);
    }

}

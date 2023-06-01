package com.example.phamhoainam_8871.repository;
import com.example.phamhoainam_8871.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface INhanVienRepository extends JpaRepository<NhanVien, Long>{
}

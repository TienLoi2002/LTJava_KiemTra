package com.kiemtra.nguyentienloi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@Table(name = "NHANVIEN")
public class NhanVien {
    @Id
    @NotBlank(message = "Trường này không được phép bỏ trống")
    @Length(min = 3, max = 3, message = "Phải nhập vào 3 ký tự bao gồm chữ và số")
    @Column(name = "Ma_NV")
    private String id;

    @NotBlank(message = "Trường này không được phép bỏ trống")
    @Length(min = 3, max = 100, message = "Phải nhập tên nhân viên")
    @Column(name = "Ten_NV")
    private String tenNV;

    @Length(max = 3, message = "Nhập giới tính")
    @Column(name = "Phai")
    private String phai;

    @Length( max = 200, message = "Nhập nơi sinh")
    @Column(name = "Noi_sinh")
    private String noiSinh;


    @ManyToOne(fetch = FetchType.LAZY)
    @Length(max = 2)
    @JoinColumn(name = "maPhong")
    private PhongBan phongBan;

    @Column(name = "Luong")
    private int luong;


}
package com.kiemtra.nguyentienloi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.List;

@Data
@Entity
@Table(name = "PHONGBAN")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhongBan {
    @Id
    @NotBlank(message = "Trường này không được phép bỏ trống")
    @Length(min = 2, max = 2, message = "Phải nhập vào 2 ký tự chữ viết tắt")
    private String maPhong;

    @Length(min = 2, max = 30, message = "Phải nhập vào tên phòng")
    private String tenPhong;

    @OneToMany(mappedBy = "phongBan", fetch = FetchType.LAZY)
    private List<NhanVien> listNhanviens;
}
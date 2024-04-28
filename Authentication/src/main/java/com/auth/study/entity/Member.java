package com.auth.study.entity;

import com.auth.study.common.MemberType;
import com.auth.study.dto.request.MemberUpdateRequest;
import com.auth.study.dto.request.SignUpRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Member {

    @Column(nullable = false, unique = true)
    private String account;

    @Column(nullable = false)
    private String password;

    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private MemberType type;

    private LocalDateTime createdAt;

    @Id
    @SequenceGenerator(name = "member_id_seq", sequenceName = "idx_member", allocationSize = 1)
    @GeneratedValue
    private BigInteger id;

    public static Member from(SignUpRequest request, PasswordEncoder encoder) {
        return Member.builder()
                .account(request.account())
                .password(encoder.encode(request.password()))
                .name(request.name())
                .age(request.age())
                .type(MemberType.USER)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public void update(MemberUpdateRequest newMember, PasswordEncoder encoder) {
        this.password = newMember.newPassword() == null || newMember.newPassword().isBlank()
                ? this.password : encoder.encode(newMember.newPassword());
        this.name = newMember.name();
        this.age = newMember.age();
    }
}

package com.auth.study.repository;

import com.auth.study.common.MemberType;
import com.auth.study.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, BigInteger> {
    Optional<Member> findByAccount(String account);
    List<Member> findAllByType(MemberType type);
}

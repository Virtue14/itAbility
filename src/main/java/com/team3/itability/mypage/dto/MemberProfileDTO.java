package com.team3.itability.mypage.dto;

import com.team3.itability.member.dto.MemberInfoDTO;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="member_profile_dto")
@Table(name="member_profile")
public class MemberProfileDTO {

    @Id
    @Column(name = "member_id")
    private Integer memberId;
    @Column(name = "nickname")
    private String nickname;

    // 연관 관계 설정 (MemberInfo)
    @OneToOne
    @MapsId
    @JoinColumn(name = "member_id")
    private MemberInfoDTO memberInfo;

    @OneToOne
    @JoinColumn(name = "img_id")
    private ImageDTO imgId;

    @ManyToOne
    @JoinColumn(name = "Degree_id")
    private DegreeDTO degreeId;

}

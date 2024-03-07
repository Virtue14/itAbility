package com.team3.itability.reple.dto;


import com.team3.itability.feed.dto.FeedDTO;
import com.team3.itability.member.dto.MemberInfoDTO;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "comment_dto")
@Table(name = "comment")
public class CommentDTO {

    @Id
    @Column(name = "cmt_id")
    private int cmtId;

    @Column(name = "write_date")
    private String writeDate;

    @Column(name = "report_count")
    private int reportCount;

    @JoinColumn(name = "board_id")
    @ManyToOne
    private FeedDTO boardId;

    @JoinColumn(name = "member_id")
    @ManyToOne
    private MemberInfoDTO memberId;

    @Column(name = "cmt_content")
    private String cmtContent;


}

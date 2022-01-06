package com.nepalaya.up.model;

import com.nepalaya.up.model.enums.FileType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_FILES")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class File extends BaseEntity<User> {

    @Column(length = 200, name = "OBJECT_ID", nullable = false)
    private String objectId;

    @Column(name = "TYPE", columnDefinition = "enum('ZIP','RAR', 'DOCX', 'DOC', 'PDF','PNG','JPG','JPEG','GIF','PPTX','PPT')", nullable = false)
    @Enumerated(EnumType.STRING)
    private FileType type;

    public File(Long id) {
        super(id);
    }
}

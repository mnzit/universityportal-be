package com.nepalaya.up.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "FILES")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class File extends BaseEntity<User> {

    @NotBlank
    @Size(min = 2, max = 150)
    @Column(name = "OBJECT_ID")
    private String objectId;

    @Basic(optional = true)
    @Column(name = "TYPE", columnDefinition = "enum('ZIP','RAR', 'DOCX', 'DOC', 'PDF','PNG','JPG','JPEG','GIF','PPTX','PPT')")
    @Enumerated(EnumType.STRING)
    private FileType type;

    public File(Long id) {
        super(id);
    }
}

package com.asaas.docs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileResponseDTO {

    private String publicId;
    private String originalName;
    private int size;
    private String extension;
    private String previewUrl;
    private String downloadUrl;

}
